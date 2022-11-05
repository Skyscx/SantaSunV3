package me.skyscx.sunland.System.inventory;

import me.skyscx.sunland.Sunland;
import me.skyscx.sunland.System.System;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static me.skyscx.sunland.System.System.SC;
import static me.skyscx.sunland.System.System.SM;
import static me.skyscx.sunland.assets.messages.*;

public class MyInventory {
    public static void My_Blocks(Player player){
        int NUM1 = -1;
        int NUM2 = -1;
        int NUM3 = -1;
        int NUM4 = -1;
        int NUM5 = -1;
        int NUM6 = -1;
        int NUM7 = -1;
        int NUM8 = -1;
        int NUM9 = -1;
        String name = player.getName();
        Inventory MI = Bukkit.createInventory(null,9, I_006);
        int INDIF = Sunland.getPlugin().getConfig().getInt("INDIF");
        while (INDIF >= 1){
            INDIF--;
            String NAME = Sunland.getPlugin().getConfig().getString("BLOCKS." + INDIF + "."  + "Name");
            if (NAME.equals(name)){
                if (NUM1 == -1){
                    NUM1 = INDIF;
                } else if (NUM2 == -1) {
                    NUM2 = INDIF;
                }
                else if (NUM3 == -1) {
                    NUM3 = INDIF;
                }
                else if (NUM4 == -1) {
                    NUM4 = INDIF;
                }
                else if (NUM5 == -1) {
                    NUM5 = INDIF;
                }
                else if (NUM6 == -1) {
                    NUM6 = INDIF;
                }
                else if (NUM7 == -1) {
                    NUM7 = INDIF;
                }
                else if (NUM8 == -1) {
                    NUM8 = INDIF;
                }
                else if (NUM9 == -1) {
                    NUM9 = INDIF;
                } else {
                    SM(player, P_011);
                }
            }

        }
        int i = 0;
        while (i < 9){
            int indif = -1;
            if (i == 0){
                indif = NUM1;
            }
            if (i == 1){
                indif = NUM2;
            }
            if (i == 2){
                indif = NUM3;
            }
            if (i == 3){
                indif = NUM4;
            }
            if (i == 4){
                indif = NUM5;
            }
            if (i == 5){
                indif = NUM6;
            }
            if (i == 6){
                indif = NUM7;
            }
            if (i == 7){
                indif = NUM8;
            }
            if (i == 8){
                indif = NUM9;
            }

            ItemStack block = Sunland.getPlugin().getConfig().getItemStack("BLOCKS." + indif +  "." + "Type");
            MI.setItem(i,block);
            i++;

        }

        player.openInventory(MI);
    }
}
