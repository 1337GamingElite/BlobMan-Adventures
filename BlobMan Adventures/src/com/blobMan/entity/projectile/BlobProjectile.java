package com.blobMan.entity.projectile;

import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class BlobProjectile extends Projectile {

	public static final int ROF = 20; // Rate of Fire
	
	public BlobProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 170;
		speed = 4;
		dmg = 20;	// Player has 100 at the start
		sprite = Sprite.blob_projectile;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void tick() {
		if (level.tileCollision(x, y, nx, ny, 14)) {
			remove();
		}
		move();
	}
	
	@Override
	protected void move() {
		if (!level.tileCollision(x, y, nx, ny, 14)) {
		x += nx;
		y += ny;
		}
		if(distance() > range) remove();
	}

	private double distance() {
		double dis = 0;
		dis = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dis;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 8, (int) y - 8, this);
	}

}
