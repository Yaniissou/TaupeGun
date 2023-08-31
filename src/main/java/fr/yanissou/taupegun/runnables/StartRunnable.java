package fr.yanissou.taupegun.runnables;

import fr.yanissou.taupegun.Taupegun;
import org.bukkit.Bukkit;
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
            Bukkit.broadcastMessage("§7Lancement de la partie dans §c" + getCompteur() + " §7secondes !");
            setCompteur(getCompteur() - 1);

        } else {
            Bukkit.broadcastMessage("§cGame is starting !");
            instance.getGame().start();
            getTask().cancel();
        }
    }
}
