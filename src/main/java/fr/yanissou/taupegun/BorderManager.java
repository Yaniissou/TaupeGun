package fr.yanissou.taupegun;

import org.bukkit.Bukkit;

public class BorderManager {

    private int borderTime;
    private int initialBordersSize;
    private int finalBordersSize;
    private int bordersSpeed;
    private boolean border;

    public BorderManager() {
        this.borderTime = 2 * 120;
        this.initialBordersSize = 750 * 2;
        this.finalBordersSize = 125 * 2;
        this.bordersSpeed = 10;
        border = false;
    }

    public int getBorderTime() {
        return borderTime;
    }

    public void setBorderTime(int borderTime) {
        this.borderTime = borderTime;
    }


    public void reduceBorders() {
        border = true;
        Bukkit.getWorlds().forEach(w -> w.getWorldBorder().setSize(finalBordersSize, (long) getTimeReduction()));
    }

    public double getTimeReduction() {
        return (initialBordersSize - finalBordersSize) / (bordersSpeed / 5f);
    }

    public int getInitialBordersSize() {
        return initialBordersSize;
    }

    public void setInitialBordersSize(int initialBordersSize) {
        this.initialBordersSize = initialBordersSize;


        /*
        if (initialBordersSize > (2000 * 2)) {
            this.initialBordersSize = 2000 * 2;
        } else if (initialBordersSize < (250 * 2)) {
            this.initialBordersSize = 250 * 2;
        } else {
            this.initialBordersSize = initialBordersSize;
        }
         */
    }

    public int getFinalBordersSize() {
        return finalBordersSize;
    }

    public void setFinalBordersSize(int finalBordersSize) {
        this.finalBordersSize = finalBordersSize;

        //Explication de Utils.minMax (en gros c'est un isBetween mais flemme de le faire)
        /*
        if (finalBordersSize > (250 * 2)) {
            this.finalBordersSize = 250 * 2;
        } else if (finalBordersSize <= 50 * 2) {
            this.finalBordersSize = 50 * 2;
        } else {
            this.finalBordersSize = finalBordersSize;
        }
         */
    }

    public int getBordersSpeed() {
        return bordersSpeed;
    }

    public void setBordersSpeed(int bordersSpeed) {
        this.bordersSpeed = bordersSpeed;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public void addInitialBorder(){
        this.initialBordersSize = initialBordersSize + 50;
    }

    public void subInitialBorder(){
        this.initialBordersSize = initialBordersSize - 50;
    }

    public void addFinalBorder(){
        this.finalBordersSize = finalBordersSize + 50;
    }

    public void subFinalBorder(){
        this.finalBordersSize = finalBordersSize - 50;
    }

    public void addBorderSpeed(){

    }
}
