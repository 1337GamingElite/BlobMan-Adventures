package com.blobMan.entity.projectile;

import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class BlobProjectile extends Projectile {

	public BlobProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
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
	}
	
	public void render(Screen screen) {
		screen.renderProjectile(x, y, this);
	}
	
}
