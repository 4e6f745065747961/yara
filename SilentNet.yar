rule silentnet_jar_dropper_structural {
  meta:
    family      = "SilentNet"
    stage       = "stage1-jar"
    confidence  = "high"
    description = "SilentNet Stage-1 Java/Fabric loader JAR: fabric.mod.json + net/fabric obfuscated class entries + entrypoint main class"
    reference   = "entrypoint=net.fabric.PxibF0 (fabric.mod.json), Main-Class=net.fabric.gtI"

  strings:
    $fabric   = "fabric.mod.json" ascii
    $mc_entry = "net/fabric/PxibF0.class" ascii
    $cls_1    = "net/fabric/gtI.class" ascii
    $cls_2    = "net/fabric/pumkdmXmuofa.class" ascii
    $cls_3    = "net/fabric/lDYyOSFGzNWbBC.class" ascii
    $cls_4    = "net/fabric/emnnr_sxvzsk.class" ascii

  condition:
    uint16(0) == 0x4B50 and filesize < 30MB and
    (
      ( $fabric and $mc_entry ) or
      3 of ($cls_*)
    )
}

rule silentnet_stage1_clean_strings {
  meta:
    family      = "SilentNet"
    stage       = "stage1-clean"
    confidence  = "high"
    description = "SilentNet Stage-1 plaintext markers (deobfuscated Java sources / unpacked stage-1)"

  strings:
    $p1  = "AppHost" ascii wide
    $p2  = "LOCALAPPDATA" ascii wide
    $p3  = "_spawn.log" ascii wide
    $p4  = "_stealer.log" ascii wide
    $p5  = "main.py" ascii wide
    $p6  = "python.exe" ascii wide
    $p7  = "X-Runtime-Env" ascii wide
    $p8  = "getDomain" ascii wide
    $p9  = "prefire" ascii wide
    $p10 = "0xce6d41de" ascii wide nocase
    $p11 = "polygon" ascii wide nocase
    $p12 = "drpc.org" ascii wide nocase

  condition:
    ( $p1 and 1 of ($p3, $p4, $p5, $p6, $p7) ) or
    ( 3 of ($p*) )
}

rule silentnet_stage2_bundle {
  meta:
    family      = "SilentNet"
    stage       = "stage2-python-bundle"
    confidence  = "high"
    description = "SilentNet Stage-2 unpacked bundle: NtProfileIndex/python.exe + AppHost/app.pyd + AppHost/main.py + python312.zip"
    scope_note  = "Stage-2 is downloaded at runtime and NOT shipped inside the supplied Java/Fabric JAR; these are family-wide bundle IOCs"

  strings:
    $a1  = "AppHost" ascii wide
    $a2  = "NtProfileIndex" ascii wide nocase
    $a3  = "NtProfileSync" ascii wide
    $a4  = "X-Runtime-Env" ascii wide
    $a5  = "jre-embedded" ascii wide
    $a6  = "/shard/submitData" ascii wide
    $a7  = "/shard/submitLogs" ascii wide
    $a8  = "/shard/prefireMc" ascii wide
    $a9  = "/cdn/e/" ascii wide
    $a10 = "python312.zip" ascii wide
    $a11 = "staging-worker" ascii wide
    $a12 = "74af664f79d1ef1436a4bf301788c7eb207570de60034b19d76df8e7aefc69b7" ascii wide nocase
    $a13 = "x-cdn-origin-verify" ascii wide nocase
    $a14 = "trusted-upstream" ascii wide
    $main_py_loader_1 = "spec_from_file_location" ascii wide
    $main_py_loader_2 = "spec.loader.exec_module" ascii wide

  condition:
    ( $a2 and 1 of ($a1, $a3, $a4, $a10) ) or
    ( 2 of ($a3, $a4, $a6, $a7, $a8, $a11, $a12, $a13) ) or
    ( all of ($main_py_loader_*) and $a1 )
}

rule silentnet_c2_indicators {
  meta:
    family      = "SilentNet"
    stage       = "c2-blockchain-crypto"
    confidence  = "medium"
    description = "SilentNet network / blockchain / crypto IOCs (confirm with another rule before deleting)"
    scope_note  = "Includes IOCs shared with the older SilentNet build plus this variant's .drpc.org / polygon infrastructure"

  strings:
    $d1   = "thisisafalsepositive.st" ascii wide nocase
    $d2   = "sltnnt.ru" ascii wide nocase
    $d3   = "silentnet.st" ascii wide nocase
    $d4   = "drpc.org" ascii wide nocase
    $ip1  = "185.178.208.191" ascii wide
    $ip2  = "185.178.208.165" ascii wide
    $ct1  = "0x9c0a507300fd902787bb193d80fca5ce6e1bff9a" ascii wide nocase
    $ct2  = "0x6767c6496541b530a5d1d0eb9b80bd5c7bf56767" ascii wide nocase
    $sel  = "ce6d41de" ascii wide nocase
    $hdr1 = "X-Runtime-Env" ascii wide
    $hdr2 = "X-Edge-Cache-Revalidate" ascii wide
    $hdr3 = "x-cdn-origin-verify" ascii wide
    $url1 = "/cdn/e/" ascii wide
    $url2 = "/shard/submitData" ascii wide
    $url3 = "/shard/submitLogs" ascii wide
    $url4 = "/shard/prefireMc" ascii wide
    $url5 = "/shard/submitFile" ascii wide
    $key  = "74af664f79d1ef1436a4bf301788c7eb207570de60034b19d76df8e7aefc69b7" ascii wide nocase
    $pipe = "NtProfileSync" ascii wide
    $spawn = "_spawn.log" ascii wide

  condition:
    ( 1 of ($d1, $d2, $d3, $d4, $ip1, $ip2, $ct1) and 1 of ($hdr1, $url1, $url2, $url3, $url4, $key, $pipe, $spawn, $sel) ) or
    ( 3 of ($*) )
}
