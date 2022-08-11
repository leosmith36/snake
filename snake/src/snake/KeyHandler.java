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
		
		if (code == KeyEvent.VK_D) {
			Head.moveVertical = false;
			Head.speed = 50;
		}else if (code == KeyEvent.VK_A) {
			Head.moveVertical = false;
			Head.speed = -50;
		}else if (code == KeyEvent.VK_W) {
			Head.moveVertical = true;
			Head.speed = -50;
		}else if (code == KeyEvent.VK_S) {
			Head.moveVertical = true;
			Head.speed = 50;
		}
		
		
//		if (oh.getHeadX() == 0) {
//			if (code == KeyEvent.VK_D) {
////				oh.setHeadX(Head.speed);
////				oh.setHeadY(0);
//				oh.snakeIsMoving();
//			}else if (code == KeyEvent.VK_A) {
////				oh.setHeadX(-Head.speed);
////				oh.setHeadY(0);
//				oh.snakeIsMoving();
//			}
//		}
//		if (oh.getHeadY() == 0) {
//			if (code == KeyEvent.VK_S) {
//				oh.setHeadX(0);
//				oh.setHeadY(Head.speed);
//				oh.snakeIsMoving();
//			}else if (code == KeyEvent.VK_W) {
//				oh.setHeadX(0);
//				oh.setHeadY(-Head.speed);
//				oh.snakeIsMoving();
//			}
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
