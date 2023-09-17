package fr.yanissou.taupegun.runnables;

import fr.yanissou.taupegun.Taupegun;
import fr.yanissou.taupegun.tools.Prefix;
import fr.yanissou.taupegun.tools.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitTask;

public class StartRunnable implements Runnable {
    private int compteur;
    private BukkitTask task;
    private Taupegun instance;
    private String message;


    public StartRunnable(Taupegun instance) {
        this.compteur = 10;
        this.instance = instance;
        this.message = "§7Lancement de la partie dans §c" + getCompteur() + " §7secondes !";

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
                new Title(String.valueOf(getCompteur()),"§7Lancement de la partie dans").send(Bukkit.getOnlinePlayers(),0,2,0);
            });
            setCompteur(getCompteur() - 1);



        } else {
            Bukkit.broadcastMessage("§cGame is starting !");
            instance.getGame().start();
            getTask().cancel();
        }
    }
}
