package com.blobMan.lvl.tile.general_tiles.nature;

import com.blobMan.lvl.tile.Tile;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class BushTile extends Tile {

	public BushTile(Sprite sprite) {
		super(sprite);
	}

	// Renders the tile here
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.bush);
	}

	// TODO: Decide if bush should be solid
	@Override
	public boolean isSolid() {
		return true;
	}
	
	public boolean isBreakable() {
		return true;
	}
	
}
