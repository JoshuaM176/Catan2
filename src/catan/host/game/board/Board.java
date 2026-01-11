package catan.host.game.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import catan.host.game.board.resources.Resource;
import catan.host.game.board.tile.DesertTile;
import catan.host.game.board.tile.ResourceTile;
import catan.host.game.board.tile.Tile;
import catan.host.game.board.tile.numbertokenassigner.NumberTokenAssigner;

public class Board {
    
    public Tile[][] tiles;

    public Board(int[][] tilePattern, int[] numberTokens, NumberTokenAssigner numberTokenAssigner, ArrayList<Resource> resources) {
        tiles = new Tile[tilePattern.length][tilePattern[0].length];
        Random random = new Random();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                if(tilePattern[i][j] == 1) {
                    Resource resource = resources.remove(Math.abs(random.nextInt()) % resources.size());
                    if(resource == Resource.DESERT) {
                        tiles[i][j] = new DesertTile();
                    }
                    else{
                        tiles[i][j] = new ResourceTile(resource);
                    }
                    addVertices(tiles[i][j], i, j);
                }
                else {
                    tiles[i][j] = null;
                }
            }
        }
        numberTokenAssigner.assignNumberTokens(tiles, tilePattern, numberTokens);
    }

    private void addVertices(Tile tile, int row, int col) {
        for(int i = 0; i < 6; i++) {
            tile.vertices[i] = new Vertex();
        }
        if(col > 0) {
            Tile tile2 = tiles[row][col-1];
            matchTileVertices(tile, tile2, 4, 5, 2, 1);
        }
        boolean isEven = row % 2 == 0;
        if(isEven && row > 0) {
            if(col > 0) {
                Tile tile2 = tiles[row-1][col-1];
                matchTileVertices(tile, tile2, 0, 5, 2, 3);
            }
            Tile tile2 = tiles[row-1][col];
            matchTileVertices(tile, tile2, 0, 1, 4, 3);
        }
        else if(row > 0) {
            Tile tile2 = tiles[row-1][col];
            matchTileVertices(tile, tile2, 0, 5, 2, 3);
            if(col < tiles.length - 1) {
                tile2 = tiles[row-1][col+1];
                matchTileVertices(tile, tile2, 0, 1, 4, 3);
            }
        }
    }

    private void matchTileVertices(Tile newTile, Tile oldTile, int newV1, int newV2, int oldV1, int oldV2) {
        if(oldTile != null) {
            newTile.vertices[newV1] = oldTile.vertices[oldV1];
            newTile.vertices[newV2] = oldTile.vertices[oldV2];
        }
    }

    public String toString() {
        String string = "";
        for(Tile[] tileArray : tiles) {
            string += Arrays.toString(tileArray) + "\n";
        }
        return string;
    }

    public static void addResources(ArrayList<Resource> resources, Resource resource, int count) {
        for( int i = 0; i < count; i++ ) {
            resources.add(resource);
        }
    }
}

