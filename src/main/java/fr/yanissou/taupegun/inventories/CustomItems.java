package fr.yanissou.taupegun.inventories;

import fr.yanissou.taupegun.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomItems {

    private static final String lore = "§7Clic gauche pour §a§lactiver§7/§c§ldésactiver";
    private static final String lore_add = "§7Clic gauche pour §a§lajouter";
    private static final String lore_sub = "§7Clic droit pour §c§lretirer";

    public static final ItemStack host_config = new ItemBuilder(Material.NETHER_STAR).setName("§c§lConfigurer").setLore("§7Configurer la partie","§8Clic droit").build();
    public static final ItemStack host_teams = new ItemBuilder(Material.BANNER).setData((short) 12).setName("§b§lChoisir une équipe").setLore("§7Choisir une équipe","§8Clic droit").build();


    public static final ItemStack host_glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.GRAY).setName(" ").build();
    public static final ItemStack host_cancel = new ItemBuilder(Material.ARROW).setName("§cRetour").setLore("§7Retourner au menu précédent").build();

    public static final ItemStack host_start = new ItemBuilder(Material.INK_SACK).setData(DyeColor.LIME.getDyeData()).setName("§a§lLancer la partie").build();
    public static final ItemStack host_stop = new ItemBuilder(Material.INK_SACK).setData(DyeColor.RED.getDyeData()).setName("§c§lStopper le lancement").build();
    public static final ItemStack host_scenarios = new ItemBuilder(Material.COMMAND).setName(ChatColor.AQUA + "Scenarios").setLore(ChatColor.GRAY + "Configurer les scenarios").build();
    public static final ItemStack host_border = new ItemBuilder(Material.BARRIER).setName(ChatColor.AQUA + "Bordure").setLore(ChatColor.GRAY + "Configurer la bordure").build();
    public static final ItemStack host_timers = new ItemBuilder(Material.WATCH).setName(ChatColor.AQUA + "Timers").setLore(ChatColor.GRAY + "Configurer les timers").build();


    public static final ItemStack scenario_cutclean = new ItemBuilder(Material.IRON_INGOT).setName(ChatColor.AQUA + "CutClean")
            .setLore(lore).build();
    public static final ItemStack scenario_hasteyboys = new ItemBuilder(Material.DIAMOND_PICKAXE).setName(ChatColor.AQUA + "HasteyBoys")
            .setLore(lore).build();
    public static final ItemStack scenario_hasteybabies = new ItemBuilder(Material.IRON_PICKAXE).setName(ChatColor.AQUA + "HasteyBabies")
            .setLore(lore).build();

    public static final ArrayList<String> scenario_items_names = new ArrayList<>(Arrays.asList(
            scenario_cutclean.getItemMeta().getDisplayName(),
            scenario_hasteyboys.getItemMeta().getDisplayName(),
            scenario_hasteybabies.getItemMeta().getDisplayName()));


    public static final ItemStack border_initialSize = new ItemBuilder(Material.BANNER).setData((short) 1)
                 .setName(ChatColor.AQUA + "Taille initiale :")
            .setLore(lore_add,lore_sub).build();

    public static final ItemStack border_finalSize = new ItemBuilder(Material.BANNER).setData((short) 2)
            .setName(ChatColor.AQUA + "Taille finale :")
            .setLore(lore_add,lore_sub).build();
    public static final ItemStack timer_border = new ItemBuilder(Material.BARRIER)
            .setName(ChatColor.AQUA + "Activation de la Bordure : xx:xx")
            .setLore(lore_add,lore_sub).build();
    public static final ItemStack timer_pvp = new ItemBuilder(Material.DIAMOND_SWORD)
            .setName(ChatColor.AQUA + "Activation du PvP : xx:xx" )
            .setLore(lore_add,lore_sub).build();

}
