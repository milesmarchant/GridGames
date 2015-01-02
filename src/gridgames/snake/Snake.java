/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames.snake;

import gridgames.ActorType;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author Marchant
 */
public class Snake implements ActorType {
    
    LinkedList<Point> snake = new LinkedList<>();
    
    public Snake(){
        for(int i = 0; i < 6; i++){
            snake.addLast(new Point(i+3, 10));
        }
    }
    
    public boolean contains(Object O){
        return snake.contains(O);
    }
    
    public boolean add(Point p){
        return snake.add(p);
    }
    
    public Point getLast(){
        return snake.getLast();
    }
    
    public Point removeLast(){
        return snake.removeLast();
    }
    
    public void clear(){
        snake.clear();
    }
    
}
