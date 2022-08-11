package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class Text extends GameObject{
	
	private String rawText;
	private String text;
	private Font textFont;
	private boolean center;
	
	private IntSupplier textValue;

	public Text(ObjectHandler oh, int x, int y, Color c, String text, Font textFont, boolean center) {
		super(oh, x, y, 0, 0, c);
		this.text = text;
		this.textFont = textFont;
		this.center = center;
	}
	
	public Text(ObjectHandler oh, int x, int y, Color c, String text, IntSupplier textValue, Font textFont, boolean center) {
		super(oh, x, y, 0, 0, c);
		rawText = text;
		this.text = String.format(rawText, textValue.getAsInt());
		this.textValue = textValue;
		this.textFont = textFont;
		this.center = center;
	}

	@Override
	public void tick() {
		if (textValue != null) {
			updateText();
		}
		
	}

	public void render(Graphics g) {
		g.setColor(c);
		g.setFont(textFont);
		int renderX;
		int renderY;
		if (center) {
			renderX = x - g.getFontMetrics().stringWidth(text) / 2;
			renderY = y - g.getFontMetrics().getHeight() / 3;
		}else {
			renderX = x;
			renderY = y;
		}
		g.drawString(text, renderX, renderY);
	}
	
	public void updateText() {
		if (textValue != null && rawText != null) {
			text = String.format(rawText, textValue.getAsInt());
		}
	}
	
	public void changeText(String text) {
		this.text = text;
	}
}
