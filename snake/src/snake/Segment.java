package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Segment extends GameObject {
	
	private int number;

	public Segment(ObjectHandler oh, Color c, int number) {
		super(oh, oh.getSnakePositions().get(number * 5).x, oh.getSnakePositions().get(number * 5).y, 20, 20, c);
		this.number = number;
	}

	@Override
	public void tick() {
		LinkedList<Point> positions = oh.getSnakePositions();
		setCenter(positions.get(number * 5));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
