package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Food extends GameObject {
	
	public static int size = 20;
	
	private long time;

	public Food(ObjectHandler oh, int x, int y, Color c) {
		super(oh, x, y, Food.size, Food.size, c, "apple.png");
		time = System.currentTimeMillis();
	}

	@Override
	public void tick() {
		
		Rectangle foodRect = getRect();
		for (GameObject object : oh.getObjects()) {
			Rectangle headRect = object.getRect();
			if ((object instanceof snake.Head) && (foodRect.intersects(headRect))){
				oh.addSegment();
				remove();
			}
		}
		
		long newTime = System.currentTimeMillis();
		float diff = (newTime - time) / 1000.0f;
		if (diff >= 5) {
			remove();
		}
		
	}

}
