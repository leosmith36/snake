package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Consumer;

public class Button extends GameObject {
	
	Runnable command;
	String text;
	Color textColor;
	Font textFont;

	public Button(ObjectHandler oh, int x, int y, int w, int h, Color c, Runnable command, String text, Color textColor, Font textFont, boolean center) {
		super(oh, x, y, w, h, c, center);
		this.text = text;
		this.command = command;
		this.textColor = textColor;
		this.textFont = textFont;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics g) {
		Color newC;
		if (isHovering(oh.getMousePosition())) {
			newC = new Color(c.getRed(), c.getGreen(), c.getBlue(), 127);
		}else {
			newC = c;
		}
		super.render(g, newC);
		g.setColor(textColor);
		g.setFont(textFont);
		int stringWidth = g.getFontMetrics().stringWidth(text);
		int stringHeight = g.getFontMetrics().getHeight();
		g.drawString(text, getCenterX() - stringWidth / 2, getCenterY() + stringHeight / 3);
	}

	public void execute() {
		command.run();
	}
	
	public boolean isHovering(Point mousePosition) {
		return getRect().contains(mousePosition);
	}
}
