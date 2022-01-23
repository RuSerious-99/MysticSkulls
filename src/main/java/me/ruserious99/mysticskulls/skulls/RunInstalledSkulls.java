package me.ruserious99.mysticskulls.skulls;

import me.ruserious99.mysticskulls.skull_events.TestMask;
import org.bukkit.entity.Player;

public class RunInstalledSkulls {
    public void equipSkull(String mask, Player player) {
        switch (mask) {


            case "testMask":
                TestMask testMask = new TestMask();
                testMask.onEquip(player);
                break;


            default:
        }
    }

    public void unEquipSkull(String mask, Player player) {
        switch (mask) {


            case "testMask":
                TestMask testMask = new TestMask();
                testMask.onUnequip(player);
                break;


            default:
        }
    }
}
