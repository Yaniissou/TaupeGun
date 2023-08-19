package fr.yanissou.taupegun;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CustomTeamManager {
    private final Taupegun instance;

    private final Set<CustomTeam> customTeams;
    private final Scoreboard teamScoreboard;

    public CustomTeamManager(Taupegun instance){
        this.instance = instance;


        this.customTeams = new HashSet<>();
        this.teamScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        for (TeamEnum teamEnum : TeamEnum.values()) {
            createTeam(teamEnum);
        }
    }

    public void createTeam(TeamEnum teamEnum) {
        customTeams.add(new CustomTeam(teamEnum, teamScoreboard));
    }

    public void addPlayerTeam(Player player, TeamEnum teamEnum) {

        getTeam(teamEnum).ifPresent(customTeam -> {
            instance.getUserManager().getUser(player.getUniqueId()).ifPresent(user -> {
                for (CustomTeam ct : customTeams) {
                    ct.getUsers().remove(user.getUuid());
                }
                customTeam.getTeam().addEntry(player.getName());
                customTeam.getUsers().add(user.getUuid());
                user.setCustomTeamUnit(teamEnum);
            });
        });
    }

    public Optional<CustomTeam> getTeam(TeamEnum teamEnum) {
        return customTeams.stream().filter(customTeam -> customTeam.getCustomTeamUnit() == teamEnum).findFirst();
    }

    public CustomTeam getCustomTeamByName(String name) {
        for (CustomTeam customTeam : customTeams){
            if (customTeam.getCustomTeamUnit().getName().equals(name)){
                return customTeam;
            }
        }
        return null;
    }

    public void clickOnBanner(Player player, ItemStack itemStack){
        player.sendMessage(itemStack.getItemMeta().getDisplayName());
        player.sendMessage("§c uwu itadakimasu bakaaaa");
        addPlayerTeam(player, getCustomTeamByName(itemStack.getItemMeta().getDisplayName()).getCustomTeamUnit());
    }
}
