package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Segment extends GameObject {
	
	private int number;

	public Segment(ObjectHandler oh, int x, int y, int w, int h, Color c, int number) {
		super(oh, x, y, w, h, c);
		this.setNumber(number);
	}

	@Override
	public void tick() {
		LinkedList<Point> positions = oh.getSnakePositions();
		setCenter(positions.get(number));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
