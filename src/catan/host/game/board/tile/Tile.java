package catan.host.game.board.tile;

import catan.host.game.Resource;
import catan.host.game.board.Vertex;

public class Tile{
    
    public Resource resource;
    public Vertex[] vertices = new Vertex[6];

    public Tile(Resource resource) {
        this.resource = resource;
    }

}
