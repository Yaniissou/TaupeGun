package fr.yanissou.taupegun.inventories;

import fr.yanissou.taupegun.ItemBuilder;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class CustomItems {

    public static final ItemStack host_config = new ItemBuilder(Material.NETHER_STAR).setName("§c§lConfigurer").setLore("§7Configurer la partie","§8Clic droit").build();
    public static final ItemStack host_teams = new ItemBuilder(Material.BANNER).setData((short) 12).setName("§b§lChoisir une équipe").setLore("§7Choisir une équipe","§8Clic droit").build();


    public static final ItemStack host_glass = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.GRAY).setName(" ").build();
    public static final ItemStack host_start = new ItemBuilder(Material.INK_SACK).setData(DyeColor.LIME.getDyeData()).setName("§a§lLancer la partie").build();
    public static final ItemStack host_stop = new ItemBuilder(Material.INK_SACK).setData(DyeColor.RED.getDyeData()).setName("§c§lStopper le lancement de la partie").build();
}
