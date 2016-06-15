package com.blobMan.entity.projectile;

import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class BlobProjectile extends Projectile {

	public BlobProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 100;
		speed = 5;
		dmg = 20;
		rof = 15;
		sprite = Sprite.blob_projectile;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void tick() {
		move();
	}

	@Override
	protected void move() {
		x += nx;
		y += ny;
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
