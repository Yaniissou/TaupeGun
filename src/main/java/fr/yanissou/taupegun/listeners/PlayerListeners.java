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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    private final Taupegun instance;

    public PlayerListeners(Taupegun instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        instance.getUserManager().onJoin(event.getPlayer());


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        instance.getUserManager().onQuit(event.getPlayer());
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
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (GameState.isState(GameState.WAITING)){
         //   event.setCancelled(true);
        }
        switch (event.getInventory().getName()) {
            case "Choix des équipes":

                if (event.getCurrentItem() == null) {
                    return;
                }

                if (!(event.getCurrentItem().getType() == Material.BANNER)) {
                    event.setCancelled(true);
                    return;
                }

                if (event.getCurrentItem().getType() == Material.AIR) {
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
                    instance.getCustomTeamManager().clickOnTeamBanner((Player) event.getWhoClicked(), event.getCurrentItem());
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();

                }
                break;
            case "Configuration":
                if (event.getCurrentItem() == null) {
                    return;
                }
                if (event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem().isSimilar(CustomItems.host_glass)) {
                    event.setCancelled(true);
                    return;
                }

                if (event.getCurrentItem().getType() == Material.INK_SACK){
                    instance.getScenarioManager().registerScenarios();
                }

                if (event.getCurrentItem().getType() == Material.COMMAND) {
                    event.setCancelled(true);
                    event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                    return;
                }

                break;
            case "Scenarios":

                if (event.getCurrentItem() == null) {
                    System.out.println("current item is null");
                    return;
                }
                if (event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem().isSimilar(CustomItems.host_glass)) {
                    event.setCancelled(true);
                    System.out.println("item is air or is glass");
                    return;
                }

                if (CustomItems.scenario_items_names.contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
                    System.out.println("this is custom item");
                    switch (event.getCurrentItem().getType()){
                        case IRON_INGOT:
                            instance.getScenarioManager().setCutClean(!instance.getScenarioManager().isCutClean());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            break;
                        case DIAMOND_PICKAXE:
                            instance.getScenarioManager().setHasteyBoys(!instance.getScenarioManager().isHasteyBoys());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            break;
                        case IRON_PICKAXE:
                            instance.getScenarioManager().setHasteyBabies(!instance.getScenarioManager().isHasteyBabies());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            break;
                    }
                }

                if (event.getCurrentItem().getType().equals(Material.ARROW)){
                    event.getWhoClicked().openInventory(HostInventories.getInventairePrincipal(GameState.isState(GameState.STARTING)));
                }

        }

    }
}




