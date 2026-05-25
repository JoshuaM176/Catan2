package luis.josh.catan.host.game;

import java.util.function.Consumer;

import org.json.simple.JSONObject;

import luis.josh.catan.host.game.actionmanager.ActionManager;

public abstract class Game {
    
    private Consumer<JSONObject> messageQueue;
    private ActionManager actionManager;

    public Game(Consumer<JSONObject> messageQueue) {
        this.messageQueue = messageQueue;
    }
 
    public void executeAction(JSONObject data) {
        JSONObject[] results = actionManager.executeAction(data);
        for(JSONObject jsonObject: results) {
            messageQueue.accept(jsonObject);
        }
    }
}
