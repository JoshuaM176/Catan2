package luis.josh.catan.host.game.actionmanager;

import java.util.Map;

import org.json.simple.JSONObject;

import luis.josh.catan.host.game.player.Player;
import luis.josh.catan.host.game.actions.Action;

public class ActionManager {

    private Player[] players;
    private Map<String, Action> actionMap;

    public ActionManager(Player[] players, Map<String, Action> actionMap) {
        this.players = players;
        this.actionMap = actionMap;
    }

    public JSONObject[] executeAction(JSONObject data) {
        int playerNum = (int)(long)data.get("player");
        Player player = players[playerNum];
        String actionName = (String)data.get("action");
        Action action = actionMap.get(actionName);
        JSONObject actionData = (JSONObject)data.get("data");
        return action.execute(actionData, player);
    }

}
