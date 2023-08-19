package fr.yanissou.taupegun;

import fr.yanissou.taupegun.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Taupegun extends JavaPlugin {

    public static Taupegun instance;

    public static Game game;

    private UserManager userManager;
    private CustomTeamManager customTeamManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        GameState.setState(GameState.WAITING);
        FileConfiguration config = getConfig();
        registerListeners();
        game = new Game();
        userManager = new UserManager();
        customTeamManager = new CustomTeamManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayerListeners(this),this);
    }

    public UserManager getUserManager() {
        return userManager;
    }
    public CustomTeamManager getCustomTeamManager() {
        return customTeamManager;
    }

    public static Taupegun getInstance() {
        return instance;
    }


}
