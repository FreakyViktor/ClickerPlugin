package org.stjernemix.clickerplugin.util;

import org.bukkit.entity.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.stjernemix.clickerplugin.ClickerPlugin;
import org.stjernemix.clickerplugin.playerData.PlayerData;

import java.io.File;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;


public class PlayerUtil {
    private static Map<String, PlayerData> playerData = new HashMap<>();

    public static PlayerData getPlayerData(Player p) {
        if (!playerData.containsKey(p.getUniqueId().toString())){
            PlayerData d = new PlayerData();
            playerData.put(p.getUniqueId().toString(), d);
            return d;
        }
        return playerData.get(p.getUniqueId().toString());
    }

    public static void setPlayerData(Player p, PlayerData data) {
        if(data == null) playerData.remove(p.getUniqueId().toString());
        else playerData.put(p.getUniqueId().toString(), data);
    }

    public static String getFolderPath(Player p) {
        File folder = new File(ClickerPlugin.getInstance().getDataFolder(), "player/" + p.getUniqueId());
        return folder.getAbsolutePath();
    }
}
