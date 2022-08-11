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
		if (isHovering(Game.mousePosition)){
			c = new Color(c.getRed(), c.getGreen(), c.getBlue(), 127);
			if (Game.mouseClicked) {
				execute();
				Game.mouseClicked = false;
			}
		}else {
			c = new Color(c.getRed(), c.getGreen(), c.getBlue(), 255);
		}
		
		
	}
	
	public void render(Graphics g) {
		super.render(g, c);
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
