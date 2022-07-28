package snake;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private String title = "Snake Game";
	
	public Window(Game game) {
		frame = new JFrame(title);
		frame.setMinimumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		frame.setMaximumSize(new Dimension(Game.WIDTH,Game.HEIGHT));
		frame.setPreferredSize(new Dimension(Game.WIDTH,Game.HEIGHT));
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	}
	
}
