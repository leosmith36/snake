package snake;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class Segment extends GameObject {
	
	private int number;
	
	public static int size = Head.size;

	public Segment(ObjectHandler oh, int number) {
		super(oh, 0, 0, Segment.size, Segment.size, Segment.getCorrespondingColor(number));
		this.number = number;
		setCenter(oh.getSnakePositions().get(number));
		
	}

	@Override
	public void tick() {
		LinkedList<Point> positions = oh.getSnakePositions();
		setCenter(positions.get(number));
	}
	
	public int getNumber() {
		return number;
	}
	
	public static Color getCorrespondingColor(int number) {
		if (number % 25 == 0) {
			return Color.yellow;
		}else if (number % 5 == 0){
			return Color.green;
		}else {
			return Color.blue;
		}
	}

}
