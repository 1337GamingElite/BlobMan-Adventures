package com.blobMan.main.gfx;

import java.util.Random;

import com.blobMan.entity.mob.Player;
import com.blobMan.lvl.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 128;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOff, yOff;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private Random r = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = r.nextInt(0xffffff);
		}

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xPos, int yPos, Sprite sprite) {
		xPos -= xOff;
		yPos -= yOff;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yPos;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xPos;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xPos, int yPos, Sprite sprite, boolean xFlip, boolean yFlip) {
		xPos -= xOff;
		yPos -= yOff;
		for (int y = 0; y < 32; y++) {
			int ya = y + yPos;
			int ys = y;
			if (yFlip)
				ys = 31- y;
			for (int x = 0; x < 32; x++) {
				int xa = x + xPos;
				int xs = x;
				if (xFlip)
					xs = 31 - x;
				if (xa < -32 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffff00ff)
				pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffst(int xOff, int yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
	}

}
