/*
  YARA rules for trojanized TierTagger JAR delivering Optimizer11 stage-2
  Sample: "krypton client-2.4.0+mc1.21.11 (1) (ni--aware).jar" (184328 bytes)
  SHA256: 88B870964CC6230D12BD9DA6EE91B9692ACD8C349C657CAACF635361D6592BF3
  Static-only analysis, no execution. C2 was dead at analysis time.

  IMPORTANT - JAR compression note:
  Java JARs are ZIPs with DEFLATE-compressed entries. Raw-JAR scans only see
  ZIP central-directory filenames, NOT decompressed class strings. Hence:
   - Rule 1 (CONTAINER) targets raw .jar files via entry NAMES only.
   - Rule 2 (EXTRACTED) targets extracted/decompressed LoaderMod.class,
     javap output, or decompiled .java (run after unzip -p / jd-cli).
   - Rule 3 (MEMORY) is a loose in-memory / log scanner for stage-2 refs.

  Usage:
    yara Optimizer11_Loader_CONTAINER.yar mods/*.jar
    unzip -p suspect.jar com/example/loader/LoaderMod.class | yara Optimizer11_Loader_EXTRACTED.yar -
*/

rule Optimizer11_Loader_CONTAINER_JAR
{
  meta:
    description = "Raw-JAR container detector: trojanized Fabric mod with com/example/loader stage-1 file layout (LoaderMod + MemoryClassLoader + ClientMixin + A.txt + .optimizer-loader). Works on compressed JARs via central-directory names."
    sample_sha256 = "88B870964CC6230D12BD9DA6EE91B9692ACD8C349C657CAACF635361D6592BF3"
    sample_sha1 = "D82BDDB7F126CEEBC10DD11693195CC9B39E6B28"
    sample_md5 = "7FC0CF02AB7574203DCA70ACB13C8D56"
    file_size = "184328"
    date = "2026-10-03"
    confidence = "high"
    stage = "stage-1 container"
    how = "match ZIP entry names only, no decompression needed"

  strings:
    $path_loader = "com/example/loader/LoaderMod.class" ascii
    $path_memloader = "com/example/loader/MemoryClassLoader.class" ascii
    $path_mixin = "com/example/loader/mixin/ClientMixin.class" ascii
    $file_atxt = "A.txt" ascii
    $file_optflag = ".optimizer-loader" ascii

  condition:
    uint32(0) == 0x04034b50
    and filesize < 10MB
    and 2 of ($path_*)
    and 1 of ($file_*)
}

rule Optimizer11_Loader_EXTRACTED_Stage1
{
  meta:
    description = "Extracted stage-1 detector: run on decompressed LoaderMod.class / javap / decompiled source. Covers reversed C2, stage-2 class refs, stealer method names, spreader paths, and lure logs."
    date = "2026-10-03"
    confidence = "high"
    stage = "stage-1 extracted"
    how = "unzip -p suspect.jar com/example/loader/LoaderMod.class and scan result"

  strings:
    // C2 stored reversed; decodes to hxxps://<c2>/api/download/optimizer11.jar (see report)
    $c2_reversed = "raj.11rezimitpo/daolnwod/ipa/ur.erawaggin//:sptth" ascii
    $c2_jar = "optimizer11.jar" ascii
    $c2_api = "/api/download/" ascii

    // In-memory stage-2 expectations
    $st2_entry = "com.example.optimizer.LoaderEntry" ascii
    $st2_entry_path = "com/example/optimizer/LoaderEntry" ascii
    $st2_session = "com.example.optimizer.SessionUtil" ascii
    $st2_data = "com.example.optimizer.DataUtil" ascii
    $st2_m_send = "sendMinecraft" ascii
    $st2_m_theft = "performFullTheft" ascii

    // Stage-1 config / loader internals
    $cfg_atxt = "A.txt" ascii
    $cfg_key = "aTxtContent" ascii
    $cfg_missing = "A.txt not found in resources" ascii
    $cfg_placeholder = "PLACEHOLDER" ascii
    $cfg_memloader = "MemoryClassLoader" ascii
    $cfg_mixin_target = "net/minecraft/class_310" ascii

    // Disguise / status logs
    $log_init = "Performance Tweaks initializing... (v3)" ascii
    $log_dl = "Downloading optimization module from " ascii
    $log_parse = "bytes, parsing..." ascii
    $log_entry = "Loading entry point class..." ascii
    $log_ok = "Optimization module initialized successfully" ascii
    $log_direct = "Starting direct player detection..." ascii
    $log_wait = "Waiting for player to join world..." ascii
    $log_perf = "performance-tweaks" ascii

    // Persistence / spreader (scanAndInfect + copyTo)
    $persist_a = "fabric-utils.0.12.jar" ascii
    $persist_b = "modmenus.0.1.jar" ascii
    $persist_p1 = "curseforge/minecraft/Instances" ascii
    $persist_p2 = "PrismLauncher/instances" ascii
    $persist_p3 = "com.modrinth.theseus/profiles" ascii
    $persist_p4 = ".minecraft/mods" ascii
    $persist_p5 = "Feather/user-profiles" ascii
    $persist_p6 = "GDLauncher/instances" ascii
    $persist_scan = "scanAndInfect" ascii

    // Threads / beacon
    $thread_pworker = "P-Worker" ascii
    $thread_detector = "DirectPlayerDetector" ascii
    $beacon_mode = "loader_direct" ascii
    $beacon_env = "executionEnvironment" ascii

  condition:
    filesize < 5MB
    and $c2_reversed
    and 1 of ($c2_*)
    and 1 of ($st2_*)
    and 1 of ($cfg_*)
    and 2 of ($persist_*)
    and 2 of ($log_*, $thread_*, $beacon_*)
}

rule Optimizer11_Loader_Artifacts_Memory
{
  meta:
    description = "Loose memory/log detector for Optimizer11 stage-1/2 artifacts. Use on dumps, logs, or decompiled trees."
    date = "2026-10-03"
    confidence = "medium"
    note = "No ZIP header requirement; matches dumps and .javap/.java text"

  strings:
    $st2_entry = "com.example.optimizer.LoaderEntry" ascii
    $st2_session = "com.example.optimizer.SessionUtil" ascii
    $st2_data = "com.example.optimizer.DataUtil" ascii
    $m_send = "sendMinecraft" ascii
    $m_theft = "performFullTheft" ascii
    $memloader = "MemoryClassLoader" ascii
    $log_dl = "Downloading optimization module from " ascii
    $log_ok = "Optimization module initialized successfully" ascii
    $thread_detector = "DirectPlayerDetector" ascii
    $beacon_mode = "loader_direct" ascii
    $persist_a = "fabric-utils.0.12.jar" ascii
    $persist_b = "modmenus.0.1.jar" ascii
    $c2_reversed = "raj.11rezimitpo/daolnwod/ipa/ur.erawaggin//:sptth" ascii
    $c2_jar = "optimizer11.jar" ascii

  condition:
    filesize < 20MB
    and 3 of them
    and 1 of ($st2_*, $m_send, $m_theft)
}
