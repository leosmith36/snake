package snake;

import java.awt.Color;

public class Head extends GameObject {

	public Head(ObjectHandler oh, int x, int y, int w, int h, Color c) {
		super(oh, x, y, w, h, c);
	}

	@Override
	public void tick() {
		setCenterX(oh.mouseX());
		setCenterY(oh.mouseY());
	}

}
