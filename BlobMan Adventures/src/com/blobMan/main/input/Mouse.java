package com.blobMan.main.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;

	public static int getX() {
		return mouseX;
	}

	public static int getY() {
		return mouseY;
	}

	public static int getButton() {
		return mouseB;
	}

	@Override
	public void mouseDragged(MouseEvent m) {
		mouseX = m.getX();
		mouseY = m.getY();
	}

	@Override
	public void mouseMoved(MouseEvent m) {
		mouseX = m.getX();
		mouseY = m.getY();
	}

	@Override
	public void mouseClicked(MouseEvent m) {
	}

	@Override
	public void mouseEntered(MouseEvent m) {
	}

	@Override
	public void mouseExited(MouseEvent m) {
	}

	@Override
	public void mousePressed(MouseEvent m) {
		mouseB = m.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		mouseB = -1;
	}

}
