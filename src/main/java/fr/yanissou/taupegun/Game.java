package fr.yanissou.taupegun;

import fr.yanissou.taupegun.runnables.StartRunnable;
import fr.yanissou.taupegun.runnables.TeleportRunnable;
import fr.yanissou.taupegun.runnables.TimerRunnable;
import fr.yanissou.taupegun.tools.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class Game {
    private final World world;
    private final World nether;
    private Taupegun instance;
    private TimerRunnable timerRunnable;
    private int episode;
    private List<Location> positions;


    public Game(Taupegun instance) {
        this.positions = new ArrayList<>();
        this.world = Bukkit.getWorld("world");
        this.nether = Bukkit.getWorld("nether");
        this.instance = instance;
        this.episode = 1;
    }

    public void startrebours() {
        GameState.setState(GameState.STARTING);
        StartRunnable startRunnable = new StartRunnable(Taupegun.getInstance());
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(Taupegun.getInstance(), startRunnable, 0, 20);
        startRunnable.setTask(bukkitTask);

    }

    public void start() {
        GameState.setState(GameState.PLAYING);
        clearTeams();
        setupSpawns();
        Bukkit.getWorlds().forEach(w -> {
            w.getWorldBorder().setSize(instance.getBorderManager().getInitialBordersSize());
        });
        Bukkit.getOnlinePlayers().forEach(p -> {
            p.setFlying(false);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().clear();
            p.setFoodLevel(20);
            p.setSaturation(14.4f);

        });
        TeleportRunnable teleportRunnable = new TeleportRunnable(instance);
        BukkitTask bukkitTaskTeleport = Bukkit.getScheduler().runTaskTimer(Taupegun.getInstance(),teleportRunnable,0,10);
        teleportRunnable.setTask(bukkitTaskTeleport);

        //this.positions.forEach(location -> Bukkit.broadcastMessage("Position : " + location.getX()+"," + location.getY()+","+location.getZ()));
        Bukkit.broadcastMessage("Game has started");

        this.timerRunnable = new TimerRunnable(Taupegun.getInstance());
        BukkitTask bukkitTaskTimer = Bukkit.getScheduler().runTaskTimer(Taupegun.getInstance(), timerRunnable, 0, 20);
        timerRunnable.setTask(bukkitTaskTimer);

        instance.getScenarioManager().registerScenarios();



    }

    public TimerRunnable getTimerRunnable() {
        return timerRunnable;
    }

    public void addEpisode() {
        this.episode++;
    }

    public int getEpisode() {
        return episode;
    }

    public List<Location> getPositions() {
        return positions;
    }

    private void teleportPlayers(float distance) {

        float incremente = 0;
        float min = (float) (2 * Math.PI / instance.getCustomTeamManager().getCustomTeams().size());

        for (CustomTeam customTeam : instance.getCustomTeamManager().getCustomTeams()) {
            Location center = world.getSpawnLocation();
            Location location = new Location(world, 0, world.getHighestBlockYAt(0, 0), 0);
            int dx = (int) (Math.cos(incremente) * distance);
            int dy = (int) (Math.sin(incremente) * distance);
            incremente += min;

            for (UUID uuid : customTeam.getUsers()) {
                try {
                    Player player = Bukkit.getPlayer(uuid);


                } catch (NullPointerException e) {
                    Bukkit.getLogger().warning(Prefix.CLIDEBUG + " Getting player by a UUID went bad (Game.java)");
                }
            }
        }

    }

    public void setupSpawns() {

        //Clear les positions au cas ou
        this.positions.clear();

        int nbrTeam = instance.getCustomTeamManager().getCustomTeams().size();
        double delta = (2 * Math.PI) / nbrTeam;
        double angle = 0;

        for (int i = 0; i < nbrTeam; i++) {
            int x = (int) (((instance.getBorderManager().getInitialBordersSize() / 2) - 100) * Math.sin(angle));
            int z = (int) (((instance.getBorderManager().getInitialBordersSize() / 2) - 100) * Math.cos(angle));

            angle += delta;
            positions.add(new Location(world, x + 0.5, world.getHighestBlockYAt(x,z)+0.5, z + 0.5));
        }
    }

    public void clearTeams(){
        Set<CustomTeam> customTeams = instance.getCustomTeamManager().getCustomTeams();
        customTeams.removeIf(customTeam -> customTeam.getUsers().isEmpty());

        Bukkit.broadcastMessage("Teams restantes :");
        for (CustomTeam customTeam : customTeams) {
            Bukkit.broadcastMessage(customTeam.getCustomTeamUnit().getName());
        }
    }

    public void teleportPlayers(){

    }
}
