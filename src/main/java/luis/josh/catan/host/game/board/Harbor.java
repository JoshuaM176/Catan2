package luis.josh.catan.host.game.board;

import luis.josh.catan.host.game.board.resources.Resource;

public class Harbor {

    public Resource resource;

    public Harbor(Resource resource) {
        this.resource = resource;
    }

    public String toString() {
        return "Harbor :: " + resource.name();
    }

}
