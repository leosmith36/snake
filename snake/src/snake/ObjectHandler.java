package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class ObjectHandler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private LinkedList<GameObject> newObjects = new LinkedList<GameObject>();
	private LinkedList<Point> snakePositions = new LinkedList<Point>();
	
	private int numberSegments = 0;
	private int headX = 0;
	private int headY = 0;
	private int spawnProbability = 1;
	
	private Random random = new Random();

	public ObjectHandler() {
		objects.add(new Head(this, Color.RED));
	}

	public void tick() {
		
		int randomNumber = random.nextInt(100);
		if (randomNumber < spawnProbability) {
			addObject(new Food(
					this,
					random.nextInt(Game.WIDTH),
					random.nextInt(Game.HEIGHT),
					Color.GREEN
					));
		}
		
		objects.addAll(newObjects);
		newObjects.clear();
		
		LinkedList<GameObject> remainingObjects = new LinkedList<GameObject>();
		for (GameObject object : objects) {
			if (!object.isRemoved()) {
				object.tick();
				remainingObjects.add(object);
			}
		}
		objects = remainingObjects;
		
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
		newObjects.add(object);
	}
}
