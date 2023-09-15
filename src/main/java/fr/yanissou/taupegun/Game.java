package fr.yanissou.taupegun;

import fr.yanissou.taupegun.runnables.StartRunnable;
import fr.yanissou.taupegun.runnables.TimerRunnable;
import fr.yanissou.taupegun.tools.Prefix;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
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

    private void teleportPlayers(float distance){

        float incremente = 0;
        float min = (float) (2 * Math.PI/instance.getCustomTeamManager().getCustomTeams().size());

        for (CustomTeam customTeam : instance.getCustomTeamManager().getCustomTeams()) {
            Location center = world.getSpawnLocation();
            Location location = new Location(world,0,world.getHighestBlockYAt(0,0),0);
            int dx = (int) (Math.cos(incremente) * distance);
            int dy = (int) (Math.sin(incremente) * distance);
            incremente += min;

            for (UUID uuid : customTeam.getUsers()){
                try {
                    Player player = Bukkit.getPlayer(uuid);

                }catch(NullPointerException e){
                    Bukkit.getLogger().warning(Prefix.CLIDEBUG + " Getting player by a UUID went bad (Game.java)");
                }
            }
        }

    }
}
