package luis.josh.catan.client.game.board.tile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import luis.josh.catan.host.game.board.resources.Resource;

public class Tile{

    public int numberToken;
    public Resource resource;
    public JButton jButton;
    public JLabel jLabel;

    public Tile(Resource resource, int numberToken, int row, int col) {
        int offset = (row % 2 == 0) ? 0 : 1;
        ImageIcon icon = new ImageIcon("C:\\Users\\joshu\\Workarea\\ProjectRepos\\Catan2\\src\\main\\java\\luis\\josh\\catan\\client\\tests\\hexagon.png");
        jLabel = new JLabel(icon);
        jLabel.setBounds(col * 150 + offset * 75, row * 100, 200, 200);
        jButton = new JButton(resource.name());
        jButton.setBounds(col * 150 + offset * 75 + 50, row * 100 + 50, 100, 100);
        
        this.numberToken = numberToken;
        this.resource = resource;
    }
}
