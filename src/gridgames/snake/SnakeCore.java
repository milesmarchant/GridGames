/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames.snake;

import static gridgames.snake.Direction.right;
import gridgames.GraphicsCore;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.event.KeyEvent;


/**
 *
 * @author Marchant
 */
public class SnakeCore extends gridgames.AbstractGameCore {
    
    /**
     * Number Conventions for world:
     * 0: blank
     * 1: food
     */
    
    private Direction dir;
    private Snake snake;
    private Point head;
    private int score;
    private ArrayList<Integer> inputQueue;
    private SnakeGameState gameState;
    
    private boolean debug = true;
    
    /**
     * 
     * @param ms_per_frame is the number of milliseconds each frame or tick of the game occurs in. This is enforced by the main game loop
	 * @param world_size_x
	 * @param world_size_y
     * 
     */
    public SnakeCore(GraphicsCore graphics, int ms_per_frame, int world_size_x, int world_size_y){
        super(graphics, ms_per_frame, world_size_x, world_size_y);
    }
    
    
    /**
     * 
     */
    @Override
    public void init(){
        
        world = new SnakeWorld(WORLD_SIZE_X, WORLD_SIZE_Y);
        
        snake = new Snake();
        actors.add(snake);
        
        dir = right;
        states.add(dir);
        
        genFood();
        
        run();
    }
    
    @Override
    protected void run(){
        
        long start;
        long time;
        
        while (true){
            
            start = System.currentTimeMillis();
            
            processInput();
            update();
            render();
            
            if(debug){
            	System.out.println("The score is: " + score);
            }
            time = start + MS_PER_FRAME - System.currentTimeMillis();
            if(time>0){
	            try {
	                Thread.sleep(time);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(SnakeCore.class.getName()).log(Level.SEVERE, null, ex);
	            }
            }
        }
        
    }
    
    @Override
    protected void processInput(){
        inputQueue = graphics.getPressedKeys();
    	
    	for(Integer I: inputQueue){
    		switch(I){
    			case KeyEvent.VK_UP:
    				if(dir != Direction.down){
    					dir = Direction.up;
    				}
    				break;
    			case KeyEvent.VK_RIGHT:
    				if(dir != Direction.left){
    					dir = Direction.right;
    				}
    				break;
    			case KeyEvent.VK_DOWN:
    				if(dir != Direction.up){
    					dir = Direction.down;
    				}
    				break;
    			case KeyEvent.VK_LEFT:
    				if(dir != Direction.right){
    					dir = Direction.left;
    				}
    				break;
    			case KeyEvent.VK_P:
    				if(gameState == SnakeGameState.running){
    					gameState = SnakeGameState.paused;
    				} else if (gameState == SnakeGameState.paused){
    					gameState = SnakeGameState.running;
    				}
    		}
    	}
    	inputQueue.clear();
    	
    }
    
    @Override
    protected void update(){
        
        head = snake.getLast();

        
        
        switch (dir){
            case up:
               snake.add(new Point(head.x, head.y-1));
               System.out.println("Went up");
               break;
            case right:
               snake.add(new Point(head.x+1, head.y));
               System.out.println("Went right");
               break;
            case down:
                snake.add(new Point(head.x, head.y+1));
                System.out.println("Went down");
                break;
            case left:
                snake.add(new Point(head.x-1, head.y));
                System.out.println("Went left");
                break;
        }		
		
		if(debug){
			System.out.println("Head moved to:\nX: " + head.x + "\nY: " + head.y);
		}
        
        head = snake.getLast();
        
        if(isLegalPoint(head.x, head.y)){
        	for(Point p: snake.getSnake()){
        		if(head.x == p.x || head.y == p.y){
        			gameOver();
        		}
        	}
        }
		
		if(world.get(head.x, head.y)==1){
			world.set(head.x,  head.y, 0);
            genFood();
            score++;
        } else{
            snake.removeFirst();
        }
        
    }
    
    private void gameOver() {
		// TODO Auto-generated method stub
		
	}


	@Override
    protected void render(){
        graphics.drawSnake(world, snake);
    }
    
    protected boolean isLegalPoint(int x, int y){
        if(x<0 || x>WORLD_SIZE_X || y<0 || y>WORLD_SIZE_Y){
            return false;
        }
        for(Point p: snake.getSnake()){
        	if(p.x == x && p.y == y){
        		gameState = SnakeGameState.lost;
        	}
        }
        return true;
    }
    
    protected void genFood(){
		Point newFood;
		do{
			newFood = new Point(rand.nextInt(WORLD_SIZE_X + 1), rand.nextInt(WORLD_SIZE_Y + 1));			
		} while (snake.contains(newFood));
		world.set(newFood.x, newFood.y, 1);

		if(debug){
			System.out.println("New food generated at:\nX: " + newFood.x + "\nY: " + newFood.y);
		}
		
    }
    
}
