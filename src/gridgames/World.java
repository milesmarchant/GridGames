/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames;

/**
 *
 * @author Marchant
 */
public class World {
    
    int[][] world;
    
    public World(int sizeX, int sizeY){
        world = new int[sizeX][sizeY];
    }
    
    public void set(int x, int y, int val){
        world[x][y] = val;
    }
    
    public int get(int x, int y){
        return world[x][y];
    }
    
}
