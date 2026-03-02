package luis.josh.catan.client.tests;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import luis.josh.catan.client.game.board.Board;

public class CreateBoard {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JSONObject data = (JSONObject)JSONValue.parse(
            """
{
	"board": [
		[
			{
			},
            {
				"resource": "BRICK",
				"numberToken": 1
            },
			{
				"resource": "STONE",
				"numberToken": 2
			}
		],
		[
			{
				"resource": "WHEAT",
				"numberToken": 1
			},
            {
                "resource": "LOGS",
                "numberToken": 1
            },
			{
				"resource": "STONE",
				"numberToken": 2
			}
		]
	]
}               
            """ 
        );
        Board board = new Board(data);
        board.jPanel.setLocation(200, 200);
        frame.add(board.jPanel);
        frame.setVisible(true);
    } 
}
