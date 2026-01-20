package luis.josh.catan.host.game.actions;

import org.json.simple.JSONObject;

// By default, JSONObject returned will be sent to all players

public interface Action {
     
    public JSONObject execute(JSONObject data);

}
