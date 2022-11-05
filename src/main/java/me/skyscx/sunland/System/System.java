package me.skyscx.sunland.System;

import me.skyscx.sunland.Sunland;
import me.skyscx.sunland.System.inventory.MyInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static me.skyscx.sunland.assets.messages.*;

public class System {
    String PN;
    public Boolean STATUS = Sunland.getPlugin().getConfig().getBoolean("STATUS");
    public static void SM(Player player, String message){player.sendMessage(message);}
    public static void SC(String message){java.lang.System.out.println(message);}
    Boolean verif;
    public Boolean getSTATUS(){return STATUS;}
    public static void CI(Player player){
        player.closeInventory();
    }
    Boolean CBB_B;
    public Boolean CBB(Player player){
        if (
                        player.getInventory().getItemInMainHand().getType().equals(Material.AIR) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.BEDROCK) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.WATER) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.LAVA) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.END_PORTAL_FRAME) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.END_PORTAL) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_PORTAL) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.REPEATING_COMMAND_BLOCK) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.CHAIN_COMMAND_BLOCK) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.COMMAND_BLOCK_MINECART) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.COMMAND_BLOCK) ||
                        player.getInventory().getItemInMainHand().getType().equals(Material.BARRIER)

        ){
            this.CBB_B = Boolean.FALSE;
            return false;
        }else {
            this.CBB_B = Boolean.TRUE;
            return true;
        }
    }//Проверка бан-блокс
    public static void DB_IS(Player player){
        ItemStack block = player.getInventory().getItemInMainHand();
        player.getInventory().removeItem(block);
    }//Удаление блока у игрока
    public static void SB_IS_C(Player player){
        String name = player.getName();
        ItemStack block = player.getInventory().getItemInMainHand();
        ItemMeta meta_block = block.getItemMeta();
        assert meta_block != null;
        meta_block.setLore(Collections.singletonList("§fПредмет игрока §3" + name + "§f."));
        block.setItemMeta(meta_block);
        int INDIF = Sunland.getPlugin().getConfig().getInt("INDIF");
        Sunland.getPlugin().getConfig().set("BLOCKS." + INDIF + "."  + "Type",block);
        Sunland.getPlugin().getConfig().set("BLOCKS." + INDIF + "."  + "Name",name);
        SM(player, P_009);
        int i = INDIF + 1;
        Sunland.getPlugin().getConfig().set("INDIF", i);
        Sunland.getPlugin().saveConfig();
    }//Сохранение блока в конфиг
    public boolean GNSB(Player player){

        int INDIF = Sunland.getPlugin().getConfig().getInt("INDIF");
        INDIF--;
        String name = player.getName();
        int i = 0;
        while (INDIF >= 1){
            INDIF--;
            String NAME = Sunland.getPlugin().getConfig().getString("BLOCKS." + INDIF + "."  + "Name");

            assert NAME != null;
            if (NAME.equals(name)){
                i++;
            }
        }
        if (i == 8 || i>8 || i < 0){
            return false;
        }else {
            return true;
        }
    }//Проверка на лимит блоков.
    public static void BAB(Player player){
        int INDIF = Sunland.getPlugin().getConfig().getInt("INDIF");
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<ItemStack>  blocks = new ArrayList<>();
        while (INDIF >= 1){
            INDIF--;
            String NAME = Sunland.getPlugin().getConfig().getString("BLOCKS." + INDIF + "."  + "Name");
            if (Objects.equals(NAME, player.getName())){
                integers.add(INDIF);
            }
        }

        int longs = integers.size();
        int i = 0;
        while (longs >= 1){
            longs = longs-1;
            int indif = integers.get(i);
            i++;
            ItemStack block = Sunland.getPlugin().getConfig().getItemStack("BLOCKS." + indif + "."  + "Type");
            blocks.add(block);

        }
        DBC(integers);
        GPB(player,blocks);
        int m = blocks.size();
        SC(String.valueOf(m));
    }
    public static void DBC(ArrayList<Integer> integers){
        int size = integers.size();
        while (size >= 1){
            size--;
            int indif = integers.get(size);
            Sunland.getPlugin().getConfig().set("BLOCKS." + indif + ".Type",null);
            Sunland.getPlugin().getConfig().set("BLOCKS." + indif + ".Name","_DELETE_44123214SDF");
            Sunland.getPlugin().saveConfig();
        }
    }
    public static void GPB(Player player, ArrayList<ItemStack> blocks){
        int size = blocks.size();
        while (size >= 1){
            size--;
            ItemStack block = blocks.get(size);
            player.getInventory().addItem(block);
        }
        SM(player, P_013);
    }
    public static void lottery(Player player){

    }
}
