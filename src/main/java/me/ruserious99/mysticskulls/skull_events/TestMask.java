package me.ruserious99.mysticskulls.skull_events;

import me.ruserious99.mysticskulls.AbstactMysticSkull;
import me.ruserious99.mysticskulls.MysticSkulls;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

// visual only
public class TestMask extends AbstactMysticSkull implements Listener {
    @Override
    public void onEquip(Player player) {
        player.setMetadata("testMaskOn", new FixedMetadataValue(MysticSkulls.get(), System.currentTimeMillis()));

    }

    @Override
    public void onUnequip(Player player) {
        player.removeMetadata("testMaskOn", MysticSkulls.get());

    }
}

