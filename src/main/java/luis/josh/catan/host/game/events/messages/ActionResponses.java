package luis.josh.catan.host.game.events.messages;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ActionResponses {

    public static JSONObject actionResponse(String action, JSONArray players, JSONObject data) {
        JSONObject rtn = new JSONObject(
            Map.of(
                "action", action,
                "players", players,
                "data", data
            )
        );
        return rtn;
    }

}
