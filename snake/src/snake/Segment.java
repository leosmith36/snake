package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Segment extends GameObject {
	
	private int number;
	private int separation = 6;

	public Segment(ObjectHandler oh, Color c, int number) {
		super(oh, 0, 0, 20, 20, c);
		setCenter(oh.getSnakePositions().get(number * separation));
		this.number = number;
	}

	@Override
	public void tick() {
		LinkedList<Point> positions = oh.getSnakePositions();
		setCenter(positions.get(number * separation));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
