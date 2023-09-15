package fr.yanissou.taupegun.tools;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public enum Prefix {

    TAUPEGUN(ChatColor.DARK_GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "TAUPE GUN" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET),
    CLIDEBUG("[DEBUG]"),
    IGDEBUG(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + ChatColor.BOLD + "DEBUG" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET);

    private final String prefix;
    Prefix(String prefix) {
        this.prefix = prefix;

    }
    public String getPrefix() {
        return prefix;
    }



}
