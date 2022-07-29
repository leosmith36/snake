package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Consumer;

public class Button extends GameObject {
	
	Consumer<ObjectHandler> command;
	String text;
	Color textColor;

	public Button(ObjectHandler oh, int x, int y, int w, int h, Color c, Consumer<ObjectHandler> command, String text, Color textColor) {
		super(oh, x, y, w, h, c);
		this.text = text;
		this.command = command;
		this.textColor = textColor;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(textColor);
		int stringWidth = g.getFontMetrics().stringWidth(text);
		g.drawString(text, getCenterX() - stringWidth / 2, getCenterY());
	}

	public void execute() {
		command.accept(oh);
	}
	
	public boolean isHovering(Point mousePosition) {
		return getRect().contains(mousePosition);
	}
}
