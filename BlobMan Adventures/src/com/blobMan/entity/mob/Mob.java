package com.blobMan.entity.mob;

import com.blobMan.entity.Entity;
import com.blobMan.main.gfx.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		// Checks movement in both axis
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (xa > 0)
			dir = 1; // Right
		if (xa < 0)
			dir = 3; // Left
		if (ya > 0)
			dir = 2; // Down
		if (ya < 0)
			dir = 0; // Up

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void tick() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		if (level.getTile((x + xa) / 16, (y + ya) / 16).isSolid()) solid = true;
		return solid;
	}

	public void render() {

	}

}
