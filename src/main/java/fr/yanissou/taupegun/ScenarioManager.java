package fr.yanissou.taupegun;

import fr.yanissou.taupegun.listeners.scenarios.CutCleanListeners;
import fr.yanissou.taupegun.listeners.scenarios.HasteyBabiesListeners;
import fr.yanissou.taupegun.listeners.scenarios.HasteyBoysListeners;
import org.bukkit.Bukkit;

public class ScenarioManager {
    private final Taupegun instance;

    private boolean etatCutClean;
    private boolean etatHasteyBoys;
    private boolean etatHasteyBabies;
    public ScenarioManager(Taupegun instance){
        this.instance = instance;
        this.etatCutClean = true;
        this.etatHasteyBoys = false;
        this.etatHasteyBabies = false;

    }

    public boolean isCutClean() {
        return etatCutClean;
    }

    public void setCutClean(boolean etatCutClean) {
        this.etatCutClean = etatCutClean;
    }

    public boolean isHasteyBoys() {
        return etatHasteyBoys;
    }

    public void setHasteyBoys(boolean etatHasteyBoys) {
        this.etatHasteyBoys = etatHasteyBoys;
    }

    public boolean isHasteyBabies() {
        return etatHasteyBabies;
    }

    public void setHasteyBabies(boolean etatHasteyBabies) {
        this.etatHasteyBabies = etatHasteyBabies;
    }

    public void registerScenarios(){
        if (isCutClean()){
            Bukkit.getPluginManager().registerEvents(new CutCleanListeners(),instance);
        }
        if (isHasteyBoys()){
            Bukkit.getPluginManager().registerEvents(new HasteyBoysListeners(),instance);
        }
        if (isHasteyBabies()){
            Bukkit.getPluginManager().registerEvents(new HasteyBabiesListeners(),instance);
        }
    }
}
