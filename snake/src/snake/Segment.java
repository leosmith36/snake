package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Segment extends GameObject {
	
	private int index;

	public Segment(ObjectHandler oh, Color c, int number) {
		super(oh, 0, 0, 25, 25, c);
		index = (number * 8) + 2;
		setCenter(oh.getSnakePositions().get(index));
		
	}

	@Override
	public void tick() {
		LinkedList<Point> positions = oh.getSnakePositions();
		setCenter(positions.get(index));
	}

}
