rule GitAppFakeInstaller_Dropper {
    meta:
        author = "Krotten"
        date = "2026-09-16"
        family = "GitAppDropper"
        description = "Fake GitHub App installer: Defender exclusion + 7z payload fetch"
        sample = "Github App Installer.exe.infected (58880 B)"
    strings:
        $excl   = "Add-MpPreference -ExclusionPath" ascii nocase
        $dl7z   = "https://github.com/ip7z/7zip/releases/download/26.01/7zr.exe" ascii nocase
        $pw     = "-p2026" ascii
        $fake   = "Please update .NET Framework." ascii
        $exe7z  = "\\7zr.exe" ascii
        $arc7z  = ".7z" ascii
    condition:
        uint16(0) == 0x5A4D and filesize < 500KB and
        (
            ($excl and 1 of ($dl7z, $pw, $fake)) or
            ($excl and $exe7z and $arc7z)
        )
}

rule GitAppFakeInstaller_LangPayload {
    meta:
        author = "Krotten"
        date = "2026-09-16"
        family = "GitAppDropper"
        description = "Fake language-data payload container shipped with the dropper"
        sample = "lang/english.dat.infected (6960910 B)"
    strings:
        $h1 = "Language Data File:" ascii
        $h2 = "Language Code:" ascii
        $h3 = "Encoding: UTF-8" ascii
        $h4 = "Version: 1.0" ascii
        $h5 = "Hash:" ascii
    condition:
        filesize > 1MB and 4 of ($h*)
}
