package fr.yanissou.taupegun.runnables;

import fr.yanissou.taupegun.CustomTeam;
import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.tools.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TeleportRunnable implements Runnable {
    private Taupegun instance;
    private int increment;
    private BukkitTask task;

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    public TeleportRunnable(Taupegun instance) {
        this.instance = instance;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }

    public Taupegun getInstance() {
        return instance;
    }

    public void setTask(BukkitTask task) {
        this.task = task;
        System.out.println("Task has been set to " + task.getTaskId());
    }

    public BukkitTask getTask() {
        return task;
    }

    @Override
    public void run() {

        List<Location> positions = getInstance().getGame().getPositions();
        Set<UUID> uuids = new HashSet<>();
        for (CustomTeam customTeam : getInstance().getCustomTeamManager().getCustomTeams()) {
            if (uuids.size() !=0){
                uuids.clear();
            }

            try {
                uuids = customTeam.getUsers();
                uuids.forEach(uuid -> {
                    Bukkit.getPlayer(uuid).teleport(positions.get(getIncrement()));
                    Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP,1,1));
                });

            }catch (NullPointerException e){
                System.out.println(Prefix.CLIDEBUG + " Users from Team " + customTeam.getCustomTeamUnit().getName() + "is empty (expected)");
            }
            setIncrement(getIncrement()+1);

        }
        getTask().cancel();
    }
}
