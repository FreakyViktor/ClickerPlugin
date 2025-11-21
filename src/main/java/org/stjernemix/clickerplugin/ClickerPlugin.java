package org.stjernemix.clickerplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.stjernemix.clickerplugin.listeners.GeneralEvents;

public final class ClickerPlugin extends JavaPlugin {

    private static ClickerPlugin instance;

    @Override
    public void onEnable() {
        // Register Events
        getServer().getPluginManager().registerEvents(new GeneralEvents(), this);


        instance = this;

    }

    public static ClickerPlugin getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
