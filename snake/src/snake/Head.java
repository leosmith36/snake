package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Head extends GameObject {
	
	public static int speed = 50;
	public static final int size = 30;
	public static boolean moveVertical = false;
	
	private long time;
			
	public Head(ObjectHandler oh, Color c) {
		super(oh, Game.WIDTH / 2 - 25, Game.HEIGHT / 2 - 25, Head.size, Head.size, c, true, "head_right.png");
		time = System.currentTimeMillis();
	}

	@Override
	public void tick() {
		
		long newTime = System.currentTimeMillis();
		if (newTime - time >= 1000) {
			time = newTime;
			if (moveVertical) {
				y += speed;
			}else {
				x += speed;
			}
		}
		
		
//		x += oh.getHeadX();
//		y += oh.getHeadY();
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
		
		if ((x < 0) || (x > Game.WIDTH - w) || (y < 0) || (y > Game.HEIGHT - h)) {
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
