/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames;

import java.util.ArrayList;

/**
 *
 * @author Marchant
 * @param <ActorType>
 */
public class ActorList<ActorType>{
    
    ArrayList<ActorType> actors;
    
    public ActorList(){
        actors = new ArrayList<>();
    }
    
    public void add(ActorType a){
        actors.add(a);
    }
    
}
