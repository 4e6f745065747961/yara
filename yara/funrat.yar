/*
    YARA rules for FunRat: multi-stage Fabric loader, Windows collection
    implant, and Discord token stealer/spam module
    -------------------------------------------------------------------
    Samples analysed:
      Loader:
        File:    samples/sample-funrat.jar (original: sample "funrat".jar)
        SHA-256: d34fe879a58a317253f2b3b38d023d1b0df22bad67144d4d40e7cb49cd80146b
        SHA-1:   62c0db980d94433921ef6d6012b3d194ed636066
        MD5:     2e6b17168249dbcfd9fcd7ee53d7d5fd
        Size:    60539 bytes
      Stage 1:
        File:    samples/stage-funrat.jar (core.core)
        SHA-256: eb80cf584e05fdfc63949870acf8b0ad8972b1ed5343583c845a98299b8167f9
        SHA-1:   49e5fd6eff74573c5fba66f2712cf048231882e2
        MD5:     c730d8846abbc68fd95bff79e7c54131
        Size:    5655 bytes
        Class:   core/core.class, 9416 bytes, SHA-256
                 147daae7ee8487c698ce5eaa3b4e6bda28cee2e459d085729971b31f747d83ed

      Stage 3:
        File:    JavaInt.jar
        SHA-256: bf2c9723acf2d4ea5971169368ed384e57399177b0f59ed627744df7b07dd822
        Size:    23229672 bytes
      Stage 4:
        File:    dis.jar
        SHA-256: 9bcb73a6c5277e1c9be247b29e39f9f41d929235fa09f61064f5712ec9e832bc
        Size:    5773961 bytes

    Notes:
      * The loader stores almost every behavioural string (C2 hosts, paths,
        JSON fragments, log messages) as encoded constants and decodes them at
        runtime with aurora.quake.otter(). Therefore:
          - FunRat_Loader_JAR_Archive matches the raw JAR/ZIP (entry names are
            stored in clear).
          - The FunRat_Loader_Class_* rules match extracted .class files using
            structural strings and the exact encoded constants present in this
            sample.
          - FunRat_Decoded_Indicators and FunRat_Report_Protocol_Decoded match
            memory dumps / unpacked or deobfuscated files where the decoded
            strings exist.
      * The stage class is not obfuscated. Its strings are visible in the
        extracted class, so the class/decoded rules match the class or memory.
        The class is deflated inside the JAR, so class-string rules do not match
        the raw archive; the raw JAR is covered by the exact-hash rule and the
        stored-manifest archive rule.
      * FunRat_Stage_JAR_CoreClass is retained as a low-confidence container
        rule for unseen variants; the new stage rules are higher confidence.
      * Stage 3 encodes its behavioural strings. Raw-JAR coverage uses entry
        names, extracted-class coverage uses method names, and the decoded rule
        targets memory/unpacked files.
      * Stage 4 leaves most strings in clear. Its class/decoded rules can also
        match analysis notes and README text, so exclude analysis directories
        from production scans.

    Author: Krotten
    Date:   2026-10-23
    TLP:    WHITE
*/

import "hash"


rule FunRat_Sample_KnownHash
{
    meta:
        description = "Exact known sample of the FunRat Fabric loader"
        author = "Krotten"
        date = "2026-10-23"
        sample_sha256 = "d34fe879a58a317253f2b3b38d023d1b0df22bad67144d4d40e7cb49cd80146b"
        severity = "high"
        confidence = "high"
    condition:
        filesize == 60539 and
        hash.sha256(0, filesize) == "d34fe879a58a317253f2b3b38d023d1b0df22bad67144d4d40e7cb49cd80146b"
}


rule FunRat_Loader_JAR_Archive
{
    meta:
        description = "Fabric mod JAR containing the FunRat loader class set"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "raw JAR/ZIP"
    strings:
        $e1 = "aurora/rattle.class" ascii
        $e2 = "aurora/orchid.class" ascii
        $e3 = "aurora/sardine.class" ascii
        $e4 = "aurora/sherbet.class" ascii
        $e5 = "aurora/quake.class" ascii
        $e6 = "aurora/stumble.class" ascii
        $e7 = "fabric.mod.json" ascii
        $e8 = "META-INF/MANIFEST.MF" ascii
        $pkg = "aurora/" ascii
    condition:
        uint32be(0) == 0x504B0304 and
        filesize < 5MB and
        $e7 and $e8 and
        all of ($e1, $e2, $e3, $e4, $e5, $e6) and
        #pkg >= 12
}


rule FunRat_Loader_Class_Orchid
{
    meta:
        description = "FunRat Fabric client entrypoint (aurora.orchid)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "aurora/orchid" ascii
        $c2 = "aurora/rattle" ascii
        $c3 = "aurora/sardine" ascii
        $c4 = "aurora/sherbet" ascii
        $c5 = "aurora/quake" ascii
        $c6 = "aurora/stumble" ascii
        $m1 = "onInitializeClient" ascii
        $m2 = "ClientModInitializer" ascii
        $m3 = "cradle" ascii
        $m4 = "plankton" ascii
        $m5 = "sturdy" ascii
        $m6 = "momkkkgk-jhnakghe-nfnalh" ascii
        $m7 = "ibmhkaga-leoooihk-konclkhn" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        10 of them
}


rule FunRat_Loader_Class_Rattle
{
    meta:
        description = "FunRat stage loader, TON config resolver and session exfiltrator"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "aurora/rattle" ascii
        $c2 = "aurora/sherbet" ascii
        $c3 = "aurora/quake" ascii
        $c4 = "aurora/stumble" ascii
        $m1 = "plankton" ascii
        $m2 = "cradle" ascii
        $m3 = "pendant" ascii
        $m4 = "rambler" ascii
        $m5 = "ripple" ascii
        $m6 = "mohair" ascii
        $m7 = "savanna" ascii
        $m8 = "kingdom" ascii
        $m9 = "remark" ascii
        $m10 = "napkin" ascii
        $m11 = "canvas" ascii
        $m12 = "rivet" ascii
        $m13 = "samba" ascii
        $m14 = "dragon" ascii
        $m15 = "hollow" ascii
        $m16 = "stork" ascii
        $x1 = "epialfgh-gnjkljhd-hgmgjmhe-heiiifha-gb" ascii
        $x2 = "likookhp-kopeplhj-ljko" ascii
        $x3 = "icibhfhd-jenlhohf-id" ascii
        $x4 = "neibjago-jiininhj-ncmaibgh-ngjnjb" ascii
        $x5 = "kihkkjgm-ofhglehl-ko" ascii
        $x6 = "faoaofhf-faojpjhn-bckopdhf-bdoeogdd-ellbkfcn" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and $c2 and $c3 and $c4 and
        12 of ($m*) and
        4 of ($x*)
}


rule FunRat_Loader_Class_Sardine
{
    meta:
        description = "Minecraft/Fabric session-token reflection helper"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "aurora/sardine" ascii
        $c2 = "aurora/sherbet" ascii
        $c3 = "aurora/quake" ascii
        $m1 = "FabricLoader" ascii
        $m2 = "MappingResolver" ascii
        $m3 = "mckclodm-mkkgkigb-mfkekhha-idklkfhc-mikclidm-mnlhkddm-okkgkigb-mfkeighm-mnkdkpgb-kmkakpgh-olkgkhhg-ofkjljgh-mnkjkjhg-kmopodfp-mgkglmhc-idklklhn-mloiifhb-mgkckjgh-jh" ascii
        $m4 = "inldlfch-iflhkdhk-iklfkmgl-mmlkkogj-ihldldch-ickgkich-kolhlbhi-iklikgfk-igkfkoge-jfldldai-iolhlbef-igkckjgh-ihjikagf-igngojee-ijlhlhgj-mmlkkagg-iepjjchm-jblpkpgp-nijkklgj-jflhooge-iclikgch-lakcldgb-inlbpkee-ijlhlhgj-mmlkkagg-iepjjchm-jblpkpgp-nijkklgj-jflhooge-iclikgch-lakcldgb-inlbpkcb-kplmkaho-icpjkngj-inlboofl-jhkekigg-ieon" ascii
        $m5 = "oamnnhhh-plmomghg-oamcnbgl" ascii
        $m6 = "ndiajkhd-jgininhm-nomolpgg-mliiichf-ljiijpfa-nfiaichj-ljmjmfei" ascii
        $m7 = "nephew" ascii
        $m8 = "pastel" ascii
        $m9 = "kangaroo" ascii
        $m10 = "spring" ascii
        $m11 = "cypress" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and $c2 and $c3 and
        8 of ($m*)
}


rule FunRat_Obfuscator_Sherbet
{
    meta:
        description = "Custom invokedynamic string/name-concealing bootstrap (aurora.sherbet)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "medium"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "aurora/sherbet" ascii
        $c2 = "aurora/quake" ascii
        $d1 = "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;II)Ljava/lang/invoke/CallSite;" ascii
        $d2 = "java/lang/invoke/ConstantCallSite" ascii
        $m1 = "findStatic" ascii
        $m2 = "findVirtual" ascii
        $m3 = "findConstructor" ascii
        $m4 = "findSpecial" ascii
        $m5 = "findStaticGetter" ascii
        $m6 = "findStaticSetter" ascii
        $m7 = "findGetter" ascii
        $m8 = "findSetter" ascii
        $m9 = "descriptor" ascii
        $m10 = "parse" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and $c2 and $d1 and $d2 and
        7 of ($m*)
}


rule FunRat_Decoder_Quake
{
    meta:
        description = "FunRat XOR/nibble string decoder (aurora.quake.otter)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "medium"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "aurora/quake" ascii
        $m1 = "otter" ascii
        $s1 = "UTF-8" ascii
        $s2 = "java/nio/charset/Charset" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        filesize < 2000 and
        $c1 and $m1 and
        all of ($s*)
}


rule FunRat_Loader_Class_Stumble
{
    meta:
        description = "FunRat dead-code stub class (aurora.stumble)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "low"
        confidence = "medium"
        scope = "extracted .class"
        comment = "Tiny no-op class; may exist to make the loader class set distinctive."
    strings:
        $c1 = "aurora/stumble" ascii
        $m1 = "marina" ascii
        $m2 = "dune" ascii
        $f1 = "goblet" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        filesize < 1000 and
        all of them
}


rule FunRat_Encoded_Constants
{
    meta:
        description = "Exact encoded C2/loader constants from the analysed FunRat sample"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $r1 = "poohokha-ofkjlbcp-oepgpcgb-oplokngg-kppakjdb-lip" ascii
        $r2 = "khionkgl-lmmaibde-lnjpmchk-lgnhmdhc-lniimbgj-obj" ascii
        $t1 = "ohlkpfhl-phnnomgl-mdlempcb-mekandhg-obikoffh-nhi" ascii
        $k1 = "cilopmgo-holjpjda-dcokkidm-cokdklgj-holhlcdb-chl" ascii
        $p1 = "epialfgh-gnjkljhd-hgmgjmhe-heiiifha-gb" ascii
        $p2 = "likookhp-kopeplhj-ljko" ascii
        $p3 = "icibhfhd-jenlhohf-id" ascii
        $p4 = "neibjago-jiininhj-ncmaibgh-ngjnjb" ascii
        $p5 = "kihkkjgm-ofhglehl-ko" ascii
        $u1 = "pjnkphgp-ocjekmda-ofmbonhm-pemaphhk-odiaoaha-pmi" ascii
        $u2 = "gcknlmap-hjodohfa-holgkgbo-hklaogbg-gfpgloen-cfl" ascii
        $u3 = "faoaofhf-faojpjhn-bckopdhf-bdoeogdd-ellbkfcn" ascii
        $g1 = "odkalmda-odpikicm-jkidkhfo-kaoppade-omplkbcl-pmj" ascii
        $g2 = "jigkikhh-ngclnfdj-jcfcnpdg-idgimchn-plcekjeg-jbc" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        8 of them
}


rule FunRat_Decoded_Indicators
{
    meta:
        description = "Decoded FunRat C2, drop-path and protocol strings (memory/unpacked files)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "memory dump or deobfuscated/unpacked files"
    strings:
        $d1 = "relay-3f9c71.kartohaantoha36-6a9.workers.dev" ascii
        $d2 = "relay-mirror.kartohaantoha36-6a9.workers.dev" ascii
        $d3 = "EQChU6Zxa_y2fKeeCaSDubGcFZizRdRVSArwAh6qJtfe9NKZ" ascii
        $d4 = "EQCsNH1LY2PQeqG2HKSk2myObNTgCuREdq1IVvZFL4k_5iia" ascii
        $d5 = "EQBaz-F9o6nHrQ16Z_jTGZShLyRNEMRtS0OWMYs0GNQK_PHA" ascii
        $d6 = "70cfa7f8-d741-4aa9-980a-02b6467f27d3" ascii
        $d7 = "/api/hlam/files/4001" ascii
        $d8 = "Microsoft/JavaSec" ascii
        $d9 = "stage.part" ascii
        $d10 = "stage.jar" ascii
        $d11 = "core/core.class" ascii
        $d12 = "core.core" ascii
        $d13 = "thin-report" ascii
        $d14 = "[thin] start" ascii
        $d15 = "toncenter.com/api/v2/runGetMethod" ascii
        $d16 = "tonapi.io/v2/blockchain/accounts/" ascii
    condition:
        7 of them
}


rule FunRat_Fabric_Manifest
{
    meta:
        description = "fabric.mod.json metadata used by the FunRat loader"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted fabric.mod.json"
    strings:
        $a = "\"id\": \"hello-world-fabric\"" ascii
        $b = "\"name\": \"Fun mod\"" ascii
        $c = "\"description\": \"A mod made for fun.\"" ascii
        $d = "\"aurora.orchid\"" ascii
        $e = "\"FunMaster\"" ascii
        $f = "\"https://theuselessweb.com/\"" ascii
    condition:
        filesize < 10KB and
        4 of them
}


rule FunRat_Report_Protocol_Decoded
{
    meta:
        description = "FunRat credential-report JSON protocol (memory/unpacked files)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "memory dump or deobfuscated/unpacked files"
    strings:
        $a = "{\"name\":\"" ascii
        $b = "\",\"uuid\":\"" ascii
        $c = "\",\"token\":\"" ascii
        $d = "\",\"receiver\":\"" ascii
        $e = "\",\"key\":\"" ascii
        $f = "[thin] retry err=" ascii
        $g = "[thin] ok code=" ascii
        $h = "/report" ascii
    condition:
        all of ($a, $b, $c, $d, $e) and
        $h and
        1 of ($f, $g)
}


rule FunRat_Stage_Sample_KnownHash
{
    meta:
        description = "Exact known FunRat stage-1 JAR (core.core downloader/launcher)"
        author = "malware analysis notes"
        date = "2026-10-23"
        sample_sha256 = "eb80cf584e05fdfc63949870acf8b0ad8972b1ed5343583c845a98299b8167f9"
        severity = "high"
        confidence = "high"
        scope = "any file"
    condition:
        filesize == 5655 and
        hash.sha256(0, filesize) == "eb80cf584e05fdfc63949870acf8b0ad8972b1ed5343583c845a98299b8167f9"
}


rule FunRat_Stage_JAR_Archive
{
    meta:
        description = "FunRat stage-1 JAR with stored manifest and core/core.class"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "raw JAR/ZIP"
        comment = "Matches the analysed stage build; the manifest is stored, so Main-Class is visible in the raw JAR."
    strings:
        $entry = "core/core.class" ascii
        $mf = "META-INF/MANIFEST.MF" ascii
        $main = "Main-Class: core.core" ascii
        $created = "Created-By: 22.0.2" ascii
    condition:
        uint32be(0) == 0x504B0304 and
        filesize < 5MB and
        #entry >= 2 and
        $mf and $main and $created
}


rule FunRat_Stage_Class_Core
{
    meta:
        description = "FunRat stage-1 core.core downloader/launcher class"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
        comment = "The class is unobfuscated; method names and stage URLs are visible."
    strings:
        $c1 = "core/core" ascii
        $c2 = "core.java" ascii
        $m01 = "mains" ascii
        $m02 = "maybeSpam" ascii
        $m03 = "isPremium" ascii
        $m04 = "resolveBase" ascii
        $m05 = "tonLink" ascii
        $m06 = "resolvePanel" ascii
        $m07 = "configSlot" ascii
        $m08 = "download" ascii
        $m09 = "getCurrentProcessExePath" ascii
        $m10 = "vov" ascii
        $s01 = "SecurityUpdates" ascii
        $s02 = "JavaInt.jar" ascii
        $s03 = "dis.jar" ascii
        $s04 = "telemetry-relay.kartohaantoha36-6a9.workers.dev" ascii
        $s05 = "https://funrat.top" ascii
        $s06 = "/api/premium-status?id=" ascii
        $s07 = "30e3267e-d80c-4a8f-84e2-bb475930a37c" ascii
        $s08 = "powershell.exe" ascii
        $s09 = "spam err:" ascii
        $s10 = "/api/hlam/files/4001" ascii
        $s11 = "/api/hlam/files/4003" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and $c2 and
        7 of ($m*) and
        6 of ($s*)
}


rule FunRat_Stage_Decoded_Indicators
{
    meta:
        description = "Decoded FunRat stage-1 downloader/launcher indicators (memory/unpacked)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "memory dump or deobfuscated/unpacked files"
        comment = "The stage class is unobfuscated; these strings are visible in the class, memory, and this repository's analysis files."
    strings:
        $d01 = "telemetry-relay.kartohaantoha36-6a9.workers.dev" ascii
        $d02 = "https://funrat.top" ascii
        $d03 = "SecurityUpdates" ascii
        $d04 = "JavaInt.jar" ascii
        $d05 = "dis.jar" ascii
        $d06 = "/api/premium-status?id=" ascii
        $d07 = "30e3267e-d80c-4a8f-84e2-bb475930a37c" ascii
        $d08 = "/api/hlam/files/4001" ascii
        $d09 = "/api/hlam/files/4003" ascii
        $d10 = "spam err:" ascii
        $d11 = "powershell.exe" ascii
    condition:
        6 of them
}


rule FunRat_Stage_JAR_CoreClass
{
    meta:
        description = "Low-confidence container rule for a dropped FunRat stage JAR containing core/core.class"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "medium"
        confidence = "low"
        scope = "raw JAR/ZIP"
        comment = "Corroborate with FunRat_Decoded_Indicators or network IOCs; core/core.class can occur in benign JARs."
    strings:
        $entry = "core/core.class" ascii
        $mf = "META-INF/MANIFEST.MF" ascii
    condition:
        uint32be(0) == 0x504B0304 and
        filesize < 50MB and
        #entry >= 2 and
        $mf
}


/*
    Third stage: large obfuscated Java collection implant
    -----------------------------------------------------
    The implant is a fat JAR with a small application layer under core/ and
    ttsjcnocknendlub/, plus bundled libraries. Its behavioural strings are
    encoded, so the raw JAR and extracted classes are covered by structural
    names and method names, while decoded indicators cover memory/unpacked
    artifacts.
*/

rule FunRat_Stage3_Sample_KnownHash_JavaInt
{
    meta:
        description = "Exact known FunRat third-stage Java collection implant"
        author = "malware analysis notes"
        date = "2026-10-23"
        sample_sha256 = "bf2c9723acf2d4ea5971169368ed384e57399177b0f59ed627744df7b07dd822"
        severity = "high"
        confidence = "high"
        scope = "any file"
    condition:
        filesize == 23229672 and
        hash.sha256(0, filesize) == "bf2c9723acf2d4ea5971169368ed384e57399177b0f59ed627744df7b07dd822"
}


rule FunRat_Stage3_JAR_JavaInt
{
    meta:
        description = "FunRat third-stage fat JAR with the collection implant and bundled DLL"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "raw JAR/ZIP"
    strings:
        $e1 = "core/Main.class" ascii
        $e2 = "core/meow.class" ascii
        $e3 = "core/JnaStartupInfoSmokeTest.class" ascii
        $e4 = "ttsjcnocknendlub/muaijwxryatoplqf.class" ascii
        $e5 = "CookiveV2.dll" ascii
        $mf = "META-INF/MANIFEST.MF" ascii
    condition:
        uint32be(0) == 0x504B0304 and
        filesize < 50MB and
        $mf and
        all of ($e1, $e2, $e3, $e4, $e5)
}


rule FunRat_Stage3_Class_JavaInt
{
    meta:
        description = "FunRat third-stage collection implant class (core.Main)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
        comment = "Method names remain visible even though most strings are encoded."
    strings:
        $c1 = "core/Main" ascii
        $c2 = "core/meow" ascii
        $c3 = "core/JnaStartupInfoSmokeTest" ascii
        $c4 = "ttsjcnocknendlub/muaijwxryatoplqf" ascii
        $m01 = "maybestart" ascii
        $m02 = "loadSetings" ascii
        $m03 = "injectFolder" ascii
        $m04 = "CookieInject" ascii
        $m05 = "grabSystemInfo" ascii
        $m06 = "send" ascii
        $m07 = "mowlabbnae" ascii
        $m08 = "huhowxzlzevtonoz" ascii
        $m09 = "CryptoWallets" ascii
        $m10 = "StealDesktop" ascii
        $m11 = "grabMinecraft" ascii
        $m12 = "ScreenshotScreen" ascii
        $m13 = "openTor" ascii
        $m14 = "runInventory" ascii
        $m15 = "ChromeNew" ascii
        $m16 = "processBrowser" ascii
        $m17 = "unwrapDll" ascii
        $m18 = "decryptKey" ascii
        $m19 = "injectDll" ascii
        $m20 = "getDiscordToken" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and $c2 and $c3 and $c4 and
        9 of ($m*)
}


rule FunRat_Stage3_Decoded_JavaInt
{
    meta:
        description = "Decoded FunRat third-stage upload, persistence and collection indicators"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "memory dump or deobfuscated/unpacked files"
        comment = "The implant encodes these strings; this rule targets runtime memory and decoded outputs."
    strings:
        $d01 = "/api/ingest" ascii
        $d02 = "----IngestBoundary" ascii
        $d03 = "/api/app-settings-public" ascii
        $d04 = "AutoStartMini" ascii
        $d05 = "WScript.Sleep 10000" ascii
        $d06 = "CookiveV2.dll" ascii
        $d07 = "Network.getAllCookies" ascii
        $d08 = "remote-debugging-port=9222" ascii
        $d09 = "launcher_msa_credentials.bin" ascii
        $d10 = "WebWallets" ascii
        $d11 = "pcName" ascii
        $d12 = "30e3267e-d80c-4a8f-84e2-bb475930a37c" ascii
        $d13 = "SecurityUpdates" ascii
        $d14 = "_qdr-" ascii
        $d15 = "SystemInfo.txt" ascii
    condition:
        8 of them
}


rule FunRat_Stage3_Persistence_VBS
{
    meta:
        description = "Dropped VBScript restart loop used by the FunRat implant"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "dropped script or memory"
    strings:
        $s1 = "CreateObject(\"WScript.Shell\")" ascii
        $s2 = "WScript.Sleep 10000" ascii
        $s3 = "AutoStartMini" ascii
        $s4 = "SecurityUpdates" ascii
        $s5 = "-super.vbs" ascii
        $s6 = "JavaSecurity.jar" ascii
    condition:
        $s1 and $s2 and
        1 of ($s3, $s4, $s5, $s6)
}


/*
    Fourth stage: Discord token stealer and spam module
    --------------------------------------------------
    This is a smaller JAR with org/example/Main.class and a mostly unused
    core/TorBridge.class. The spam strings are unobfuscated in the class.
*/

rule FunRat_Stage4_Sample_KnownHash_DiscordSpam
{
    meta:
        description = "Exact known FunRat Discord token stealer/spam module"
        author = "malware analysis notes"
        date = "2026-10-23"
        sample_sha256 = "9bcb73a6c5277e1c9be247b29e39f9f41d929235fa09f61064f5712ec9e832bc"
        severity = "high"
        confidence = "high"
        scope = "any file"
    condition:
        filesize == 5773961 and
        hash.sha256(0, filesize) == "9bcb73a6c5277e1c9be247b29e39f9f41d929235fa09f61064f5712ec9e832bc"
}


rule FunRat_Stage4_JAR_DiscordSpam
{
    meta:
        description = "FunRat Discord token stealer/spam JAR"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "raw JAR/ZIP"
    strings:
        $e1 = "org/example/Main.class" ascii
        $e2 = "core/TorBridge.class" ascii
        $e3 = "com/sun/jna/" ascii
        $mf = "META-INF/MANIFEST.MF" ascii
    condition:
        uint32be(0) == 0x504B0304 and
        filesize < 50MB and
        $e1 and $mf and
        1 of ($e2, $e3)
}


rule FunRat_Stage4_Class_DiscordSpam
{
    meta:
        description = "FunRat Discord token stealer/spam class (org.example.Main)"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "extracted .class"
    strings:
        $c1 = "org/example/Main" ascii
        $m01 = "getDiscordToken" ascii
        $m02 = "getClientTokens" ascii
        $m03 = "getBrowserTokens" ascii
        $m04 = "decryptTokens" ascii
        $m05 = "isUserInGuild" ascii
        $m06 = "runMassDm" ascii
        $m07 = "sendMessage" ascii
        $m08 = "hasPermissionToSend" ascii
        $m09 = "loadFriends" ascii
        $m10 = "createDMChannel" ascii
        $s01 = "1443109598579003414" ascii
        $s02 = "YOUR MINECRAFT ACCOUNT IS ALREADY STOLEN" ascii
        $s03 = "https://discord.com/api/v9/users/@me/guilds" ascii
        $s04 = "/billing/payment-sources" ascii
        $s05 = "dQw4w9WgXcQ:" ascii
        $s06 = "funrat.co" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and
        5 of ($m*) and
        3 of ($s*)
}


rule FunRat_Stage4_Decoded_DiscordSpam
{
    meta:
        description = "Decoded FunRat Discord spam content and targeting indicators"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "high"
        confidence = "high"
        scope = "memory dump or deobfuscated/unpacked files"
    strings:
        $d01 = "1443109598579003414" ascii
        $d02 = "YOUR MINECRAFT ACCOUNT IS ALREADY STOLEN" ascii
        $d03 = "https://funrat.co/" ascii
        $d04 = "https://t.me/weloverat" ascii
        $d05 = "https://discord.gg/TSYMmF9B2y" ascii
        $d06 = "https://discord.com/api/v9/users/@me/guilds" ascii
        $d07 = "/billing/payment-sources" ascii
        $d08 = "Stop testing rat yourself" ascii
        $d09 = "spam err:" ascii
    condition:
        5 of them
}


rule FunRat_Stage4_TorBridge
{
    meta:
        description = "Unreferenced Tor bridge class bundled with the FunRat Discord module"
        author = "malware analysis notes"
        date = "2026-10-23"
        severity = "low"
        confidence = "medium"
        scope = "extracted .class"
        comment = "The analysed Discord entrypoint does not call this class; it is not evidence that the spam path used Tor."
    strings:
        $c1 = "core/TorBridge" ascii
        $s1 = "127.0.0.1" ascii
        $s2 = "9050" ascii
        $s3 = "SOCKS" ascii
        $s4 = "tor" ascii
    condition:
        uint32be(0) == 0xCAFEBABE and
        $c1 and
        2 of ($s*)
}
