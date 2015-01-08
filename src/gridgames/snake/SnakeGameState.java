/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridgames.snake;

import gridgames.StateType;

/**
 *
 * @author Miles
 */
public enum SnakeGameState implements StateType {
	running,
	paused,
	lost;
}
