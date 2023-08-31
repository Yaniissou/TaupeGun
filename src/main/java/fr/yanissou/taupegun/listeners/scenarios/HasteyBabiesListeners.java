package fr.yanissou.taupegun.listeners.scenarios;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

import java.util.Arrays;
import java.util.List;

public class HasteyBabiesListeners implements Listener {

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
        HasteyBoysListeners.addHastey(event, items);
    }


}
