package com.blobMan.lvl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.blobMan.lvl.tile.Tile;

public class SpawnLevel extends Level {

	private Tile[] tiles;
	private int[] lvlPixels;
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	@Override
	protected void loadLevel(String path) {
		try {
			BufferedImage img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			tiles = new Tile[w * h];
			img.getRGB(0, 0, w, h, lvlPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("COULDN'T LOAD THE LEVEL FILE!!!!!!!!!!");
		}
	}
	
	/*
	 * Grass = 0x00ff00 (Green)
	 * Blue Flower = 0x00ffff (Light Blue)
	 * Yellow Flower = 0xffff00 (Yellow)
	 * Rock = 0x7a7a7a(Grey)
	 * Dirt = 0xffa800 (Brown / Orange)
	 */
	@Override
	protected void generateLevel() {
		for (int i = 0 ; i < lvlPixels.length; i++) {
			if (lvlPixels[i] == 0x00ff00) tiles[i] = Tile.grass;
			if (lvlPixels[i] == 0x00ffff) tiles[i] = Tile.blueFlower;
			if (lvlPixels[i] == 0xffff00) tiles[i] = Tile.yellowFlower;
			if (lvlPixels[i] == 0x7a7a7a) tiles[i] = Tile.rock;
			if (lvlPixels[i] == 0xffa800) tiles[i] = Tile.dirt;
		}
	}

}
