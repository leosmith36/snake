package snake;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
//	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private String title = "Snake Game";
	
	public Window(Game game) {
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(Game.SIZE, Game.SIZE));
		frame.pack();
		int w = 2 * Game.SIZE - frame.getContentPane().getWidth();
		int h = 2 * Game.SIZE - frame.getContentPane().getHeight();
		frame.setPreferredSize(new Dimension(w, h));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	}
	
}
