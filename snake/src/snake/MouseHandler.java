package snake;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener {

	private ObjectHandler oh;
	
	public MouseHandler(ObjectHandler oh) {
		this.oh = oh;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point mouseLocation = e.getPoint();
		oh.setMouseLocation(mouseLocation);
		
	}

}
