package luis.josh.catan.host.game.actions.messages;

import java.util.Map;

import org.json.simple.JSONObject;

public class ActionResponses {
    
    public static JSONObject discardHalf() {
        JSONObject data = new JSONObject(
            Map.of(
                "action", "discard",
                "players", "all"
            )
        );
        return data;
    }

    public static JSONObject moveRobber() {
        JSONObject data = new JSONObject(
            Map.of(
                "action", "moveRobber",
                "players", "self"
            )
        );
        return data;
    }
}
