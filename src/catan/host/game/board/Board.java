package catan.host.game.board;

import java.util.ArrayList;
import java.util.Random;

import catan.host.game.Resource;
import catan.host.game.board.tile.DesertTile;
import catan.host.game.board.tile.ResourceTile;
import catan.host.game.board.tile.Tile;
import catan.host.game.board.tile.numbertokenassigner.NumberTokenAssigner;

public class Board {
    
    private Tile[][] tiles;

    public Board(int[][] tilePattern, int[] numberTokens, NumberTokenAssigner numberTokenAssigner) {
        tiles = new Tile[tilePattern.length][tilePattern[0].length];
        ArrayList<Resource> resources = new ArrayList<>();
        addResources(resources, Resource.STONE, 3);
        addResources(resources, Resource.BRICK, 3);
        addResources(resources, Resource.WHEAT, 4);
        addResources(resources, Resource.LOGS, 4);
        addResources(resources, Resource.SHEEP, 4);
        addResources(resources, Resource.DESERT, 1);
        Random random = new Random();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[0].length; j++) {
                if(tilePattern[i][j] == 1) {
                    Resource resource = resources.remove(random.nextInt() % resources.size());
                    if(resource == Resource.DESERT) {
                        tiles[i][j] = new DesertTile();
                    }
                    else{
                        tiles[i][j] = new ResourceTile(resource);
                    }
                }
                else {
                    tiles[i][j] = null;
                }
            }
        }
        numberTokenAssigner.assignNumberTokens(tiles, numberTokens);
    }

    private void addResources(ArrayList<Resource> resources, Resource resource, int count) {
        for( int i = 0; i < count; i++ ) {
            resources.add(resource);
        }
    }
}

