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
 * @param <StateType>
 */
public class StateList<StateType>{
    
    ArrayList<StateType> states;
    
    public StateList(){
        states = new ArrayList<>();
    }
            
    public StateType getState(Class<?> c){
        for(StateType s : states){
            if(c.isInstance(s)){
                return s;
            }
        }
        return null;
    }
    
    public void add(StateType s){
        states.add(s);
    }
    
}
