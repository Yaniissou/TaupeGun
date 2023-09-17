package fr.yanissou.taupegun.inventories;


import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.TeamEnum;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HostInventories {
    public static Inventory getInventairePrincipal(boolean starting) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Configuration");
        addIndivGlass(inventory);
        inventory.setItem(10,CustomItems.host_scenarios);
        inventory.setItem(11,CustomItems.host_border);
        inventory.setItem(12,CustomItems.host_timers);
        if (!starting) {
            inventory.setItem(22,CustomItems.host_start);
        } else {
            inventory.setItem(22,CustomItems.host_stop);
        }


        return inventory;
    }

    public static Inventory getInventaireTeams() {
        Inventory inventory = Bukkit.createInventory(null, 54, "Choix des équipes");
        addIndivGlass(inventory);
        for (TeamEnum teamEnum : TeamEnum.values()){{
                inventory.addItem(teamEnum.getItem());
            }

        }

        return inventory;
    }

    public static Inventory getInventaireScenarios(Taupegun instance){
        Inventory inventory = Bukkit.createInventory(null,27,"Scenarios");
        addIndivGlass(inventory);
        addBasedOnConfig(inventory,CustomItems.scenario_cutclean, instance.getScenarioManager().isCutClean(),10);
        addBasedOnConfig(inventory,CustomItems.scenario_hasteyboys,instance.getScenarioManager().isHasteyBoys(),11);
        addBasedOnConfig(inventory,CustomItems.scenario_hasteybabies,instance.getScenarioManager().isHasteyBabies(),12);
        inventory.setItem(22,CustomItems.host_cancel);

        return inventory;
    }

    public static Inventory getInventaireBorder(Taupegun instance){
        Inventory inventory = Bukkit.createInventory(null,27,"Bordure");
        addIndivGlass(inventory);

        inventory.setItem(10,setBorderInitializeInfo(CustomItems.border_initialSize,instance));
        inventory.setItem(11,setBorderFinalInfo(CustomItems.border_finalSize,instance));

        return inventory;
    }

    public static Inventory getInventaireTimer(Taupegun instance){
        Inventory inventory = Bukkit.createInventory(null,27,"Timers");
        addIndivGlass(inventory);

        inventory.setItem(10,setBorderActivationInfo(CustomItems.timer_border,instance));
        inventory.setItem(11,setPvPActivationInfo(CustomItems.timer_pvp,instance));
        return inventory;
    }

/*    public static final Inventory getInventaireScenar(Configuration configuration){
        Inventory inventory = Bukkit.createInventory(null ,27, "SCENARIOS");

        addIndivGlass(inventory);

        addBasedOnConfig(inventory, Objets.scenar_dl, configuration.isDiamondLimitOn());
        addBasedOnConfig(inventory, Objets.scenar_cc, configuration.isCutCleanOn());
        addBasedOnConfig(inventory, Objets.scenar_nf, configuration.isNoFallOn());
        addBasedOnConfig(inventory, Objets.scenar_timber, configuration.isTimberOn());
        addBasedOnConfig(inventory, Objets.scenar_mapr, configuration.isModifyAppleRate());
        addIndivGlass(inventory, 10);

        inventory.addItem(Objets.host_config);
        return inventory;
    }*/


    private static void addIndivGlass(Inventory inventory) {
        int size = inventory.getSize();
        //0 1 7 8 9 17  size-1  size-2 size-8 size-9 size-10 size-18
        inventory.setItem(0, CustomItems.host_glass);
        inventory.setItem(1, CustomItems.host_glass);
        inventory.setItem(7, CustomItems.host_glass);
        inventory.setItem(8, CustomItems.host_glass);
        inventory.setItem(9, CustomItems.host_glass);
        inventory.setItem(17, CustomItems.host_glass);
        inventory.setItem(size - 1, CustomItems.host_glass);
        inventory.setItem(size - 2, CustomItems.host_glass);
        inventory.setItem(size - 8, CustomItems.host_glass);
        inventory.setItem(size - 9, CustomItems.host_glass);
        inventory.setItem(size - 10, CustomItems.host_glass);
        inventory.setItem(size - 18, CustomItems.host_glass);


    }


    public static void addBasedOnConfig(Inventory inventory, ItemStack stack, boolean param, int index) {
        int amount = 1;
        if (!param){
            amount = 0;
        }

        stack.setAmount(amount);
        inventory.setItem(index,stack);

    }

    public static ItemStack setBorderInitializeInfo(ItemStack it, Taupegun instance){
        ItemMeta im = it.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Taille initiale : " + instance.getBorderManager().getInitialBordersSize());
        it.setItemMeta(im);
        return it;
    }

    public static ItemStack setBorderFinalInfo(ItemStack it, Taupegun instance){
        ItemMeta im = it.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Taille finale : " + instance.getBorderManager().getFinalBordersSize());
        it.setItemMeta(im);
        return it;
    }

    public static ItemStack setBorderActivationInfo(ItemStack it, Taupegun instance){
        ItemMeta im = it.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Activation de la Bordure : " + formatTimeHoursMinutes(instance.getBorderManager().getBorderTime()));
        it.setItemMeta(im);
        return it;
    }

    public static ItemStack setPvPActivationInfo(ItemStack it,Taupegun instance){
        ItemMeta im = it.getItemMeta();
        im.setDisplayName(ChatColor.AQUA + "Activation du PvP : " + secondsToMinutes(instance.getPvpManager().getPvpTime()) + "mins");
        it.setItemMeta(im);
        return it;
    }

    public static String formatTimeHoursMinutes(int minutes){

        // Calculate hours and minutes
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        // Format the time using String.format with leading zeros

        return String.format("%02dh%02d", hours, remainingMinutes);
    }

    public static String secondsToMinutes(int seconds){
        return String.valueOf(seconds/60);
    }







   /* private static void addBasedOnConfig(Inventory inventory, ItemStack stack, boolean param) {
        int amount = 1;
        if (!param) {
            amount = 0;
        }

        stack.setAmount(amount);
        inventory.addItem(stack);
    }

        inventory.setItem(inventory.firstEmpty(), addWithLore(stack, (int) value, "", 3));

    }

    private static ItemStack addWithLore(ItemStack stack, int value, String unite, int pos) {
        return new ItemBuilder(stack).addLoreLine("Valeur actuelle : " + value + unite, pos).toItemStack();
    }*/
}