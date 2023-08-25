package fr.yanissou.taupegun.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutCleanListeners implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            switch (event.getBlock().getType()) {
                case IRON_ORE:
                    work(event, block, Material.IRON_INGOT);
                    break;
                case GOLD_ORE:
                    work(event, block, Material.GOLD_ORE);
                    break;
            }
        }
    }

    private void spawnXP(Block block) {
        ExperienceOrb exp = block.getWorld().spawn(block.getLocation().add(0.5, 0.3, 0.5), ExperienceOrb.class);
        exp.setExperience(3);
    }

    private void work(BlockBreakEvent event, Block block, Material material) {
        event.setCancelled(true);
        block.setType(Material.AIR);
        block.getState().update();
        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(material));
        spawnXP(block);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Cow) {
            for (ItemStack drops : event.getDrops()) {
                if (drops.getType() == Material.RAW_BEEF) {
                    drops.setType(Material.COOKED_BEEF);
                }
            }
        } else if (entity instanceof Chicken) {
            for (ItemStack drops : event.getDrops()) {
                if (drops.getType() == Material.RAW_CHICKEN) {
                    drops.setType(Material.COOKED_CHICKEN);
                }
            }
        }else if (entity instanceof Pig) {
            for (ItemStack drops : event.getDrops()) {
                if (drops.getType() == Material.PORK) {
                    drops.setType(Material.GRILLED_PORK);
                }
            }
        }
        }
    }

