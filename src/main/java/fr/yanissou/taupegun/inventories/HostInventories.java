package fr.yanissou.taupegun.inventories;


import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.TeamEnum;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class HostInventories {
    public static final Inventory getInventairePrincipal(boolean starting) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Configuration");
        addIndivGlass(inventory);
        inventory.setItem(10,CustomItems.host_scenarios);
        if (!starting) {
            inventory.setItem(22,CustomItems.host_start);
        } else {
            inventory.setItem(22,CustomItems.host_stop);
        }


        return inventory;
    }

    public static final Inventory getInventaireTeams() {
        Inventory inventory = Bukkit.createInventory(null, 54, "Choix des équipes");
        addIndivGlass(inventory);
        for (TeamEnum teamEnum : TeamEnum.values()){
            if (!teamEnum.equals(TeamEnum.DEFAULT) && !teamEnum.equals(TeamEnum.SPECTATORS)){
                inventory.addItem(teamEnum.getItem());
            }

        }

        return inventory;
    }

    public static final Inventory getInventaireScenarios(Taupegun instance){
        Inventory inventory = Bukkit.createInventory(null,27,"Scenarios");
        addIndivGlass(inventory);
        addBasedOnConfig(inventory,CustomItems.scenario_cutclean, instance.getScenarioManager().isCutClean(),10);
        addBasedOnConfig(inventory,CustomItems.scenario_hasteyboys,instance.getScenarioManager().isHasteyBoys(),11);
        addBasedOnConfig(inventory,CustomItems.scenario_hasteybabies,instance.getScenarioManager().isHasteyBabies(),11);
        inventory.setItem(22,CustomItems.host_cancel);

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