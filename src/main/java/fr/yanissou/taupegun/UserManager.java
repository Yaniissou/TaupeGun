package fr.yanissou.taupegun;

import fr.yanissou.taupegun.inventories.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserManager {
    private final Taupegun instance;
    private final Map<UUID, User> users;

    public UserManager() {
        this.instance = Taupegun.getInstance();
        this.users = new HashMap<>();
    }

    public void onJoin(Player player) {
        if (GameState.isState(GameState.WAITING)) {

            clearPlayer(player);
            users.put(player.getUniqueId(), new User(player, true));
            player.setFoodLevel(20);
            player.setGameMode(GameMode.ADVENTURE);
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + player.getDisplayName());
            if (player.isOp()) {
                player.getInventory().addItem(CustomItems.host_config);
                player.setAllowFlight(true);
            }
            player.getInventory().addItem(CustomItems.host_teams);
        }
        //elsif(GameState.isState(...){
        //}
    }

    public void onQuit(Player player) {
        if (GameState.isState(GameState.WAITING)) {
            users.remove(player.getUniqueId());
        }
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + player.getDisplayName());
    }


    public void clearPlayer(Player player) {
        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
        for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(activePotionEffect.getType());
        }
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setAllowFlight(false);
        player.setLevel(0);
        player.setExp(0);
    }

    public Optional<User> getUser(UUID uuid) {
        return Optional.ofNullable(users.get(uuid));
    }
}
