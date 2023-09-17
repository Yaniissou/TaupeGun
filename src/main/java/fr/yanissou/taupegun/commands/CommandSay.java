package fr.yanissou.taupegun.commands;

import fr.yanissou.taupegun.tools.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSay implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player sender = ((Player) commandSender).getPlayer();
            if (!sender.isOp()){
                sender.sendMessage(Prefix.ERREUR + " §cVous n'avez pas la permission d'exécuter cette commande.");
                return true;
            }
            StringBuilder message = new StringBuilder();
            for (String string : strings) {
                message.append(string).append(" ");
            }
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage(Prefix.HOST.getPrefix() + sender.getName() + "§r§8 : §e" + message.toString().replace("&","§"));
            Bukkit.broadcastMessage(" ");
            return true;
        }
        return false;
    }
}
