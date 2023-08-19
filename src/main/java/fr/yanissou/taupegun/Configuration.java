package fr.yanissou.taupegun;



import java.util.Arrays;
import java.util.HashMap;

public class Configuration {

    private boolean diamondLimitOn = true;
    private int diamond_limit = 17;
    private int dl_xp_diamond = 4; //Vanilla == 4


    private boolean cutCleanOn = true;
    private int cc_xp_iron = 1;    //Vanilla = 0.7
    private int cc_xp_gold = 1;    //Vanilla = 0.7

    private boolean noFallOn = true;
    private boolean timberOn = false;
    private int timberBlockLimit = 5;

    private boolean modifyAppleRate = true;         //Won't drop saplings if on
    private float appleRate = 10F;         //Vanilla = 0.5


    //private HashMap<EnumRoles, Integer> mapEnumrolesNombre;

    Configuration(){

    };



    public boolean isDiamondLimitOn() {
        return diamondLimitOn;
    }

    public void setDiamondLimitOn(boolean diamondLimitOn) {
        this.diamondLimitOn = diamondLimitOn;
    }

    public int getDiamond_limit() {
        return diamond_limit;
    }

    public void setDiamond_limit(int diamond_limit) {
        this.diamond_limit = diamond_limit;
    }

    public boolean isCutCleanOn() {
        return cutCleanOn;
    }

    public void setCutCleanOn(boolean cutCleanOn) {
        this.cutCleanOn = cutCleanOn;
    }

    public int getDl_xp_diamond() {
        return dl_xp_diamond;
    }

    public void setDl_xp_diamond(int experience_points) {
        this.dl_xp_diamond = experience_points;
    }

    public int getCc_xp_iron() {
        return cc_xp_iron;
    }

    public void setCc_xp_iron(int experience_points) {
        this.cc_xp_iron = experience_points;
    }

    public int getCc_xp_gold() {
        return cc_xp_gold;
    }

    public void setCc_xp_gold(int experience_points) {
        this.cc_xp_gold = experience_points;
    }

    public boolean isNoFallOn(){
        return noFallOn;
    }

    public void setNoFallOn(boolean noFallOn){
        this.noFallOn = noFallOn;
    }

    public boolean isTimberOn() {
        return timberOn;
    }

    public void setTimberOn(boolean timberOn) {
        this.timberOn = timberOn;
    }

    public int getTimberBlockLimit() {
        return timberBlockLimit;
    }

    public void setTimberBlockLimit(int recursion_bottom) {
        this.timberBlockLimit = recursion_bottom;
    }

    public boolean isModifyAppleRate() {
        return modifyAppleRate;
    }

    public void setModifyAppleRate(boolean modifyAppleRate) {
        this.modifyAppleRate = modifyAppleRate;
    }

    public float getAppleRate() {
        return appleRate;
    }

    public void setAppleRate(float pourcent) {
        this.appleRate = pourcent;
    }

/*    public HashMap<EnumRoles, Integer> getMapEnumrolesNombre() {
        return mapEnumrolesNombre;
    }

    public void setMapEnumrolesNombre(HashMap<EnumRoles, Integer> mapEnumrolesNombre) {
        this.mapEnumrolesNombre = mapEnumrolesNombre;
    }*/
}