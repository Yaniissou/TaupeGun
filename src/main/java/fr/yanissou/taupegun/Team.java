package fr.yanissou.taupegun;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public enum Team {
    DEFENDERS("0001Défenseurs", ChatColor.AQUA.toString(), null),
    ATTACKERS("002Attaquants", ChatColor.RED.toString(), null),

    // ★, ❤, ☁, ☺
    RED("002RED", ChatColor.RED.toString(), new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED1("002RED1", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED2("002RED2", ChatColor.RED + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED3("002RED3", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED4("002RED4", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    ORANGE("003ORANGE", ChatColor.GOLD.toString(), new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE1("003ORANGE1", ChatColor.GOLD + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE2("003ORANGE2", ChatColor.GOLD + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE3("003ORANGE3", ChatColor.GOLD + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE4("003ORANGE4", ChatColor.GOLD + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    YELLOW("004YELLOW", ChatColor.YELLOW + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW1("004YELLOW1", ChatColor.YELLOW + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW2("004YELLOW2", ChatColor.YELLOW + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW3("004YELLOW3", ChatColor.YELLOW + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW4("004YELLOW4", ChatColor.YELLOW + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    BLUE("005BLUE", ChatColor.BLUE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE1("005BLUE1", ChatColor.BLUE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE2("005BLUE2", ChatColor.BLUE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE3("005BLUE3", ChatColor.BLUE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE4("005BLUE4", ChatColor.BLUE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    CYAN("006CYAN", ChatColor.DARK_AQUA.toString(), new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN1("006CYAN1", ChatColor.DARK_AQUA + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN2("006CYAN2", ChatColor.DARK_AQUA + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN3("006CYAN3", ChatColor.DARK_AQUA + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN4("006CYAN4", ChatColor.DARK_AQUA + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    PURPLE("007PURPLE", ChatColor.DARK_PURPLE.toString(), new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE1("007PURPLE1", ChatColor.DARK_PURPLE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE2("007PURPLE2", ChatColor.DARK_PURPLE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE3("007PURPLE3", ChatColor.DARK_PURPLE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE4("007PURPLE4", ChatColor.DARK_PURPLE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    PINK("008PINK", ChatColor.LIGHT_PURPLE.toString(), new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK1("008PINK1", ChatColor.LIGHT_PURPLE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK2("008PINK2", ChatColor.LIGHT_PURPLE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK3("008PINK3", ChatColor.LIGHT_PURPLE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK4("008PINK4", ChatColor.LIGHT_PURPLE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    GRAY("009GRAY", ChatColor.DARK_GRAY.toString(), new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY1("009GRAY1", ChatColor.DARK_GRAY + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY2("009GRAY2", ChatColor.DARK_GRAY + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY3("009GRAY3", ChatColor.DARK_GRAY + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY4("009GRAY4", ChatColor.DARK_GRAY + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    LIME("010LIME", ChatColor.GREEN.toString(), new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    LIME1("010LIME1", ChatColor.GREEN + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    LIME2("010LIME2", ChatColor.GREEN + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    LIME3("010LIME3", ChatColor.GREEN + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    LIME4("010LIME4", ChatColor.GREEN + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    DEFAULT("998Default", ChatColor.GRAY.toString(), null),
    SPECTATORS("999Spectators", ChatColor.GRAY + "§o[SPEC] ", null);

    Team(String name, String prefix, ItemStack item) {
        this.name = name;
        this.prefix = prefix;
        this.item = item;
    }

    public void update(List<String> players) {
        if (item != null) {
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide");
            lore.add(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide");
            if (players != null) {
                int i = 0;
                for (String player : players) {
                    lore.set(i, ChatColor.GRAY + "- " + player);
                    i++;
                }
            }
            item = new ItemBuilder(item).setLore(lore).build();
        }
    }

    private final String name;
    private final String prefix;
    private ItemStack item;

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public ItemStack getItem() {
        return item;
    }
}
