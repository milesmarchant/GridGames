/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames;

import gridgames.snake.SnakeCore;
import gridgames.z048.Z048Core;

import javax.swing.JFrame;

/**
 *
 * @author Marchant
 */
public class GridGames {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		JFrame window = new JFrame("Frame");
		GraphicsCore graph = new GraphicsCore();
		
		window.setBounds(0, 0, graph.SCREENWIDTH, graph.SCREENHEIGHT);
		window.setVisible(true);
		window.add(graph);
		graph.init();
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		SnakeCore snakeCore = new SnakeCore(graph, 1000, 20, 20);
		snakeCore.init();
		*/
		
		Z048Core z048Core = new Z048Core(graph, 1000, 4, 4);
		z048Core.init();
        
    }


    
}
