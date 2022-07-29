package snake;

import java.awt.Color;
import java.awt.Font;
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
	private int spawnProbability = 100; // This means 1 out of every spawnProbability frames, there will spawn a food
	
	private boolean gameStarted = false;
	
	private Random random = new Random();
	
	private Point mousePosition;

	public ObjectHandler() {
		makeStartScreen();
	}

	public void tick() {
		if (gameStarted) {
			int randomNumber = random.nextInt(spawnProbability);
			if (randomNumber == 1) {
				addObject(new Food(
						this,
						random.nextInt(Game.WIDTH),
						random.nextInt(Game.HEIGHT),
						Color.GREEN
						));
			}
		}

		
		objects.addAll(newObjects);
		newObjects.clear();
		
		LinkedList<GameObject> deletedObjects = new LinkedList<GameObject>();
		for (GameObject object : objects) {
			if (!object.isRemoved()) {
				object.tick();
			}else {
				deletedObjects.add(object);
			}
		}
		objects.removeAll(deletedObjects);
		
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
	
	public int getNumberSegments() {
		return numberSegments;
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
	
	public void clearObjects() {
		for (GameObject object : objects) {
			object.remove();
		}
		newObjects.clear();
	}

	public Point getMousePosition() {
		return mousePosition;
	}

	public void setMousePosition(Point mousePosition) {
		this.mousePosition = mousePosition;
	}
	
	public void mouseClick() {
		for (GameObject object : objects) {
			if (object instanceof snake.Button) {
				Button button = (Button) object;
				if (button.isHovering(mousePosition)) {
					button.execute();
				}
			}
		}
	}
	
	public void makeGame() {
		clearObjects();
		gameStarted = true;
		snakePositions.clear();
		numberSegments = 0;
		setHeadX(0);
		setHeadY(0);
		addObject(new Head(this, Color.RED));
		addObject(new Text(this, 10, 30, Color.WHITE, "Score: %d", this::getNumberSegments, new Font("arial", Font.PLAIN, 24)));
	}
	
	public void makeStartScreen() {
		clearObjects();
		gameStarted = false;
		addObject(new Button(this, Game.WIDTH / 2 - 50, Game.HEIGHT / 2 - 25, 100, 50, Color.BLUE, this::makeGame, "PLAY", Color.WHITE, new Font("arial", Font.PLAIN, 24)));
	}
}
