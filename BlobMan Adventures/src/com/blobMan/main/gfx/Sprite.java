package com.blobMan.main.gfx;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	// Sprites
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite yellowFlower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite blueFlower = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite dirt = new Sprite(16, 3, 0, SpriteSheet.tiles);
	
	public static Sprite voidSprite = new Sprite(16, 0x000000);

	public static Sprite player_up = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite player_down_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_1 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
