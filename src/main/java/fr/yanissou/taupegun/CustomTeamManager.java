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
            try {
                createTeam(teamEnum);
            } catch (IllegalArgumentException teamAlreadyRegistered){
                Bukkit.getLogger().warning("Team " + teamEnum.getName() +" was already registered !");
            }
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

    public CustomTeam getCustomTeamByItem(ItemStack itemStack) {
        if (customTeams.isEmpty()){
            throw new RuntimeException("CUSTOM TEAM IS HORNY ON MAIN");
        }

        for (CustomTeam customTeam : customTeams){
            if (customTeam.getCustomTeamUnit().getItem() != null && customTeam.getCustomTeamUnit().getItem().isSimilar(itemStack)){
                return customTeam;
            }
        }
        return null;

        //^^^ marche maintenant/
    }

    public void clickOnBanner(Player player, ItemStack itemStack){
        try {
            player.sendMessage(itemStack.getItemMeta().getDisplayName());
            player.sendMessage("§c uwu itadakimasu bakaaaa");
            addPlayerTeam(player, getCustomTeamByItem(itemStack).getCustomTeamUnit());
            //Le probleme c'est que t'essayais de choper une team avec le nom de ton item sauf que c'était pas les memes
            //FAIT PAS LE GOOFY ASS T
        } catch (IllegalArgumentException cantfindteam){
            //On sait jamais
            player.sendMessage("Can't find selected team");
        }

    }
}
