package snake;

import java.awt.Color;
import java.awt.Point;

public class Head extends GameObject {

	public Head(ObjectHandler oh, int x, int y, int w, int h, Color c) {
		super(oh, x, y, w, h, c);
	}

	@Override
	public void tick() {
		Point newCenter = oh.mousePosition();
//		double vecX = newCenter.x - getX();
//		double vecY = newCenter.y - getY();
//		Vector2d vec = new Vector2d(vecX, vecY);
		oh.addSnakePosition(getCenter());
		setCenter(newCenter);
		
	}

}
