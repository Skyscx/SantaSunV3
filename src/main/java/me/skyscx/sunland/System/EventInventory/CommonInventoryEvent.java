package me.skyscx.sunland.System.EventInventory;
import me.skyscx.sunland.System.System;
import me.skyscx.sunland.System.inventory.CommonInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.Objects;
import static me.skyscx.sunland.assets.messages.*;

public class CommonInventoryEvent implements Listener {
    @EventHandler
    public void OnClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals(I_018 + " | 1")){
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null){
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_008)){
                    System.lottery(player);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_020)){
                    player.closeInventory();
                    CommonInventory.CI_1(player, 2);
                }
                e.setCancelled(true);
            }
        }
        if (e.getView().getTitle().equals(I_018 + " | 2")){
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null){
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_008)){
                    System.lottery(player);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_020)){
                    player.closeInventory();
                    CommonInventory.CI_1(player, 1);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_021)){
                    player.closeInventory();
                    CommonInventory.CI_1(player, 3);
                }
                e.setCancelled(true);
            }
        }

    }
}
