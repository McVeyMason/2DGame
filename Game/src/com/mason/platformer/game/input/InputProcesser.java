package com.mason.platformer.game.input;

import com.mason.platformer.graphics.Screen;

/**
 * 
 * @author Mason
 *
 */
public class InputProcesser {

	/**
	 * Processes player input.
	 * 
	 * @param jump  If the jump control is pressed.
	 * @param left  If the left control is pressed.
	 * @param right If the right control is pressed.
	 * @param up    If the up control is pressed.
	 * @param down  If the down control is pressed.
	 */
	public void tick(boolean jump, boolean left, boolean right, boolean up, boolean down) {
		if (left && !right) {
			if (Screen.player.contactLeft(5) == false) {
				Screen.player.setXVelocity(-5f);
			} else {
				Screen.player.setXVelocity(-1f);
			}
		}
		if (right && !left) {
			if (Screen.player.contactRight(5) == false) {
				Screen.player.setXVelocity(5f);
			} else {
				Screen.player.setXVelocity(1f);
			}
		}
		if (jump) {
			if (Screen.player.contactDown(1) == true) {
				Screen.player.setYVelocity(-20);
			}
		}
	}

}
