rule Minecraft_Infostealer_Generic {
    meta:
        author = "Krotten"
        date = "2026-09-16"
        family = "minecraft-stealer"
        description = "Generic Java mod stealer: browser cred SQL + Discord/session theft in extracted classes"
    strings:
        $sql_login   = "SELECT origin_url, username_value, password_value FROM logins" ascii wide nocase
        $sql_cookie  = "SELECT host_key, name, encrypted_value, path, expires_utc FROM cookies" ascii wide nocase
        $sql_mcusers = "SELECT username, uuid, access_token, refresh_token, expires FROM minecraft_users" ascii wide nocase
        $dc_api   = "discord.com/api/v9/users/@me" ascii wide nocase
        $dc_core  = "discord_desktop_core" ascii wide nocase
        $abe      = "app_bound_encrypted_key" ascii wide nocase
        $sess     = "accessToken" ascii wide
        $mc       = "minecraftInfo" ascii wide
        $tok      = "discordTokens" ascii wide
        $br       = "browserData" ascii wide
    condition:
        filesize < 10MB and
        (
            (1 of ($sql_*) and 1 of ($dc_api, $dc_core, $abe) and 1 of ($sess, $mc, $tok, $br)) or
            (2 of ($sql_*) and 1 of ($dc_api, $dc_core, $abe, $tok, $br))
        )
}
