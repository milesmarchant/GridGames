/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames;

import gridgames.snake.Snake;
import gridgames.snake.SnakeWorld;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author Miles
 */
public class GraphicsCore extends Canvas{
	public static int SCREENWIDTH = 500;
	public static int SCREENHEIGHT = 500;
	
	public static int gridSizeX;
	public static int gridSizeY;
	
	public BufferStrategy strat;
	public Mouse mouse = new Mouse();
	public Keyboard keyboard = new Keyboard();
	
	public void init(){
		setBounds(0, 0, SCREENWIDTH, SCREENHEIGHT);
		setIgnoreRepaint(true);
		setBackground(Color.BLACK);
		
		mouse = new Mouse();
		
		addMouseMotionListener(mouse);
		addMouseListener(mouse);
		addKeyListener(keyboard);
		
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	/**
	 * This is a sample draw method. Copy this for every draw thing you want.
	 */
	public void draw(){
		Graphics2D g = (Graphics2D)strat.getDrawGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		gridSizeX = 100;
		gridSizeY = 100;
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SCREENWIDTH, SCREENHEIGHT);
		//Put draw stuff here
		g.setColor(Color.RED);
		g.fillRect(100, 100, gridSizeX, gridSizeY);
		
		strat.show();
		g.dispose();
	}
	
	/**
	 * SNAKE
	 */
	public void drawSnake(World world, Snake snake){
		Graphics2D g = (Graphics2D)strat.getDrawGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		gridSizeX = 25; //SCREENWIDTH / world.getWorld().length;
		gridSizeY = 25; //SCREENHEIGHT / world.getWorld()[0].length;
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SCREENWIDTH, SCREENHEIGHT);
		//Put draw stuff here
		
		g.setColor(Color.GREEN);
		for(int i = 0; i < world.getWorld().length; i++){
			for(int j = 0; j < world.getWorld()[0].length; j++){
				if(world.get(i, j)==1){
					g.fillRect(i*25, j*25, gridSizeX, gridSizeY);

				}
			}
		}
		g.setColor(Color.BLUE);
		for(Point p: snake.getSnake()){
			g.setColor(Color.BLUE);
			g.fillRect(p.x*25, p.y*25, gridSizeX, gridSizeY);
		}
		
		strat.show();
		g.dispose();
	}
	
	public int getMouseX(){
		return mouse.getX();
	}
	
	public int getMouseY(){
		return mouse.getY();
	}
	
	public int getMouseClickedX(){
		return mouse.getClickX();
	}
	
	public int getMouseClickedY(){
		return mouse.getClickY();
	}
	
	public ArrayList<Integer> getPressedKeys(){
		return keyboard.getPressedKeys();
	}
}
