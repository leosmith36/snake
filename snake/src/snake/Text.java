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
	
	private IntSupplier textValue;

	public Text(ObjectHandler oh, int x, int y, Color c, String text, Font textFont) {
		super(oh, x, y, 0, 0, c);
		this.text = text;
		this.textFont = textFont;
	}
	
	public Text(ObjectHandler oh, int x, int y, Color c, String text, IntSupplier textValue, Font textFont) {
		super(oh, x, y, 0, 0, c);
		rawText = text;
		this.text = String.format(rawText, textValue.getAsInt());
		this.textValue = textValue;
		this.textFont = textFont;
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
		g.drawString(text, x, y);
	}
	
	public void updateText() {
		text = String.format(rawText, textValue.getAsInt());
	}
}
