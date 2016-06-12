package com.blobMan.lvl;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.blobMan.lvl.tile.Tile;

public class SpawnLevel extends Level {

	private int[] tiles;
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	@Override
	protected void loadLevel(String path) {
		try {
			BufferedImage img = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = img.getWidth();
			int h = img.getHeight();
			tiles = new int[w * h];
			img.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("COULDN'T LOAD THE LEVEL FILE!!!!!!!!!!");
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
	@Override
	protected void generateLevel() {

	}

}
