package com.blobMan.lvl;

import com.blobMan.lvl.tile.Tile;
import com.blobMan.main.gfx.Screen;

public class Level {

	protected int width, height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}
	
	public void tick() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffst(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0)
			return Tile.grass;
		if (tiles[x + y * width] == 1)
			return Tile.yellowFlower;
		if (tiles[x + y * width] == 2)
			return Tile.rock;
		if (tiles[x + y * width] == 3)
			return Tile.dirt;
		if (tiles[x + y * width] == 4)
			return Tile.blueFlower;
		return Tile.voidTile;
	}

}
