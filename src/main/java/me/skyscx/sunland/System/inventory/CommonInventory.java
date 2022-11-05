package me.skyscx.sunland.System.inventory;

import me.skyscx.sunland.Sunland;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.skyscx.sunland.assets.messages.*;

public class CommonInventory {
    public static void CI_1(Player player, int a){
        Inventory CI_1 = Bukkit.createInventory(null, 54, I_018 + " | 1");
        Inventory CI_2 = Bukkit.createInventory(null, 54, I_018 + " | 2");
        //menu
        int INDIF = Sunland.getPlugin().getConfig().getInt("INDIF");
        int i = 0;
        while (INDIF >= 0){
            ItemStack block = Sunland.getPlugin().getConfig().getItemStack("BLOCKS." + INDIF +  "." + "Type");
            if (i < 52){
                CI_1.setItem(i,block);

            }
            int i2 = 0;
            if (i >= 52 & i <= 103){
                i2++;
                CI_2.setItem(i2,block);

            }
            i++;
            INDIF--;
        }
        //info block
        ItemStack b1 = new ItemStack(Material.DIAMOND);
        ItemMeta meta_b1 = b1.getItemMeta();
        assert meta_b1 != null;
        meta_b1.setDisplayName(I_008);
        meta_b1.setLore(Arrays.asList(I_022,I_023,I_024,I_025));
        b1.setItemMeta(meta_b1);
        CI_1.setItem(0,b1);
        CI_2.setItem(0,b1);
        //nextPage
        ItemStack paper2 = new ItemStack(Material.PAPER);
        ItemMeta meta_paper2 = paper2.getItemMeta();
        assert meta_paper2 != null;
        meta_paper2.setDisplayName(I_020);
        paper2.setItemMeta(meta_paper2);
        CI_1.setItem(53,paper2);
        CI_2.setItem(53,paper2);
        //backPage
        ItemStack back = new ItemStack(Material.PAPER);
        ItemMeta meta_back = back.getItemMeta();
        assert meta_back != null;
        meta_back.setDisplayName(I_021);
        back.setItemMeta(meta_back);
        CI_2.setItem(52,paper2);

        if (a == 1){
            player.openInventory(CI_1);
        }
        if (a == 2){
            player.openInventory(CI_2);
        }

    }



}
