package fr.yanissou.taupegun.listeners;

import fr.yanissou.taupegun.GameState;
import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.inventories.CustomItems;
import fr.yanissou.taupegun.inventories.HostInventories;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    private final Taupegun plugin;

    public PlayerListeners(Taupegun plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        plugin.getUserManager().onJoin(event.getPlayer());


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        plugin.getUserManager().onQuit(event.getPlayer());
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (!GameState.isState(GameState.WAITING)) {
            return;
        }
        if (!event.hasItem()) {
            return;
        }
        if (!event.getItem().getItemMeta().hasDisplayName()) {
            return;
        }

        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        switch (event.getItem().getItemMeta().getDisplayName()) {
            case "§c§lConfigurer":
                // vvv ici j'ai fix aussi t'avais une condition qui faisait rien de spécial comme nepal tavu jai les refs je consomme du rap en grande quantite et pas du rap de ientcli comme tout ses bobos de gauche fan de la newvawe moi je ne suis pas de ce bord la j'adore b2o et autres rhoffs ainsi que Fouinni babe
                event.getPlayer().openInventory(HostInventories.getInventairePrincipal(GameState.isState(GameState.STARTING)));
                break;
            case "§b§lChoisir une équipe":
                event.getPlayer().openInventory(HostInventories.getInventaireTeams());
                break;
        }

    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        if (GameState.isState(GameState.WAITING)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        switch (event.getInventory().getName()){
            case "Choix des équipes":
                if (!event.getInventory().getName().equals(HostInventories.getInventaireTeams().getName())) {
                    return;
                }
                if (event.getCurrentItem() == null) {
                    return;
                }

                if (!(event.getCurrentItem().getType() == Material.BANNER)){
                    event.setCancelled(true);
                    return;
                }

                    if (event.getCurrentItem().getType() == Material.AIR){
                        return;
                    }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CustomItems.host_teams.getItemMeta().getDisplayName())) {
                    event.setCancelled(true);
                    return;
                }

                if (event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem().isSimilar(CustomItems.host_glass)) {
                    event.setCancelled(true);
                    return;

                }
                if (event.getInventory().getName() != null && event.getInventory().getName().equals(HostInventories.getInventaireTeams().getName())) {
                    plugin.getCustomTeamManager().clickOnTeamBanner((Player) event.getWhoClicked(), event.getCurrentItem());
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();

                }
                break;
        }

    }
}
