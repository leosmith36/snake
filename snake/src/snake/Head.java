package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Head extends GameObject {
	
	public static int speed = 4;
	public static int size = 30;

	public Head(ObjectHandler oh, Color c) {
		super(oh, Game.WIDTH / 2, Game.HEIGHT / 2, Head.size, Head.size, c, "head_right.png");
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
					oh.makeEndScreen();
					this.remove();
					return;
				}
			}
		}
		
		if ((x < 0) || (x > Game.WIDTH - w - 20) || (y < 0) || (y > Game.HEIGHT - h - 30)) {
			oh.makeEndScreen();
			this.remove();
		}
		
		changeImage();
		
	}
	
	public void changeImage() {
		int velX = oh.getHeadX();
		int velY = oh.getHeadY();
		if (velX > 0) {
			image = "head_right.png";
		}else if (velX < 0) {
			image = "head_left.png";
		}
		if (velY > 0) {
			image = "head_down.png";
		}else if (velY < 0) {
			image = "head_up.png";
		}
	}

}
