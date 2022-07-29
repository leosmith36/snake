package snake;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

	private ObjectHandler oh;
	
	public MouseMotionHandler(ObjectHandler oh) {
		this.oh = oh;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		oh.setMousePosition(e.getPoint());
		
	}

}
