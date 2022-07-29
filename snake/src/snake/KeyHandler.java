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
		if (oh.getHeadX() == 0) {
			if (code == KeyEvent.VK_D) {
				oh.setHeadX(Head.speed);
				oh.setHeadY(0);
			}else if (code == KeyEvent.VK_A) {
				oh.setHeadX(-Head.speed);
				oh.setHeadY(0);
			}
		}
		if (oh.getHeadY() == 0) {
			if (code == KeyEvent.VK_S) {
				oh.setHeadX(0);
				oh.setHeadY(Head.speed);
			}else if (code == KeyEvent.VK_W) {
				oh.setHeadX(0);
				oh.setHeadY(-Head.speed);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
