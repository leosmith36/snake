package snake;

import java.awt.Color;
import java.awt.Rectangle;

public class Food extends GameObject {

	public Food(ObjectHandler oh, int x, int y, Color c) {
		super(oh, x, y, 20, 20, c);
		// TODO Auto-generated constructor stub
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
		
	}

}
