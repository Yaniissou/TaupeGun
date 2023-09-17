package fr.yanissou.taupegun;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public enum TeamEnum {

    // ★, ❤, ☁, ☺
    RED("Rouge", ChatColor.RED.toString(), new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED1("Rouge ⬤", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED2("Rouge ❤", ChatColor.RED + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED3("Rouge ✖", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    RED4("Rouge ✦", ChatColor.RED + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 1).setName(ChatColor.RED + "Rouge ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    ORANGE("Orange", ChatColor.GOLD.toString(), new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE1("Orange ⬤", ChatColor.GOLD + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE2("Orange ❤", ChatColor.GOLD + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE3("Orange ✖", ChatColor.GOLD + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    ORANGE4("Orange ✦", ChatColor.GOLD + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 14).setName(ChatColor.GOLD + "Orange ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    YELLOW("Jaune", ChatColor.YELLOW.toString(), new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW1("Jaune ⬤", ChatColor.YELLOW + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW2("Jaune ❤", ChatColor.YELLOW + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW3("Jaune ✖", ChatColor.YELLOW + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    YELLOW4("Jaune ✦", ChatColor.YELLOW + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 11).setName(ChatColor.YELLOW + "Jaune ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    BLUE("Bleu", ChatColor.BLUE.toString(), new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE1("Bleu ⬤", ChatColor.BLUE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE2("Bleu ❤", ChatColor.BLUE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE3("Bleu ✖", ChatColor.BLUE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    BLUE4("Bleu ✦", ChatColor.BLUE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 4).setName(ChatColor.BLUE + "Bleu ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    CYAN("Cyan foncé", ChatColor.DARK_AQUA.toString(), new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN1("Cyan foncé ⬤", ChatColor.DARK_AQUA + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN2("Cyan foncé ❤", ChatColor.DARK_AQUA + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN3("Cyan foncé ✖", ChatColor.DARK_AQUA + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    CYAN4("Cyan foncé ✦", ChatColor.DARK_AQUA + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 6).setName(ChatColor.DARK_AQUA + "Cyan foncé ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    PURPLE("Violet", ChatColor.DARK_PURPLE.toString(), new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE1("Violet ⬤", ChatColor.DARK_PURPLE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE2("Violet ❤", ChatColor.DARK_PURPLE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE3("Violet ✖", ChatColor.DARK_PURPLE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PURPLE4("Violet ✦", ChatColor.DARK_PURPLE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 5).setName(ChatColor.DARK_PURPLE + "Violet ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    PINK("Rose", ChatColor.LIGHT_PURPLE.toString(), new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK1("Rose ⬤", ChatColor.LIGHT_PURPLE + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK2("Rose ❤", ChatColor.LIGHT_PURPLE + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK3("Rose ✖", ChatColor.LIGHT_PURPLE + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    PINK4("Rose ✦", ChatColor.LIGHT_PURPLE + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 9).setName(ChatColor.LIGHT_PURPLE + "Rose ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    GRAY("Gris", ChatColor.DARK_GRAY.toString(), new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY1("Gris ⬤", ChatColor.DARK_GRAY + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY2("Gris ❤", ChatColor.DARK_GRAY + "❤ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ❤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY3("Gris ✖", ChatColor.DARK_GRAY + "✖ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ✖").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    GRAY4("Gris ✦", ChatColor.DARK_GRAY + "✦ ", new ItemBuilder(Material.BANNER).setData((byte) 8).setName(ChatColor.DARK_GRAY + "Gris ✦").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),

    LIME("Vert clair", ChatColor.GREEN.toString(), new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build()),
    LIME1("Vert clair ⬤", ChatColor.GREEN + "⬤ ", new ItemBuilder(Material.BANNER).setData((byte) 10).setName(ChatColor.GREEN + "Vert clair ⬤").setLore(ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide", ChatColor.GRAY + "- " + ChatColor.ITALIC + "vide").build());


    TeamEnum(String name, String prefix, ItemStack item) {
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
