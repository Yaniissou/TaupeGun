package fr.yanissou.taupegun.listeners;

import fr.yanissou.taupegun.Game;
import fr.yanissou.taupegun.GameState;
import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.inventories.CustomItems;
import fr.yanissou.taupegun.inventories.HostInventories;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
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

import java.lang.reflect.Field;

public class PlayerListeners implements Listener {
    private final Taupegun instance;

    public PlayerListeners(Taupegun instance) {
        this.instance = instance;
    }

    private static boolean isValid(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) {
            return false;
        }
        if (event.getCurrentItem().getType() == Material.AIR || event.getCurrentItem().isSimilar(CustomItems.host_glass)) {
            event.setCancelled(true);
            return false;
        } else return true;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        instance.getUserManager().onJoin(event.getPlayer());
        instance.getScoreboardManager().onLogin(event.getPlayer());
        setTab(event.getPlayer());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        instance.getUserManager().onQuit(event.getPlayer());
        instance.getScoreboardManager().onLogout(event.getPlayer());
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (!GameState.isState(GameState.WAITING) && !GameState.isState(GameState.STARTING)) {
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
        if (GameState.isState(GameState.WAITING)){
            if (event.getEntity() instanceof Player) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (GameState.isState(GameState.WAITING)) {
            event.setCancelled(true);
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
                if (!isValid(event)) return;
                switch (event.getCurrentItem().getType()) {
                    case INK_SACK:
                        instance.getGame().startrebours();
                        break;
                    case COMMAND:
                        event.setCancelled(true);
                        event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                        break;
                    case BARRIER:
                        event.getWhoClicked().openInventory(HostInventories.getInventaireBorder(instance));
                        break;
                    case WATCH:
                        event.setCancelled(true);
                        event.getWhoClicked().openInventory(HostInventories.getInventaireTimer(instance));
                }

            case "Scenarios":

                if (!isValid(event)) return;

                if (CustomItems.scenario_items_names.contains(event.getCurrentItem().getItemMeta().getDisplayName())) {
                    switch (event.getCurrentItem().getType()) {
                        case IRON_INGOT:
                            instance.getScenarioManager().setCutClean(!instance.getScenarioManager().isCutClean());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            break;
                        case DIAMOND_PICKAXE:
                            instance.getScenarioManager().setHasteyBoys(!instance.getScenarioManager().isHasteyBoys());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            break;
                        case IRON_PICKAXE:
                            System.out.println("WENT HERE");
                            instance.getScenarioManager().setHasteyBabies(!instance.getScenarioManager().isHasteyBabies());
                            event.getWhoClicked().openInventory(HostInventories.getInventaireScenarios(instance));
                            System.out.println(instance.getScenarioManager().isHasteyBabies());
                            break;
                    }
                }

                if (event.getCurrentItem().getType().equals(Material.ARROW)) {
                    event.getWhoClicked().openInventory(HostInventories.getInventairePrincipal(GameState.isState(GameState.STARTING)));
                }
            case "Bordure":
                if (!isValid(event)) return;
                if (event.getCurrentItem().isSimilar(CustomItems.border_initialSize)) {
                    switch (event.getClick()) {
                        case LEFT:
                            instance.getBorderManager().addInitialBorder();
                            break;
                        case RIGHT:
                            instance.getBorderManager().subInitialBorder();
                    }
                    event.getWhoClicked().openInventory(HostInventories.getInventaireBorder(instance));
                } else if (event.getCurrentItem().isSimilar(CustomItems.border_finalSize)) {
                    switch (event.getClick()) {
                        case LEFT:
                            instance.getBorderManager().addFinalBorder();
                            break;
                        case RIGHT:
                            instance.getBorderManager().subFinalBorder();
                    }
                    event.getWhoClicked().openInventory(HostInventories.getInventaireBorder(instance));
                }
                break;
            case "Timers":
                if (!isValid(event)) return;
                if (event.getCurrentItem().isSimilar(CustomItems.timer_border)){
                    switch (event.getClick()){
                        case LEFT:
                            instance.getBorderManager().addActivationBorder();
                            break;
                        case RIGHT:
                            instance.getBorderManager().subActivationBorder();
                            break;
                    }
                    event.getWhoClicked().openInventory(HostInventories.getInventaireTimer(instance));
                } else if (event.getCurrentItem().isSimilar(CustomItems.timer_pvp)){
                    switch (event.getClick()){
                        case LEFT:
                            instance.getPvpManager().addPvPTime();
                            break;
                        case RIGHT:
                            instance.getPvpManager().subPvPTime();
                            break;
                    }
                    event.getWhoClicked().openInventory(HostInventories.getInventaireTimer(instance));
                }
        }

    }

    public void setTab(Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;

        // Set the header and footer
        IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.RED + "\n§c§lTAUPE GUN\n" + "\"}");
        IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.YELLOW + "\n§7Plugin par §cYanissou"+ "\"}");

        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(header);
        try {
            Field field = packet.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(packet, footer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Send the packet to the player
        craftPlayer.getHandle().playerConnection.sendPacket(packet);
    }
}





