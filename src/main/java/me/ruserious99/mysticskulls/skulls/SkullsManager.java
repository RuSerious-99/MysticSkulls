package me.ruserious99.mysticskulls.skulls;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SkullsManager {

    private static HashMap<ItemStack, Boolean> skulls;
    private static PersistentData persistentData;
    private static RunInstalledSkulls runInstalledMasks;

    public static ItemStack test;

    public static void init() {

        skulls = new HashMap<>();
        persistentData = new PersistentData();
        runInstalledMasks = new RunInstalledSkulls();

        createTestSkull();

    }


    private static void createTestSkull() {
        Bukkit.getConsoleSender().sendMessage("SkullsManager: start create testSkull");
        ItemStack testSkull = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) testSkull.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.DARK_RED + "TEST SKULL");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE +" ");
        lore.add("This Skull will Let You Fyl!!!");
        lore.add(ChatColor.GOLD +" ");
        lore.add("This is a test Skull");
        lore.add("Put it on to Enjoy the look");
        lore.add(" ");
        lore.add(ChatColor.GRAY + "Attach this Skull to any helmet to Enjoy the Mystical Powers");
        lore.add(ChatColor.GRAY + "To give it a visual override Attach with no Helmet");
        lore.add("");
        lore.add(ChatColor.GRAY + "To equip, place this Skull on a helmet");
        lore.add(ChatColor.GRAY + "To remove, right-click helmet while attached");
        meta.setLore(lore);

        testSkull.setItemMeta(meta);

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODRhYzU3YjJhMmQ1YzYzMjE4OTVjNmY4ZTdmYmM2NzI2MmNhMDk3MjQzOTE4YWE1OTRjYjI0NThhNzA0MCJ9fX0="));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        }catch(NoSuchFieldException | IllegalArgumentException | IllegalAccessException x){
            x.printStackTrace();
        }
        testSkull.setAmount(1);
        testSkull.setItemMeta(meta);
        test = testSkull;
        test = persistentData.setCustomDataTag(testSkull, "skull", "testSkull");

        skulls.put(test, false);
        Bukkit.getConsoleSender().sendMessage("SkullsManager: create testskull Itemstack " + skulls.size());

    }

    public static PersistentData getPersistentData() {return persistentData;}
    public static RunInstalledSkulls getRunInstalledSkulls() { return runInstalledMasks; }
    public static HashMap<ItemStack, Boolean> getSkulls() { return skulls; }
}
