package luis.josh.catan.host.game.actions;

import org.json.simple.JSONObject;

import luis.josh.catan.host.game.board.Board;
import luis.josh.catan.host.game.board.tile.Tile;

public class MoveRobber implements Action {

    Board board;

    public MoveRobber(Board board) {
        this.board = board;
    }

    @Override
    public JSONObject execute(JSONObject data) {
        JSONObject source = (JSONObject)data.get("sourceTile");
        JSONObject target = (JSONObject)data.get("targetTile");
        int sourceX = (int)(long)source.get("x");
        int sourceY = (int)(long)source.get("y");
        int targetX = (int)(long)target.get("x");
        int targetY = (int)(long)target.get("y");

        Tile sourceTile = board.tiles[sourceY][sourceX];
        Tile targetTile = board.tiles[targetY][targetX];
        if(sourceTile.robber == null) {
            return null; //TODO
        }
        if(targetTile.robber != null) {
            return null; //TODO
        }
        targetTile.robber = sourceTile.robber;
        sourceTile.robber = null;
        data.put("event","robberMoved");
        return data;
    }
    
}
