package gridgames;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Keyboard extends KeyAdapter {
	private ArrayList<Integer> pressed = new ArrayList<Integer>();
	
	public Keyboard(){
		
	}
	
	public void keyPressed(KeyEvent e){
		pressed.add(e.getKeyCode());
	}
	/*
	public void keyReleased(KeyEvent e){
		pressed.remove(pressed.indexOf(e.getKeyCode()));
	}
	*/
	public ArrayList<Integer> getPressedKeys(){
		return pressed;
	}
}
