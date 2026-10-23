/*
  YARA — Krypton 1.21.11 Fabric loader (Defender-flagged sample)
  Sample: C:\MALWARE\Krypton-1.21.11.jar (702525 bytes, STORED/uncompressed)
  SHA256: 9557C0E00E5EC2E6689D5A69D98EF7D2B08380A1B3632FE6E0708BEB29F4E20C
  Static-only. No execution.

  NOTE on encryption: all C2 strings are encrypted via Helper.load(int[],int[],int,int)
  (interleave + sbox + rot + xor) and are NOT visible raw. They were recovered by
  reimplementing the decryptor (see report). Rule 1 therefore uses only raw-visible
  anchors (entry names, method names, log markers, javaw relaunch). Rule 2 targets
  already-decrypted text / memory after Helper.load runs.

  Chain: ExampleMod/Entrypoint -> Helper.stageWithContext -> FabricAdapter.getVerifiedText
  (Ethereum eth_call dead-drop + RSA/SHA256 verify) -> dl() -> ExampleMixin in-memory
  load -> dev.majanito.Main#initializeWeedhack
*/

rule Krypton_Fabric_Loader_Stage1
{
  meta:
    description = "Krypton Fabric loader, raw-JAR anchors: com/example entry layout, Helper.load cryptor, ETH-verified dead-drop resolver, javaw --jw relaunch"
    sample_sha256 = "9557C0E00E5EC2E6689D5A69D98EF7D2B08380A1B3632FE6E0708BEB29F4E20C"
    sample_md5 = "EB603A2D99BD66CAB5125F9C5BCBCF7E"
    sample_sha1 = "FC7D3C464E59DA49118CD8AFF4348FDFC5E9A727"
    file_size = "702525"
    date = "2026-10-03"
    confidence = "high"

  strings:
    // ZIP entry names
    $path_helper  = "com/example/Helper.class" ascii
    $path_adapter = "com/example/FabricAdapter.class" ascii
    $path_mixin   = "com/example/ExampleMixin.class" ascii
    $path_entry   = "com/example/Entrypoint.class" ascii

    // Loader internals (plaintext method/descriptor names)
    $cry_stage   = "stageWithContext" ascii
    $cry_loadsig = "([I[III)" ascii
    $cry_verified = "getVerifiedText" ascii
    $cry_callget  = "callGetText" ascii
    $cry_mixin    = "ExampleMixin" ascii

    // Dead-drop config (plaintext)
    $net_apijson = "fabric.api.json" ascii
    $net_apiver  = "ebb30233-08a9-4241-b91c-9712582410b7" ascii

    // Console log markers
    $log_mod = "Mod init state:" ascii
    $log_res = "Resource state:" ascii

    // Dual execution: Fabric + double-click javaw relaunch
    $exec_jw    = "--jw" ascii
    $exec_javaw = "javaw.exe" ascii

  condition:
    uint32(0) == 0x04034b50
    and filesize < 5MB
    and 3 of ($path_*)
    and 3 of ($cry_*)
    and 1 of ($net_*)
    and 1 of ($log_*)
    and 1 of ($exec_*)
}

rule Krypton_Loader_Decrypted_Text
{
  meta:
    description = "For decrypted dumps / memory after Helper.load: stage-2 class+method, on-chain address, delivery paths, ETH RPCs, RSA key. Produce input with the Helper.load reimplementation (see report)."
    date = "2026-10-03"
    confidence = "high"
    how = "run decryptor over Helper.load call sites, scan the output with this rule"

  strings:
    $cry_class  = "dev.majanito.Main" ascii
    $cry_method = "initializeWeedhack" ascii
    $cry_addr   = "0x1280a841Fbc1F883365d3C83122260E0b2995B74" ascii
    $cry_sel    = "0xce6d41de" ascii
    $cry_rsa    = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmNzDf4737" ascii
    $cry_alg    = "SHA256withRSA" ascii
    $net_handler = "/api/delivery/handler" ascii
    $net_module  = "/files/jar/module" ascii
    $net_ethcall = "\"method\":\"eth_call\"" ascii
    $net_rpc     = "https://eth.llamarpc.com" ascii

  condition:
    filesize < 5MB
    and $cry_class and $cry_method
    and 2 of ($cry_*)
    and 1 of ($net_*)
}
