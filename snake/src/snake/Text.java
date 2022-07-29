package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Consumer;

public class Text extends GameObject{
	
	private String text;
	
	private Consumer<String> command;

	public Text(ObjectHandler oh, int x, int y, int w, int h, Color c, String text, Consumer<String> command) {
		super(oh, x, y, w, h, c);
		this.text = text;
		this.command = command;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		g.setColor(c);
		g.drawString(text, x, y);
	}
	
	public void execute(String value) {
		command.accept(value);
	}

}
