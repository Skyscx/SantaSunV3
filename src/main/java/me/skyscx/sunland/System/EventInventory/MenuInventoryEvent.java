package me.skyscx.sunland.System.EventInventory;

import me.skyscx.sunland.Sunland;
import me.skyscx.sunland.System.System;
import me.skyscx.sunland.System.inventory.CommonInventory;
import me.skyscx.sunland.System.inventory.MenuInventory;
import me.skyscx.sunland.assets.messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

import static me.skyscx.sunland.System.System.*;
import static me.skyscx.sunland.assets.messages.*;

public class MenuInventoryEvent implements Listener {
    System system = new System();
    @EventHandler
    public void OnClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getType().equals(InventoryType.HOPPER)){
            if (e.getView().getTitle().equals(I_005)){
                if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() == null){
                    return;
                }
                if (player.hasPermission("santa.admin") || player.isOp()){
                    //open
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_003)){
                        Sunland.getPlugin().getConfig().set("STATUS", true);
                        SM(player, P_000);
                    }
                    //close
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_004)){
                        Sunland.getPlugin().getConfig().set("STATUS", false);
                        SM(player, P_001);
                    }
                    //openCommonInv
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_002)){
                        CI(player);
                        CommonInventory.CI_1(player, 1);
                        e.setCancelled(true);
                        return;

                    }
                    CI(player);
                    MenuInventory.MI(player);
                    e.setCancelled(true);
                }else{
                    SM(player, P_004);}
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(I_007)){
                    CI(player);
                    SM(player, P_002);
                }
            }
        }
    }
}
