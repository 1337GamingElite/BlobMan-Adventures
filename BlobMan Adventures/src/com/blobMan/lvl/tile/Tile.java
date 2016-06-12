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
	
	// General Tiles
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

	public Tile(Sprite sprite) { 
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean isSolid() {
		return false;
	}

}
