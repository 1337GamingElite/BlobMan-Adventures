package com.blobMan.lvl.tile;

import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	// Renders the tile here
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
