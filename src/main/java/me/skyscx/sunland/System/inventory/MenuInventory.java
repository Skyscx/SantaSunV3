package me.skyscx.sunland.System.inventory;

import me.skyscx.sunland.System.System;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.skyscx.sunland.assets.messages.*;
import static org.bukkit.event.inventory.InventoryType.HOPPER;

public class MenuInventory {
    public static void MI(Player player){
        System system = new System();
        Boolean STATUS = system.getSTATUS();
        Inventory MENU = Bukkit.createInventory(null, HOPPER, I_005);
        //OpenEvent
        if (STATUS == Boolean.FALSE){
            if (player.hasPermission("santa.admin") || player.isOp()){
                ItemStack StartEventSanta = new ItemStack(Material.GREEN_WOOL);
                ItemMeta meta_StartEventSanta = StartEventSanta.getItemMeta();
                assert meta_StartEventSanta != null;
                meta_StartEventSanta.setDisplayName(I_003);
                StartEventSanta.setItemMeta(meta_StartEventSanta);
                MENU.setItem(0,StartEventSanta);
            }
        }
        //CloseEvent
        if (STATUS == Boolean.TRUE){
            if (player.hasPermission("santa.admin") || player.isOp()){
                ItemStack StopEventSanta = new ItemStack(Material.RED_WOOL);
                ItemMeta meta_StopEventSanta = StopEventSanta.getItemMeta();
                assert meta_StopEventSanta != null;
                meta_StopEventSanta.setDisplayName(I_004);
                StopEventSanta.setItemMeta(meta_StopEventSanta);
                MENU.setItem(0,StopEventSanta);
            }
        }
        //CheckAllSendBlocks
        if (player.hasPermission("santa.admin") || player.isOp()){
            ItemStack CheckAllBlocks = new ItemStack(Material.ENDER_EYE);
            ItemMeta meta_CheckAllBlocks = CheckAllBlocks.getItemMeta();
            assert meta_CheckAllBlocks != null;
            meta_CheckAllBlocks.setDisplayName(I_002);
            CheckAllBlocks.setItemMeta(meta_CheckAllBlocks);
            MENU.setItem(1,CheckAllBlocks);
        }
        //INFORMATION1
        ItemStack Info1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta metaInfo1 = Info1.getItemMeta();
        assert metaInfo1 != null;
        metaInfo1.setDisplayName(I_008);
        metaInfo1.setLore(Arrays.asList(I_009,I_017,I_010, I_011 ,I_012,I_017,I_016));
        Info1.setItemMeta(metaInfo1);
        MENU.setItem(2, Info1);
        //INFORMATION2
        ItemStack Info2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta metaInfo2 = Info1.getItemMeta();
        assert metaInfo2 != null;
        metaInfo2.setDisplayName(I_008);
        metaInfo2.setLore(Arrays.asList(I_009,I_017,I_013,I_014,I_015,I_017,I_016));
        Info2.setItemMeta(metaInfo2);
        MENU.setItem(3, Info2);
        //CloseMenu
        ItemStack CloseEvent = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta metaCloseEvent = CloseEvent.getItemMeta();
        assert metaCloseEvent != null;
        metaCloseEvent.setDisplayName(I_007);
        CloseEvent.setItemMeta(metaCloseEvent);
        MENU.setItem(4, CloseEvent);

        player.openInventory(MENU);

    }
}
