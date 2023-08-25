package fr.yanissou.taupegun.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HasteyBoysListeners implements Listener {

        private static List<Material> items = Arrays.asList(
                Material.WOOD_AXE,
                Material.WOOD_PICKAXE,
                Material.STONE_AXE,
                Material.STONE_PICKAXE,
                Material.IRON_AXE,
                Material.IRON_PICKAXE,
                Material.GOLD_AXE,
                Material.GOLD_PICKAXE,
                Material.DIAMOND_AXE,
                Material.DIAMOND_PICKAXE,
                Material.WOOD_SPADE,
                Material.STONE_SPADE,
                Material.IRON_SPADE,
                Material.GOLD_SPADE,
                Material.DIAMOND_SPADE);


    @EventHandler
    public void onPreCraft(PrepareItemCraftEvent event){
        addHastey(event, items);
    }

    static void addHastey(PrepareItemCraftEvent event, List<Material> items) {
        System.out.println("precraft is triggered");
        if (items.contains(event.getRecipe().getResult().getType())){
            System.out.println("item is a pickaxe");
            ItemMeta im = event.getRecipe().getResult().getItemMeta();
            ItemStack newitem = event.getRecipe().getResult();
            im.addEnchant(Enchantment.DIG_SPEED,3,true);
            im.addEnchant(Enchantment.DURABILITY,3,true);

            newitem.setItemMeta(im);
            event.getInventory().setResult(newitem);
            System.out.println("added enchant");
        }
    }
}
