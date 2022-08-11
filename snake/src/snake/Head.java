package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Head extends GameObject {
	
	public static final int speed = 50;
	public static final int size = 30;
	
	public static int moveTime = 300;
	
	private Move currentDirection = Move.RIGHT;
	
	private long time;
				
	public Head(ObjectHandler oh, Color c) {
		super(oh, Game.SIZE / 2 - 25, Game.SIZE / 2 - 25, Head.size, Head.size, c, true, "head_right.png");
		time = System.currentTimeMillis();
	}

	@Override
	public void tick() {

		long newTime = System.currentTimeMillis();
		if (newTime - time > moveTime) {
			time = newTime;
			switch (currentDirection) {
			case DOWN:
				y += speed;
				image = "head_down.png";
				break;
			case LEFT:
				x -= speed;
				image = "head_left.png";
				break;
			case RIGHT:
				x += speed;
				image = "head_right.png";
				break;
			case UP:
				y -= speed;
				image = "head_up.png";
				break;
			default:
				break;
			}
			oh.addSnakePosition(getCenter());
		}
		
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
		
		if ((x < 0) || (x > Game.SIZE - w) || (y < 0) || (y > Game.SIZE - h)) {
			oh.makeEndScreen();
			this.remove();
		}
		
	}

	public void setDirection(Move move) {
		currentDirection = move;
	}

	public boolean isMovingVertical() {
		return currentDirection == Move.UP || currentDirection == Move.DOWN;
	}
	
	public boolean isMovingHorizontal() {
		return currentDirection == Move.LEFT || currentDirection == Move.RIGHT;
	}
}
