// Never expected to analyze myself ;)
rule Krotten_Ransomware {
    meta:
        author = "Krotten"
        date = "2026-09-27"
        family = "Krotten"
        description = "Krotten 2005 ransomware (InqSoft Sign 0f Misery v2.7 joke malware)"
        sample = "Krotten.exe (54569 B)"
        hash_sha256 = "e79f164ccc75a5d5c032b4c5a96d6ad7604faffb28afe77bc29b9173fa3543e4"
        reference = "C:\\MALWARE\\Misc Malware\\Krotten.exe"
    strings:
        $ver    = "InqSoft Sign 0f Misery" ascii nocase
        $ver2   = "v. 2.7, pre-release 2" ascii nocase
        $author = "C0ded by CyberManiac" ascii nocase
        $mail   = "wordsia@notrix.de" ascii nocase
        $home   = "http://poetry.rotten.com/lightning/" ascii nocase
        $priv   = "SeSystemtimePrivilege" ascii
        $pol1   = "DisableTaskMgr" ascii
        $pol2   = "DisableRegistryTools" ascii
        $pol3   = "NoDispCPL" ascii
    condition:
        uint16(0) == 0x5A4D and filesize < 500KB and
        (
            ($ver and 1 of ($ver2, $author, $mail, $home, $priv, $pol*)) or
            (($author or $mail) and $home) or
            (3 of ($ver, $ver2, $author, $mail, $home, $priv))
        )
}
