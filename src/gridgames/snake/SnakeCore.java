/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames.snake;



import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Point;

import static gridgames.snake.Direction.*;

import gridgames.ActorList;
import gridgames.ActorType;
import gridgames.StateList;
import gridgames.StateType;


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
    
    
    
    /**
     * 
     * @param ms_per_frame is the number of milliseconds each frame or tick of the game occurs in. This is enforced by the main game loop
     * @param world_size   is the integer size of the game
     */
    public SnakeCore(int ms_per_frame, int world_size_x, int world_size_y){
        super(ms_per_frame, world_size_x, world_size_y);
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
        
        run();
    }
    
    @Override
    protected void run(){
        
        long start;
        
        
        while (true){
            
            start = System.currentTimeMillis();
            
            processInput();
            update();
            render();

            try {
                Thread.sleep(start + MS_PER_FRAME - System.currentTimeMillis());
            } catch (InterruptedException ex) {
                Logger.getLogger(SnakeCore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    @Override
    protected void processInput(){
        
    }
    
    @Override
    protected void update(){
        
        head = snake.getLast();
        
        if(world.get(head.x, head.y)==1){
            genFood();
            score++;
        } else{
            snake.removeLast();
        }
        
        
        switch (dir){
            case up:
                if(isLegalPoint(head.x, head.y+1)){
                    snake.add(new Point(head.x, head.y+1));
                }
            case right:
                if(isLegalPoint(head.x+1, head.y)){
                    snake.add(new Point(head.x+1, head.y));
                }
            case down:
                if(isLegalPoint(head.x, head.y-1)){
                    snake.add(new Point(head.x, head.y-1));
                }
            case left:
                if(isLegalPoint(head.x-1, head.y)){
                    snake.add(new Point(head.x-1, head.y));
                }
        }
        
    }
    
    @Override
    protected void render(){
        
    }
    
    protected boolean isLegalPoint(int x, int y){
        if(x<0 || x>WORLD_SIZE_X || y<0 || y>WORLD_SIZE_Y){
            return false;
        }
        else return true;
    }
    
    protected void genFood(){
        Point newFood = new Point(rand.nextInt(WORLD_SIZE_X + 1), rand.nextInt(WORLD_SIZE_Y + 1));
        if(!snake.contains(newFood)){
            world.set(newFood.x, newFood.y, 1);
        }
    }
    
}
