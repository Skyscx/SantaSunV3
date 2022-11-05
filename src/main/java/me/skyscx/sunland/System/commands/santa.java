package me.skyscx.sunland.System.commands;

import me.skyscx.sunland.System.System;
import me.skyscx.sunland.System.inventory.MenuInventory;
import me.skyscx.sunland.assets.messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.skyscx.sunland.System.System.SC;
import static me.skyscx.sunland.System.System.SM;

public class santa implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            System system = new System();
            Boolean STATUS = system.getSTATUS();
            SM(player,STATUS.toString());
            MenuInventory.MI(player);
            SC("1");
        }else{
            SC(messages.C_001);
            SC("0");
        }
        return true;
    }
}
