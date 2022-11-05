package me.skyscx.sunland.System.EventInventory;

import me.skyscx.sunland.System.inventory.MyInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static me.skyscx.sunland.System.System.BAB;
import static me.skyscx.sunland.assets.messages.*;

public class MyInventoryEvent implements Listener {
    @EventHandler
    public void OnClick(InventoryClickEvent e){
        if (e.getView().getTitle().equals(I_006)){
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null){
               e.setCancelled(true);
            }
        }
    }
}
