package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Head extends GameObject {

	public Head(ObjectHandler oh, Color c) {
		super(oh, Game.WIDTH / 2, Game.HEIGHT / 2, 20, 20, c);
	}

	@Override
	public void tick() {
		
		x += oh.getHeadX();
		y += oh.getHeadY();
		oh.addSnakePosition(getCenter());
		
		Rectangle headRect = getRect();
		for (GameObject object : oh.getObjects()) {
			Rectangle segRect = object.getRect();
			if ((object instanceof snake.Segment) && (headRect.intersects(segRect))) {
				c = Color.yellow;
			}
		}
		
	}

}
