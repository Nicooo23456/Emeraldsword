package dev.nicooo.emeraldsword;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SwordEventListener implements Listener {
    private final EmeraldSwordPlugin plugin;

    public SwordEventListener(EmeraldSwordPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        
        Player player = (Player) event.getDamager();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (item.isSimilar(plugin.getEmeraldSword())) {
            double damage = plugin.getConfig().getDouble("sword.damage", 8.0);
            event.setDamage(damage);
            
            if (plugin.getConfig().getBoolean("sword.special-effects.enabled", true)) {
                // Add particle effects and sounds here
            }
        }
    }
}