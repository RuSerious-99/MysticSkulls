package me.ruserious99.mysticskulls;

import me.ruserious99.mysticskulls.commands.SkullCommands;
import me.ruserious99.mysticskulls.commands.SkullTab;
import me.ruserious99.mysticskulls.listeners.GeneralListeners;
import me.ruserious99.mysticskulls.listeners.SkullLIsteners;
import me.ruserious99.mysticskulls.skull_events.TestMask;
import me.ruserious99.mysticskulls.skulls.SkullsManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MysticSkulls extends JavaPlugin {

    private static MysticSkulls instance;

    //To add skull
    //add new item to SkullManager
    //Make SkullEvents class that extends MysticSkulls and implements Listener
    //Register your Listener here
    //add skull to methods giveCustomItem in InventoryListener and RunInstalledSkulls equip and unequip.
    //add skull to SkullCommands and SkullTab

    @Override
    public void onEnable() {
        MysticSkulls.instance = this;
        SkullsManager.init();
        this.registerCommands();
        this.registerListeners();
    }

    private void registerListeners() {

        this.getServer().getPluginManager().registerEvents(new GeneralListeners(), this);
        this.getServer().getPluginManager().registerEvents(new SkullLIsteners(), this);

        this.getServer().getPluginManager().registerEvents(new TestMask(), this);
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("skull")).setTabCompleter(new SkullTab());
        Objects.requireNonNull(this.getCommand("skull")).setExecutor(new SkullCommands());

    }

    public static MysticSkulls get() {
        return instance;
    }
}
