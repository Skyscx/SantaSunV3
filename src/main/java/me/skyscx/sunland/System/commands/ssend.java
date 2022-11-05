package me.skyscx.sunland.System.commands;

import me.skyscx.sunland.System.System;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.skyscx.sunland.System.System.*;
import static me.skyscx.sunland.assets.messages.*;

public class ssend implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System system = new System();
        Boolean STATUS = system.getSTATUS();
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (STATUS == Boolean.TRUE){
                if (system.CBB(player) == Boolean.TRUE){
                    if (system.GNSB(player) == Boolean.TRUE){
                        SB_IS_C(player);
                        DB_IS(player);
                    }else {
                        SM(player, P_012);
                    }

                } else if (system.CBB(player) == Boolean.FALSE) {
                    SM(player, P_008);
                }
            } else if (STATUS == Boolean.FALSE) {
                SM(player,P_007);
            }else {
                SM(player,P_006);
            }
        }else {
            SC(C_001);
        }
        return false;
    }
}
