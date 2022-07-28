package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private LinkedList<Point> snakePositions = new LinkedList<Point>();
	
	private Point mouseLocation = new Point();
	
	private int numberSegments = 0;

	public ObjectHandler() {
		objects.add(new Head(this, Game.WIDTH / 2, Game.HEIGHT / 2, 20, 20, Color.RED));
	}

	public void tick() {
		for (GameObject object : objects) {
			object.tick();
		}
		
	}
	
	public void render(Graphics g) {
		
		for (GameObject object : objects) {
			object.render(g);
		}
		
	}
	
	public void setMouseLocation(Point mouseLocation) {
		this.mouseLocation = mouseLocation;
	}
	
	public Point mousePosition() {
		return mouseLocation;
	}
	
	public void addSnakePosition(Point position) {
		snakePositions.addFirst(position);
	}
	
	public LinkedList<Point> getSnakePositions(){
		return snakePositions;
	}
	
	public void addSegment() {
		numberSegments++;
		objects.add(new Segment(this,0,0,20,20,Color.BLUE,numberSegments));
	}
}
