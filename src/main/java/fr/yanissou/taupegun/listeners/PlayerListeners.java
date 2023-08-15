package fr.yanissou.taupegun.listeners;

import fr.yanissou.taupegun.CustomItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if (event.getPlayer().isOp()){
            event.getPlayer().getInventory().addItem(CustomItems.host_config);
        }
    }
}
