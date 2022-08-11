package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	private ObjectHandler oh;

	public KeyHandler(ObjectHandler oh) {
		this.oh = oh;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		Head head = oh.getSnakeHead();
		if (code == KeyEvent.VK_D && !head.isMovingHorizontal()) {
			head.setDirection(Move.RIGHT);
		}else if (code == KeyEvent.VK_A && !head.isMovingHorizontal()) {
			head.setDirection(Move.LEFT);
		}else if (code == KeyEvent.VK_W && !head.isMovingVertical()) {
			head.setDirection(Move.UP);
		}else if (code == KeyEvent.VK_S && !head.isMovingVertical()) {
			head.setDirection(Move.DOWN);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
