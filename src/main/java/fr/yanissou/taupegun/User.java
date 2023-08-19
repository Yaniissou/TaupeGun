package fr.yanissou.taupegun;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class User {
    private final UUID uuid;
    private final String name;
    private boolean alive;
    private int kill;
    private TeamEnum teamEnum;

    private UUID lastMsg;

    private ItemStack[] inventory;
    private ItemStack[] armors;
    private int level;
    private float exp;

    public User(Player player, boolean alive) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();
        this.alive = alive;
        this.kill = 0;
        this.teamEnum = null;
    }


    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public void addKill() {
        this.kill++;
    }

    public TeamEnum getTeam() {
        return teamEnum;
    }

    public void setTeam(TeamEnum teamEnum) {
        this.teamEnum = teamEnum;
    }

    public UUID getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(UUID lastMsg) {
        this.lastMsg = lastMsg;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public ItemStack[] getArmors() {
        return armors;
    }

    public void setArmors(ItemStack[] armors) {
        this.armors = armors;
    }

    public String getColoredName() {
        return teamEnum.getPrefix() + name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public void setCustomTeamUnit(TeamEnum customTeamUnit) {
        this.teamEnum = customTeamUnit;
    }

}
