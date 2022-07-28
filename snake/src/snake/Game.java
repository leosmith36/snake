package snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	
	private ObjectHandler oh;
	
	public Game() {
		new Window(this);
		oh = new ObjectHandler();
		this.addMouseMotionListener(new MouseHandler(oh));
	}

	public void tick() {
		oh.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
				
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		oh.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime(); // Current time in ns
		double amountOfTicks = 60.0; // Number of ticks per second
		double ns = 1000000000 / amountOfTicks; // Number of ns per tick
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns; // Number of ticks that have passed
			lastTime = now;
			while(delta >= 1) { // If one or more tick has passed, do another tick, then move on
				tick();
				delta --;
			}
			if(running) 
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) { // Determines the number of frames per second
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public static int clamp(int value, int min, int max) {
		if (value > max) {
			return max;
		}else if (value < min) {
			return min;
		}else {
			return value;
		}
	}
	
}