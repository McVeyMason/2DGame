package com.mason.platformer.game.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Mason
 *
 */
public class InputHandler implements KeyListener, MouseListener, FocusListener, MouseMotionListener {

	/**
	 * An array of booleans for each keys' state.
	 */
	public boolean[] key = new boolean[68836];

	@Override
	public void mouseDragged(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void focusGained(FocusEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void focusLost(FocusEvent e) {
		for (int i = 0; i < key.length; i++) {
			key[i] = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//nothing to do at the moment
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode > 0 && keyCode < key.length) {
			key[keyCode] = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
/*		for (int i = 0; i < key.length; i++) {
 			key[i] = false;
		}*/
		key[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//nothing to do at the moment
	}

}
