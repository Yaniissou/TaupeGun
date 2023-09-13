package fr.yanissou.taupegun.scoreboard;

import fr.yanissou.taupegun.GameState;
import fr.yanissou.taupegun.Taupegun;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        objectiveSign.setDisplayName("§cTaupe Gun");
        if (GameState.isState(GameState.WAITING)){
            objectiveSign.setLine(0, "§1");
            objectiveSign.setLine(1, "§7Joueurs: §c" + Bukkit.getOnlinePlayers().size());
            objectiveSign.setLine(2, "§2");
            objectiveSign.updateLines();
        } else if (GameState.isState(GameState.PLAYING)){
            objectiveSign.setLine(0, "§1");
            objectiveSign.setLine(1, "§7Episode §c" + Taupegun.getInstance().getGame().getEpisode());
            if(Bukkit.getOnlinePlayers().size() == 1){
                objectiveSign.setLine(2, "§c" + Bukkit.getOnlinePlayers().size() + " §7joueur");
            }else {
                objectiveSign.setLine(2, "§c" + Bukkit.getOnlinePlayers().size() + " §7joueurs");
            }
            objectiveSign.setLine(3, "§2");
            objectiveSign.setLine(4,"§7Timer: §c" + Taupegun.getInstance().getGame().getTimerRunnable().getFormattedTime());
            objectiveSign.setLine(5,"§3");
            objectiveSign.setLine(6, ip);

            objectiveSign.updateLines();
        }


    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}