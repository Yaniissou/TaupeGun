package fr.yanissou.taupegun;

public class PvPManager {
    private int pvpTime;

    public PvPManager(){
        this.pvpTime = 20*60;
    }

    public int getPvpTime() {
        return pvpTime;
    }

    public void addPvPTime(){
        this.pvpTime = this.pvpTime + 60;
    }
    public void subPvPTime(){
        this.pvpTime = this.pvpTime - 60;
    }
}
