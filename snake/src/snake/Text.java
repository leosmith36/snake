package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.function.Consumer;

public class Text extends GameObject{
	
	private String text;
	private Font textFont;
	
	private Consumer<ObjectHandler> update;

	public Text(ObjectHandler oh, int x, int y, Color c, String text, Font textFont) {
		super(oh, x, y, 0, 0, c);
		this.text = text;
		this.textFont = textFont;
	}
	
	public Text(ObjectHandler oh, int x, int y, Color c, String text, Consumer<ObjectHandler> update, Font textFont) {
		super(oh, x, y, 0, 0, c);
		this.text = text;
		this.update = update;
		this.textFont = textFont;
	}

	@Override
	public void tick() {
		if (update != null) {
			updateText();
		}
		
	}

	public void render(Graphics g) {
		g.setColor(c);
		g.setFont(textFont);
		g.drawString(text, x, y);
	}
	
	public void updateText() {
		update.accept(oh);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
