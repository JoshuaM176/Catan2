package luis.josh.catan.client.game.board.tile;

import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.lang.Math;
import java.awt.Rectangle;

import luis.josh.catan.client.game.util.Coordinate;

public class Vertex {

    public VertexPlaceable placedItem = null;
    public Harbor harbor = null;
    public JButton button;
    public Coordinate tilePos;
    public int pos;

    public Vertex(Coordinate tilePos, int pos, Consumer<Vertex> onClick, JPanel jPanel) {
        this.pos = pos;
        button = new JButton("TEST");
        button.addActionListener(e -> onClick.accept(this));
        jPanel.add(button);
    }

    public void redraw(int size, Coordinate topLeft) {
        Coordinate coordinate = getCoordinate((int)(size * 1.5));
        coordinate = coordinate.add(topLeft);
        button.setBounds(getButtonBounds(coordinate, size));
    }

    private Rectangle getButtonBounds(Coordinate pos, int size) {
        size = size/5;
        return new Rectangle(
            pos.x - size/2,
            pos.y - size/2,
            size,
            size
        );
    }

    private Coordinate getCoordinate(int size) {
        if(pos == 0) {
            return new Coordinate(
                size / 2,
                0
            );
        }
        if(pos == 3) {
            return new Coordinate(
                size / 2,
                size
            );
        }
        double sideLength = size / 2 / Math.sin(Math.toRadians(60));
        int trim = (int)(size - sideLength / 2);
        switch(pos) {
            case 1: {
                return new Coordinate(
                    size,
                    trim
                );
            }
            case 2: {
                return new Coordinate(
                    size,
                    size - trim
                );
            }
            case 4: {
                return new Coordinate(
                    0,
                    size - trim
                );
            }
            case 5: {
                return new Coordinate(
                    0,
                    trim
                );
            }
        }
        return null;
    }

}
