package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {
	
	protected int x, y, w, h;
	protected Color c;
	protected ObjectHandler oh;
	protected boolean removed = false;
	protected boolean center = false;
	protected String image;
	
	public GameObject(ObjectHandler oh, int x, int y, int w, int h, Color c) {
		this.oh = oh;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	
	public GameObject(ObjectHandler oh, int x, int y, int w, int h, Color c, String image) {
		this.oh = oh;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
		this.image = image;
	}
	
	public GameObject(ObjectHandler oh, int x, int y, int w, int h, Color c, boolean center) {
		this.oh = oh;
		this.w = w;
		this.h = h;
		if (center) {
			setCenterX(x);
			setCenterY(y);
		}else {
			this.x = x;
			this.y = y;
		}
		this.c = c;
		this.center = center;
	}

	public abstract void tick();
	
	public void render(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, w, h);
		if (image != null) {
			Image drawImage = Toolkit.getDefaultToolkit().getImage(image);
			g.drawImage(drawImage, x, y, null);
		}
	}
	
	public void render(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, w, h);

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = Game.clamp(x, 0, Game.WIDTH - w - 20);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = Game.clamp(y, 0, Game.HEIGHT - h - 40);
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public int getCenterX() {
		return x + w / 2;
	}
	
	public int getCenterY() {
		return y + h / 2;
	}
	
	public void setCenterX(int centerX) {
		setX(centerX - w / 2);
	}
	
	public void setCenterY(int centerY) {
		setY(centerY - h / 2);
	}
	
	public void setCenter(Point center) {
		setCenterX(center.x);
		setCenterY(center.y);
	}
	
	public Point getCenter() {
		return new Point(getCenterX(), getCenterY());
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}

}
