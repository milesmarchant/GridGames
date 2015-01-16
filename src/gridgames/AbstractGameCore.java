/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marchant
 */
public abstract class AbstractGameCore {
	
	protected GraphicsCore graphics;
    
    protected Random rand = new Random();
    
    protected final int MS_PER_FRAME;
    
    protected World world;
    
    protected ArrayList<Integer> inputQueue;
    
    protected final int WORLD_SIZE_X;
    protected final int WORLD_SIZE_Y;
    
    protected ActorList<ActorType> actors = new ActorList<>();
    protected StateList<StateType> states = new StateList<>();
    
    protected AbstractGameCore(GraphicsCore graphicsInput, int ms_per_frame, int world_size_x, int world_size_y){
    	graphics = graphicsInput;
        MS_PER_FRAME = ms_per_frame;
        WORLD_SIZE_X = world_size_x;
        WORLD_SIZE_Y = world_size_y;
    }
    
    public abstract void init();
    
    protected abstract void run();
    
    protected abstract void processInput();
    
    protected abstract void update();
    
    protected abstract void render();
    
}