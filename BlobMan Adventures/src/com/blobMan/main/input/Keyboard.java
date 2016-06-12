package com.blobMan.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, control, shift, esc;

	public void tick() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		control = keys[KeyEvent.VK_CONTROL];
		shift = keys[KeyEvent.VK_SHIFT];
		esc = keys[KeyEvent.VK_ESCAPE];
	}

	// Checks when a key is pressed
	@Override
	public void keyPressed(KeyEvent k) {
		keys[k.getKeyCode()] = true;

	}

	// Checks when a key is let go
	@Override
	public void keyReleased(KeyEvent k) {
		keys[k.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent k) {

	}

}
