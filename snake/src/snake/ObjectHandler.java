package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Random;

public class ObjectHandler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private LinkedList<GameObject> newObjects = new LinkedList<GameObject>();
	private LinkedList<Point> snakePositions = new LinkedList<Point>();
	
	private int numberSegments = 0;

	private long time;
	
	private boolean gameStarted = false;
	private boolean mouseClicked = false;
	
	private Random random = new Random();
	
	private Point mousePosition = new Point();
	
	private Head snakeHead;

	public ObjectHandler() {
		makeStartScreen();
	}

	public void tick() {
		
		addFood();
		
		objects.addAll(newObjects);
		newObjects.clear();
		
		LinkedList<GameObject> deletedObjects = new LinkedList<GameObject>();
		for (GameObject object : objects) {
			if (!object.isRemoved()) {
				object.tick();
			}else {
				deletedObjects.add(object);
			}
			if (Game.mouseClicked && (object instanceof snake.Button)) {
				Button button = (Button) object;
				if (button.isHovering(mousePosition)){
					button.execute();
					Game.mouseClicked = false;
				}
			}
		}
		objects.removeAll(deletedObjects);
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.BLACK);
		for (int i = 50; i < Game.SIZE; i += 50) {
			g.drawLine(i, 0, i, Game.SIZE);
		}
		for (int i = 50; i < Game.SIZE; i += 50) {
			g.drawLine(0, i, Game.SIZE, i);
		}
		
		for (GameObject object : objects) {
			object.render(g);
		}
		
	}
	
	public void addFood() {
		long currentTime = System.currentTimeMillis();
		float diff = (currentTime - time) / 1000.0f;
		if (gameStarted && (diff >= 3)) {
			time = currentTime;
			addObject(new Food(
					this,
					random.nextInt(Game.SIZE / 50) * 50 + 25,
					random.nextInt(Game.SIZE / 50) * 50 + 25,
					new Color(0,0,0,0),
					true
					));
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
		addObject(new Segment(this, numberSegments));
	}
	
	public int getNumberSegments() {
		return numberSegments;
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
		mouseClicked = true;
	}
	
	public void makeGame() {
		clearObjects();
		gameStarted = true;
		snakePositions.clear();
		numberSegments = 0;
		addObject(new Text(this, 10, 30, Color.WHITE, "Current Score: %d", this::getNumberSegments, new Font("arial", Font.PLAIN, 20), false));
		addObject(new Text(this, 10, 60, Color.WHITE, String.format("High Score: %d", getHighScore()), new Font("arial", Font.PLAIN, 20), false));
		snakeHead = new Head(this, Color.RED);
		addObject(snakeHead);
	}
	
	public void makeStartScreen() {
		clearObjects();
		gameStarted = false;
		addObject(new Button(this, Game.SIZE / 2, Game.SIZE / 2, 100, 50, Color.BLUE, this::makeGame, "PLAY", Color.WHITE, new Font("arial", Font.PLAIN, 24), true));
	}
	
	public void makeEndScreen() {
		clearObjects();
		gameStarted = false;
		if (getHighScore() < numberSegments) {
			addObject(new Text(this, Game.SIZE / 2, 100, Color.WHITE, "New high score!", new Font("arial", Font.BOLD, 48), true));
		}
		addObject(new Button(this, Game.SIZE / 2, Game.SIZE / 2, 100, 50, Color.BLUE, this::makeGame, "RETRY", Color.WHITE, new Font("arial", Font.PLAIN, 24), true));
		saveHighScore();
	}
	
	public void saveHighScore() {
		if (getHighScore() < numberSegments) {
			try {
				FileOutputStream fos = new FileOutputStream("highScore.txt", false);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeInt(numberSegments);
				oos.close();
				fos.close();
			}catch(Exception e) {
				return;
			}
		}

	}
	
	public int getHighScore() {
		int highScore;
		try {
			FileInputStream fis = new FileInputStream("highScore.txt");
			ObjectInputStream oos = new ObjectInputStream(fis);
			highScore = oos.readInt();
			oos.close();
			fis.close();
		}catch(Exception e) {
			highScore = 0;
		}
		return highScore;
	}
	
	public Head getSnakeHead() {
		return snakeHead;
	}
}
