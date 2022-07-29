package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Head extends GameObject {
	
	public static int speed = 4;

	public Head(ObjectHandler oh, Color c) {
		super(oh, Game.WIDTH / 2, Game.HEIGHT / 2, 30, 30, c);
	}

	@Override
	public void tick() {
		
		x += oh.getHeadX();
		y += oh.getHeadY();
		oh.addSnakePosition(getCenter());
		
		Rectangle headRect = getRect();
		for (GameObject object : oh.getObjects()) {
			if (object instanceof snake.Segment) {
				Segment seg = (Segment) object;
				Rectangle segRect = seg.getRect();
				if ((headRect.intersects(segRect)) && (seg.getNumber() != 1)) {
					oh.makeStartScreen();
				}
			}
		}
		
		if ((x < 0) || (x > Game.WIDTH - w) || (y < 0) || (y > Game.HEIGHT - h)) {
			oh.makeStartScreen();
		}
		
	}

}
