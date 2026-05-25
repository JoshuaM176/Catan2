package luis.josh.catan.client.game.board.tile;

import java.awt.Rectangle;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

import luis.josh.catan.client.game.util.Coordinate;

public class Edge {

    public EdgePlaceable placedItem = null;
    public JButton button;
    public Coordinate tilePos;
    public int pos;
  
    public Edge(Coordinate tilePos, int pos, Consumer<Edge> onClick, JPanel jPanel) {
        this.tilePos = tilePos;
        this.pos = pos;
        button = new JButton("TEST");
        button.addActionListener(e -> onClick.accept(this));
        jPanel.add(button);
    }

    public void redraw(int size, Coordinate topLeft) {
        Coordinate[] coordinate = getCoordinate(size, pos);
        coordinate[0] = coordinate[0].add(topLeft);
        coordinate[1] = coordinate[1].add(topLeft);
        Coordinate difference = coordinate[1].difference(coordinate[0]);
        if(difference.y < 0) {
            difference.y = Math.abs(difference.y);
            coordinate[0].y = coordinate[1].y;
            coordinate[1].y = coordinate[0].y;
        }
        if(difference.x < 0) {
            difference.x = Math.abs(difference.x);
            coordinate[0].x = coordinate[1].x;
            coordinate[1].x = coordinate[0].x;
        }
        button.setBounds(
            new Rectangle(
                coordinate[0].x,
                coordinate[0].y,
                difference.x,
                difference.y
            )
        );
    }

    private Coordinate[] getCoordinate(int size, int pos) {
        if(pos == 0) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 0).add(new Coordinate(size / 10, size / 10)),
                Vertex.getCoordinate(size,1).add(new Coordinate(-size / 10, -size / 10)),
            };
        }
        if(pos == 1) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 1).add(new Coordinate(-size / 10, size / 10)),
                Vertex.getCoordinate(size, 2).add(new Coordinate(size / 10, -size / 10)),
            };
        }
        if(pos == 2) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 2).add(new Coordinate(-size / 10, size / 10)),
                Vertex.getCoordinate(size, 3).add(new Coordinate(size / 10, -size / 10)),
            };
        }
        if(pos == 3) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 3).add(new Coordinate(-size / 10, -size / 10)),
                Vertex.getCoordinate(size, 4).add(new Coordinate(size / 10, size / 10)),
            };
        }
        if(pos == 4) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 4).add(new Coordinate(-size / 10, -size / 10)),
                Vertex.getCoordinate(size, 5).add(new Coordinate(size / 10, size / 10)),
            };
        }
        if(pos == 5) {
            return new Coordinate[]{
                Vertex.getCoordinate(size, 5).add(new Coordinate(size / 10, -size / 10)),
                Vertex.getCoordinate(size, 0).add(new Coordinate(-size / 10, size / 10)),
            };
        }
        return null;
    }
}
