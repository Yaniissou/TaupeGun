package fr.yanissou.taupegun;

import fr.yanissou.taupegun.runnables.StartRunnable;
import fr.yanissou.taupegun.runnables.TimerRunnable;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Game {
    private World world;
    private World nether;
    private Taupegun instance;
    private TimerRunnable timerRunnable;
    private int episode;



    public Game(Taupegun instance) {
        this.world = Bukkit.getWorld("world");
        this.nether = Bukkit.getWorld("nether");
        this.instance = instance;
        this.episode = 1;
    }

    public void startrebours(){
        GameState.setState(GameState.STARTING);
        StartRunnable startRunnable = new StartRunnable(Taupegun.getInstance());
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(Taupegun.getInstance(), startRunnable,0,20);
        startRunnable.setTask(bukkitTask);
    }
    public void start(){
        GameState.setState(GameState.PLAYING);
        Bukkit.getWorlds().forEach(w-> {
            w.getWorldBorder().setSize(instance.getBorderManager().getInitialBordersSize());
        });
        Bukkit.broadcastMessage("Game has started");
        this.timerRunnable = new TimerRunnable(Taupegun.getInstance());

        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(Taupegun.getInstance(),timerRunnable,0,20);
        timerRunnable.setTask(bukkitTask);

    }

    public TimerRunnable getTimerRunnable() {
        return timerRunnable;
    }

    public void addEpisode(){
        this.episode++;
    }

    public int getEpisode() {
        return episode;
    }
}
