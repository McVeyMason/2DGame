package com.mason.platformer.game;

import java.awt.event.KeyEvent;

import com.mason.platformer.game.input.InputProcesser;

/**
 * 
 * @author Mason
 *
 */
public class Game {
	public int time;

	private InputProcesser process;

	/**
	 * Game constructor. Creates an input processor to process the user input.
	 */
	public Game() {
		process = new InputProcesser();
	}

	/**
	 * 
	 * @param key An array of booleans for all the key events. If pressed the
	 *            boolean will be true.
	 */
	public void tick(boolean[] key) {
		time++;
		boolean jump = key[KeyEvent.VK_SPACE];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean up = key[KeyEvent.VK_W];
		boolean down = key[KeyEvent.VK_S];
//		boolean jump = key[KeyEvent.VK_W];
//		boolean jump = key[KeyEvent.VK_W];
//		boolean jump = key[KeyEvent.VK_W];
//		boolean jump = key[KeyEvent.VK_W];
		process.tick(jump, left, right, up, down);
	}
}
