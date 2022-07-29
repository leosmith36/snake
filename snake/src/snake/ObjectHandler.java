package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private LinkedList<GameObject> newObjects = new LinkedList<GameObject>();
	private LinkedList<Point> snakePositions = new LinkedList<Point>();
	
	private int numberSegments = 0;
	private int headX = 0;
	private int headY = 0;

	public ObjectHandler() {
		objects.add(new Head(this, Color.RED));
	}

	public void tick() {
		objects.addAll(newObjects);
		newObjects.clear();
		for (GameObject object : objects) {
			object.tick();
		}
		
	}
	
	public void render(Graphics g) {
		for (GameObject object : objects) {
			object.render(g);
		}
		
	}
	
	public void addSnakePosition(Point position) {
		snakePositions.addFirst(position);
	}
	
	public LinkedList<Point> getSnakePositions(){
		return snakePositions;
	}
	
	public void addSegment() {
		numberSegments++;
		addObject(new Segment(this, Color.BLUE, numberSegments));
	}

	public int getHeadX() {
		return headX;
	}

	public void setHeadX(int headX) {
		this.headX = headX;
	}

	public int getHeadY() {
		return headY;
	}

	public void setHeadY(int headY) {
		this.headY = headY;
	}
	
	public LinkedList<GameObject> getObjects(){
		return objects;
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void clearObjects() {
		objects.clear();
	}
}
