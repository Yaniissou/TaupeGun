package fr.yanissou.taupegun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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

        User user = instance.getUserManager().getUser(player.getUniqueId());

        if (user.hasTeam()){
            for(CustomTeam ct : customTeams){
                ct.getUsers().remove(user.getUuid());
            }
        }

        instance.getCustomTeamManager().getCustomTeamByName(teamEnum.getName()).getUsers().add(user.getUuid());
        instance.getCustomTeamManager().getCustomTeamByName(teamEnum.getName()).getTeam().addEntry(player.getName());
        user.setCustomTeamUnit(teamEnum);
        player.setDisplayName(teamEnum.getPrefix() + player.getName() + ChatColor.RESET);
        player.setPlayerListName(player.getDisplayName());
        for (Player onlineplayer : Bukkit.getOnlinePlayers()){
            updateTeamForPlayer(onlineplayer.getUniqueId());
        }




        //Hamza's way
/*        getTeam(teamEnum).ifPresent(customTeam -> {
            instance.getUserManager().getOptionalUser(player.getUniqueId()).ifPresent(user2 -> {
                for (CustomTeam ct : customTeams) {
                    ct.getUsers().remove(user2.getUuid());
                }
                customTeam.getTeam().addEntry(player.getName());
                customTeam.getUsers().add(user2.getUuid());
                user2.setCustomTeamUnit(teamEnum);
            });
        });*/

    }


    public void updateTeamForPlayer(UUID playerUUID) {
        // get le le joueur
        Player player = Bukkit.getPlayer(playerUUID);
        TeamEnum team = instance.getUserManager().getUser(playerUUID).getTeam();
        if (player != null) {
            // Actualiser le nom du joueur dans la tablist
            player.setPlayerListName(team.getPrefix() + player.getName());

            // set le scoreboard mis à jour au joueur
            player.setScoreboard(getTeamScoreboard());
        }
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

    /**
     * @author EnjoyFelix
     */
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

    public void clickOnTeamBanner(Player player, ItemStack itemStack){
        try {

            player.setItemInHand(new ItemBuilder(player.getItemInHand()).setData(itemStack.getDurability()).build());
            addPlayerTeam(player, getCustomTeamByItem(itemStack).getCustomTeamUnit());
            player.sendMessage(ChatColor.GRAY + "Vous avez rejoint l'équipe " + itemStack.getItemMeta().getDisplayName());

            //Le probleme c'est que t'essayais de choper une team avec le nom de ton item sauf que c'était pas les memes
            //FAIT PAS LE GOOFY ASS T
        } catch (IllegalArgumentException cantfindteam){
            //On sait jamais
            player.sendMessage("Can't find selected team");
        }

    }

    public Scoreboard getTeamScoreboard() {
        return teamScoreboard;
    }
}
