package luis.josh.catan.host.game.gamepieces.cards.developmentcards;

import org.json.simple.JSONObject;

import luis.josh.catan.host.game.actions.messages.EventResponses;
import luis.josh.catan.host.game.board.resources.Resource;
import luis.josh.catan.host.game.player.Player;

public class Monopoly extends DevelopmentCard{

  Player[] players;

    public Monopoly(Player[] players) {
        this.players = players;
    }

    @Override
    public JSONObject[] execute(JSONObject data, Player player) {
        Resource resource = Resource.valueOf((String)data.get("resource"));
        for(int i = 0; i < players.length; i++) {
            if(i == player.playerNum()) {
                continue;
            }
            player.addResources(resource, players[i].stealAllResources(resource));
        }
        return new JSONObject[]{EventResponses.usedDevelopmentCard(getName())};
    }

    @Override
    public String getName() {
        return "monopoly";
    }
  
}
