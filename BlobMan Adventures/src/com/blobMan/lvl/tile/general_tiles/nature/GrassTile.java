package com.blobMan.lvl.tile.general_tiles.nature;

import com.blobMan.lvl.tile.Tile;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}

	// Renders the tile here
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
