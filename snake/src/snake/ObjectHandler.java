package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class ObjectHandler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	private Point mouseLocation = new Point();

	public ObjectHandler() {
		objects.add(new Head(this, 100, 100, 100, 100, Color.RED));
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
	
	public int mouseX() {
		return mouseLocation.x;
	}
	
	public int mouseY() {
		return mouseLocation.y;
	}
	
}
