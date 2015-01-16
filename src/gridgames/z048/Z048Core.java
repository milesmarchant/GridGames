package gridgames.z048;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import gridgames.AbstractGameCore;
import gridgames.GraphicsCore;
import gridgames.snake.Direction;
import gridgames.snake.SnakeCore;
import gridgames.snake.SnakeGameState;

/**
 * 
 * @author Miles
 *
 */
public class Z048Core extends AbstractGameCore {

	private boolean debug;
	private String score;
	
	/*
	 * hDirection:
	 * +1:  left
	 * -1:  right
	 * 
	 * vDirection:
	 * +1:  up
	 * -1:  down
	 * 
	 * start:
	 * 0:   +
	 * 3:   -
	 */
	private int hDir;
	private int vDir;
	private int start;

	/*
	 * 
	 * @param graphicsInput
	 * @param ms_per_frame
	 * @param world_size_x
	 * @param world_size_y
	 */
	public Z048Core(GraphicsCore graphicsInput, int ms_per_frame, int world_size_x, int world_size_y) {
		super(graphicsInput, ms_per_frame, world_size_x, world_size_y);
	}
	/**
	 * 
	 */
	@Override
	public void init() {
		
		world = new Z048World(WORLD_SIZE_X, WORLD_SIZE_Y);
		
		world.set(1, 2, 2);
		
		run();
	}
	/**
	 * 
	 */
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
    
    /**
     * 
     */
	@Override
	protected void processInput() {
		do{
        	inputQueue = graphics.getPressedKeys();
        	System.out.println("Press a button!");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while(inputQueue.isEmpty());
		
        for(Integer I: inputQueue){
    		switch(I){
    			case KeyEvent.VK_UP:
    				vDir=1;
    				hDir=0;
    				start=0;
    				break;
    			case KeyEvent.VK_RIGHT:
    				hDir=-1;
    				vDir=0;
    				start=3;
    				break;
    			case KeyEvent.VK_DOWN:
    				vDir=-1;
    				hDir=0;
    				start=3;
    				break;
    			case KeyEvent.VK_LEFT:
    				hDir=1;
    				vDir=0;
    				start=0;
    				break;
    			case KeyEvent.VK_P:
    				
    				break;
    		}
    	}
        
        
    	inputQueue.clear();
	}
	
	/**
	 * 
	 */
	@Override
	protected void update() {
		
		//value of block to be moved
		int target;
		
		world.set(3, 0, 8);
		
		
		//iterate horizontally to the right
		for(int i = 0; i < 4; i++){
			//iterate vertically to the bottom
			for(int j = 0; j < 4; j++){
				//iterate outward to check for non zero tiles
				for(int k = 1; k < 4; k++){
					try{
						//get the looked at block
						target = world.get(k*hDir, k*vDir);
						//if it's not empty
						if(target != 0){
							//if it's the same add them
							if(target == world.get(i, j)){
								world.set(i, j, target*2);
							} else{
								//else set the adjacent block to the target value (move the target)
								world.set(i+hDir, j+vDir, target);
							}
							//clear the old target since it got moved
							world.set(k*hDir, k*vDir, 0);
						}
					}catch(ArrayIndexOutOfBoundsException e){
						
					}
				}
			}
		}
		
		
		System.out.println("\n\n");
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(world.get(i, j) + "  ");
			}
			System.out.print("\n");
		}
		
		
	}

	/**
	 * 
	 */
	@Override
	protected void render() {
		
	}
	
	
	
	
	
	
	
	
	

}
