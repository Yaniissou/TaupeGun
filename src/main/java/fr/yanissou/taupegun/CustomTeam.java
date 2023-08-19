package fr.yanissou.taupegun;

import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CustomTeam {
    private final Team team;
    private final TeamEnum teamEnum;
    private final Set<UUID> users = new HashSet<>();

    public CustomTeam(TeamEnum teamEnum, Scoreboard teamscoreboard) {
        this.teamEnum = teamEnum;
        this.team = teamscoreboard.registerNewTeam(teamEnum.getName());
        this.team.setPrefix(teamEnum.getPrefix());
    }

    public Team getTeam() {
        return team;
    }

    public TeamEnum getCustomTeamUnit() {
        return teamEnum;
    }

    public Set<UUID> getUsers() {
        return users;
    }
}
