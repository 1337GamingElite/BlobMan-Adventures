package com.blobMan.entity.mob;

import com.blobMan.entity.Entity;
import com.blobMan.main.gfx.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0)
			dir = 1; // Right
		if (xa < 0)
			dir = 3; // Left
		if (ya > 0)
			dir = 2; // Down
		if (ya < 0)
			dir = 0; // Up

		if (!collision()) {
			x += xa;
			y += ya;
		}
	}

	public void tick() {

	}

	private boolean collision() {
		return false;
	}

	public void render() {

	}

}
