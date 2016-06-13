package com.blobMan.entity;

import java.util.Random;

import com.blobMan.lvl.Level;
import com.blobMan.main.gfx.Screen;

public abstract class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random r = new Random();
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		// Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
}
