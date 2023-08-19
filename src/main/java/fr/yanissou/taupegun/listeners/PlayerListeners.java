package fr.yanissou.taupegun.listeners;

import fr.yanissou.taupegun.GameState;
import fr.yanissou.taupegun.ItemBuilder;
import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.TeamEnum;
import fr.yanissou.taupegun.inventories.HostInventories;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

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
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(null);
        plugin.getUserManager().onQuit(event.getPlayer());
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (!GameState.isState(GameState.WAITING)){
            return;
        }
        if (!event.hasItem()) {
            return;
        }
        if (!event.getItem().getItemMeta().hasDisplayName()){
            return;
        }

        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        switch (event.getItem().getItemMeta().getDisplayName()) {
            case "§c§lConfigurer":
                if (GameState.isState(GameState.STARTING))
                    event.getPlayer().openInventory(HostInventories.getInventairePrincipal(true));
                else event.getPlayer().openInventory(HostInventories.getInventairePrincipal(false));
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
    public void onInventoryClick(InventoryClickEvent event){
        if (!event.getClick().equals(ClickType.LEFT)){
            event.setCancelled(true);
        }
        else {
            if (event.getClickedInventory().getName().equals(HostInventories.getInventaireTeams().getName())){
                event.setCancelled(true);
                plugin.getCustomTeamManager().clickOnBanner((Player) event.getWhoClicked(),event.getCurrentItem());
            }
        }
    }
}
