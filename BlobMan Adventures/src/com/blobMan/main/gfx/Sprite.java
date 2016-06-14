package com.blobMan.main.gfx;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite voidSprite = new Sprite(16, 0, 1, SpriteSheet.sheet1);
	
	// Sprites
	// General Sprites
	
	// Nature
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.sheet1);
	public static Sprite bush = new Sprite(16, 4, 0, SpriteSheet.sheet1);
	public static Sprite dirt = new Sprite(16, 3, 0, SpriteSheet.sheet1);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.sheet1);
	public static Sprite water = new Sprite(16, 4, 1, SpriteSheet.sheet1);

	// Man-Made
	public static Sprite woodFloor = new Sprite(16, 2, 1, SpriteSheet.sheet1);
	public static Sprite stoneWall = new Sprite(16, 3, 1, SpriteSheet.sheet1);
	
	// Flowers
	public static Sprite yellowFlower = new Sprite(16, 1, 0, SpriteSheet.sheet1);
	public static Sprite blueFlower = new Sprite(16, 1, 1, SpriteSheet.sheet1);

	// Player Sprites
	public static Sprite player_up = new Sprite(32, 2, 6, SpriteSheet.sheet1);
	public static Sprite player_down = new Sprite(32, 0, 6, SpriteSheet.sheet1);
	public static Sprite player_side = new Sprite(32, 0, 7, SpriteSheet.sheet1);
	public static Sprite player_up_1 = new Sprite(32, 3, 6, SpriteSheet.sheet1);
	public static Sprite player_down_1 = new Sprite(32, 1, 6, SpriteSheet.sheet1);
	public static Sprite player_side_1 = new Sprite(32, 1, 7, SpriteSheet.sheet1);
	
	// Projectiles
	public static Sprite blob_projectile = new Sprite(16, 8, 14, SpriteSheet.sheet1);
	
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
