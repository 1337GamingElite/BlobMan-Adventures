package com.blobMan.lvl;

import com.blobMan.lvl.tile.Tile;
import com.blobMan.main.gfx.Screen;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
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

	/*
	 * TILE -> COLOUR
	 * Grass = 0xff00ff00 (Green)
	 * Blue Flower = 0xff00ffff (Light Blue)
	 * Yellow Flower = 0xffffff00 (Yellow)
	 * Rock = 0xff7a7a7a(Grey)
	 * Dirt = 0xffffa800 (Brown / Orange)
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0xff00ff00)
			return Tile.grass;
		if (tiles[x + y * width] == 0xffffff00)
			return Tile.yellowFlower;
		if (tiles[x + y * width] == 0xff7a7a7a)
			return Tile.rock;
		if (tiles[x + y * width] == 0xffffa800)
			return Tile.dirt;
		if (tiles[x + y * width] == 0xff00ffff)
			return Tile.blueFlower;
		return Tile.voidTile;
	}

}
