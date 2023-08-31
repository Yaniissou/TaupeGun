package fr.yanissou.taupegun.runnables;

import fr.yanissou.taupegun.Taupegun;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitTask;

public class TimerRunnable implements Runnable{

    private int minutes;
    private int secondes;
    private BukkitTask task;
    private Taupegun instance;
    private String formattedTime;

    public TimerRunnable(Taupegun instance){
        this.secondes = 0;
        this.minutes = 0;
        this.instance = instance;
    }

    @Override
    public void run() {
        if (secondes == 59){
            minutes++;
            secondes = 0;
            if (minutes%20 == 0){
                changeEpisode();
            }

        }else secondes++;
        this.formattedTime = String.format("%02d:%02d", minutes, secondes);



    }

    public void setTask(BukkitTask task) {
        this.task = task;
        System.out.println("Task has been set to " + task.getTaskId());
    }

    public String getFormattedTime() {
        return formattedTime;
    }
    private void changeEpisode(){
        instance.getGame().addEpisode();
        Bukkit.broadcastMessage(ChatColor.GOLD + "Début du jour " + ChatColor.YELLOW + instance.getGame().getEpisode());
    }
}
