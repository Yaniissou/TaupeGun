package fr.yanissou.taupegun.runnables;

import com.connorlinfoot.titleapi.TitleAPI;
import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.tools.Prefix;
import fr.yanissou.taupegun.tools.Reflection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitTask;

public class StartRunnable implements Runnable {
    private int compteur;
    private BukkitTask task;
    private Taupegun instance;

    public StartRunnable(Taupegun instance) {
        this.compteur = 10;
        this.instance = instance;


    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public BukkitTask getTask() {
        return task;
    }

    public void setTask(BukkitTask task) {
        this.task = task;
        System.out.println("Task has been set to " + task.getTaskId());
    }


    @Override
    public void run() {

        if (getCompteur() != 0) {
            Bukkit.broadcastMessage(Prefix.TAUPEGUN.getPrefix() + "§7Lancement de la partie dans §c" + getCompteur() + " §7secondes !");
            float pitch = 2.0f - ((float) (10 - getCompteur()) / 10.0f * 1.4f);
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1.0f, pitch);
                TitleAPI.sendTitle(player,0,21,0, "§c"+ getCompteur(),"§7Lancement de la partie dans");
            });
            setCompteur(getCompteur() - 1);



        } else {
            Bukkit.broadcastMessage("§cGame is starting !");
            instance.getGame().start();
            getTask().cancel();
        }
    }
}
