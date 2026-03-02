package luis.josh.catan.client.game.board;

import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import luis.josh.catan.client.game.board.tile.Tile;
import luis.josh.catan.host.game.board.resources.Resource;

public class Board {

    Tile[][] tiles;
    public JPanel jPanel;
    
    public Board(JSONObject data) {
        jPanel = new JPanel();
        jPanel.setLayout(null);
        JSONArray tileMatrix = (JSONArray)data.get("board");
        int nrows = tileMatrix.size();
        int ncols = ((JSONArray)tileMatrix.get(0)).size();
        jPanel.setSize(150 * ncols + 125, 100 * nrows + 100);
        tiles = new Tile[nrows][ncols];
        for(int row = 0; row < nrows; row++) {
            JSONArray rowArray = (JSONArray)tileMatrix.get(row);
            for(int col = 0; col < ncols; col++) {
                JSONObject tileData = (JSONObject)rowArray.get(col);
                if(tileData.get("resource") == null) {
                    tiles[row][col] = null;
                }
                else{
                    Tile tile = new Tile(
                        Resource.valueOf((String)tileData.get("resource")),
                        (int)(long)tileData.get("numberToken"),
                        row,
                        col
                    );
                    tiles[row][col] = tile;
                    jPanel.add(tile.jLabel);
                    jPanel.add(tile.jButton);
                }
            }
        }
    }
}
