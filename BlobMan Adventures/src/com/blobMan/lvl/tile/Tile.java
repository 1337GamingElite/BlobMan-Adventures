package com.blobMan.lvl.tile;

import com.blobMan.lvl.tile.flowers.BlueFlowerTile;
import com.blobMan.lvl.tile.flowers.YellowFlowerTile;
import com.blobMan.lvl.tile.general_tiles.man_made.StoneWallTile;
import com.blobMan.lvl.tile.general_tiles.man_made.WoodFloorTile;
import com.blobMan.lvl.tile.general_tiles.nature.BushTile;
import com.blobMan.lvl.tile.general_tiles.nature.DirtTile;
import com.blobMan.lvl.tile.general_tiles.nature.GrassTile;
import com.blobMan.lvl.tile.general_tiles.nature.RockTile;
import com.blobMan.lvl.tile.general_tiles.nature.WaterTile;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	// TILES
	// Nature
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile dirt = new DirtTile(Sprite.dirt);
	public static Tile water = new WaterTile(Sprite.water);
	public static Tile bush = new BushTile(Sprite.bush);
	
	// Man-Made
	public static Tile woodFloor = new WoodFloorTile(Sprite.woodFloor);
	public static Tile stoneWall = new StoneWallTile(Sprite.stoneWall);
	
	// Flowers
	public static Tile yellowFlower = new YellowFlowerTile(Sprite.yellowFlower);
	public static Tile blueFlower = new BlueFlowerTile(Sprite.blueFlower);
	
	// COLOURS
	// Nature
	public static final int col_grass = 0xff00ff00; // GREEN
	public static final int col_rock = 0xff7a7a7a; // GREY
	public static final int col_dirt = 0xffffa800; // BROWN / ORANGE
	public static final int col_water = 0xff0000ff; // BLUE
	public static final int col_bush = 0xff009900; // DARK GREEN
	
	// Man-made
	public static final int col_woodFloor = 0xffff00ff; // PURPLE
	public static final int col_stoneWall = 0xff000000; // BLACK
	
	// Flowers
	public static final int col_yellowFlower = 0xffffff00; // YELLOW
	public static final int col_blueFlower = 0xff00ffff; // LIGHT BLUE

	public Tile(Sprite sprite) { 
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean isSolid() {
		return false;
	}

}
