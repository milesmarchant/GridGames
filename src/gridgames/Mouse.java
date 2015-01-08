package gridgames;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	private int MX = 0;
	private int MY = 0;
	private int MRX = 0;
	private int MRY = 0;
	
	public Mouse(){
		
	}
	
	public void mouseMoved(MouseEvent e){
		MX = e.getX();
		MY = e.getY();
	}

	public void mouseReleased(MouseEvent e){
		MRX = e.getX();
		MRY = e.getY();
	}
	
	public int getX(){
		return MX;
	}
	
	public int getY(){
		return MY;
	}
	
	public int getClickX(){
		MRX = -1;
		return MRX;
	}
	
	public int getClickY(){
		MRY = -1;
		return MRY;
	}
}
