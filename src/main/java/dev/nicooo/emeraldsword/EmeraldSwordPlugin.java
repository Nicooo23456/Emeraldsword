package dev.nicooo.emeraldsword;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

public class EmeraldSwordPlugin extends JavaPlugin {
    private ItemStack emeraldSword;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        createEmeraldSword();
        registerRecipe();
        getServer().getPluginManager().registerEvents(new SwordEventListener(this), this);
        getLogger().info("EmeraldSword plugin has been enabled!");
    }

    private void createEmeraldSword() {
        emeraldSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = emeraldSword.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Emerald Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        emeraldSword.setItemMeta(meta);
    }

    private void registerRecipe() {
        NamespacedKey key = new NamespacedKey(this, "emerald_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, emeraldSword);
        recipe.shape(" E ", " E ", " S ");
        recipe.setIngredient('E', Material.EMERALD);
        recipe.setIngredient('S', Material.STICK);
        getServer().addRecipe(recipe);
    }

    public ItemStack getEmeraldSword() {
        return emeraldSword.clone();
    }
}