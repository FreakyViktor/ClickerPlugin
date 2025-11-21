package org.stjernemix.clickerplugin.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.stjernemix.clickerplugin.playerData.PlayerData;
import org.stjernemix.clickerplugin.util.PlayerUtil;

import java.io.File;
import java.io.IOException;

public class GeneralEvents implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        PlayerData data = new PlayerData();
        File f = new File(PlayerUtil.getFolderPath(event.getPlayer()) + "/general.yml");

        if(f.exists()){
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
            data.setMoney(cfg.getInt("stats.money"));
            data.setMultiplier(cfg.getInt("stats.multiplier"));
            data.setRebirths(cfg.getInt("stats.rebirths"));
        } else {
            data.setMoney(0);
            data.setMultiplier(1);
            data.setRebirths(0);
        }

        PlayerUtil.setPlayerData(event.getPlayer(), data);

        event.setJoinMessage("§8[§a+§8] §f" + event.getPlayer().getName());
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        PlayerData data = PlayerUtil.getPlayerData(event.getPlayer());
        File f = new File(PlayerUtil.getFolderPath(event.getPlayer()) + "/general.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
        cfg.set("stats.money", data.getMoney());
        cfg.set("stats.multiplier", data.getMultiplier());
        cfg.set("stats.rebirths", data.getRebirths());

        try{ cfg.save(f); } catch (IOException e){ e.printStackTrace(); }
        PlayerUtil.setPlayerData(event.getPlayer(), null);

        event.setQuitMessage("§8[§a+§8] §f" + event.getPlayer().getName());
    }

}
