package fr.yanissou.taupegun;

import fr.yanissou.taupegun.listeners.PlayerListeners;
import fr.yanissou.taupegun.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class Taupegun extends JavaPlugin {

    public static Taupegun instance;

    public static Game game;

    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    private UserManager userManager;
    private CustomTeamManager customTeamManager;
    private ScenarioManager scenarioManager;
    private BorderManager borderManager;
    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        GameState.setState(GameState.WAITING);
        FileConfiguration config = getConfig();
        Bukkit.getLogger().warning("Went here !");
        instance = this;
        game = new Game(instance);
        userManager = new UserManager();
        scenarioManager = new ScenarioManager(this);
        customTeamManager = new CustomTeamManager(this);
        borderManager = new BorderManager();
        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();


        Bukkit.getLogger().warning("Done that");
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getScoreboardManager().onDisable();
    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new PlayerListeners(this),this);
    }



    public void registerActiveScenarios(){

    }
    public UserManager getUserManager() {
        return userManager;
    }
    public CustomTeamManager getCustomTeamManager() {
        return this.customTeamManager;
    }

    public static Taupegun getInstance() {
        return instance;
    }

    public ScenarioManager getScenarioManager() {
        return scenarioManager;
    }

    public BorderManager getBorderManager() {
        return borderManager;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public Game getGame() {
        return game;
    }
}
