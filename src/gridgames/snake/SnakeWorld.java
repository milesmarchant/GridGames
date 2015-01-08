/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames.snake;

import gridgames.World;

/**
 *
 * @author Marchant
 */
public class SnakeWorld extends World {
    
    //int[][] world;

    public SnakeWorld(int sizeX, int sizeY){
        super(sizeX, sizeY);
    
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                world[i][j] = 0;
            }
        }
    }
    
}
