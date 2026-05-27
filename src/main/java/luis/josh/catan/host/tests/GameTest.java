package luis.josh.catan.host.tests;

import java.util.Map;
import java.util.function.Consumer;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;

import luis.josh.catan.host.HostLogger;
import luis.josh.catan.host.game.Game;
import luis.josh.catan.host.game.board.Board;

public class GameTest {


    public static void main(String[] args) {
        Logger logger = HostLogger.getLogger(GameTest.class);

        Consumer<JSONObject> messageQueue = (data) -> {
            logger.info("Sent message: {}", data);
        };
        Game testGame = new Game(messageQueue, 2) {

            @Override
            public Board generateBoard() {
                return GenerateTestBoard.generateTestBoard();
            }
        };

        JSONObject action = new JSONObject(
            Map.of(
                "action", "placeSettlement",
                "player", 1,
                "data", new JSONObject(Map.of(
                    "tile", new JSONObject(Map.of(
                        "row", 1,
                        "col", 1,
                        "vertex", 1
                    )),
                    "start", 1
                ))
            )
        );

        testGame.acceptData(action);
        
        action = new JSONObject(
            Map.of(
                "action", "placeRoad",
                "player", 1,
                "data", new JSONObject(Map.of(
                    "tile", new JSONObject(Map.of(
                        "row", 1,
                        "col", 1,
                        "edge", 1
                    )),
                    "start", 1
                ))
            )
        );

        testGame.acceptData(action);

        action = new JSONObject(
            Map.of(
                "action", "placeSettlement",
                "player", 1,
                "data", new JSONObject(Map.of(
                    "tile", new JSONObject(Map.of(
                        "row", 1,
                        "col", 1,
                        "vertex", 3
                    )),
                    "start", 2
                ))
            )
        );
        
        testGame.acceptData(action);
        
        action = new JSONObject(
            Map.of(
                "action", "placeRoad",
                "player", 1,
                "data", new JSONObject(Map.of(
                    "tile", new JSONObject(Map.of(
                        "row", 1,
                        "col", 1,
                        "edge", 2
                    )),
                    "start", 2
                ))
            )
        );

        testGame.acceptData(action);

    }
}
