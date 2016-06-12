package com.blobMan.lvl.tile;

import com.blobMan.lvl.tile.flowers.BlueFlowerTile;
import com.blobMan.lvl.tile.flowers.YellowFlowerTile;
import com.blobMan.lvl.tile.general_tiles.DirtTile;
import com.blobMan.lvl.tile.general_tiles.GrassTile;
import com.blobMan.lvl.tile.general_tiles.RockTile;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile yellowFlower = new YellowFlowerTile(Sprite.yellowFlower);
	public static Tile blueFlower = new BlueFlowerTile(Sprite.blueFlower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile dirt = new DirtTile(Sprite.dirt);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public Tile(Sprite sprite) { 
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean isSolid() {
		return false;
	}

}
