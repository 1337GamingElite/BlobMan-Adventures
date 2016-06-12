package com.blobMan.lvl;

public class TileCoords {

	private int x, y;
	private final int TILE_SIZE = 16;
	
	public TileCoords(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int[] xy() {
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}
	
}
