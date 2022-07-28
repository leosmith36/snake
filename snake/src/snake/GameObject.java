package snake;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y, w, h;
	protected Color c;
	protected ObjectHandler oh;
	
	public GameObject(ObjectHandler oh, int x, int y, int w, int h, Color c) {
		this.oh = oh;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public abstract void tick();
	
	public void render(Graphics g) {
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

}
