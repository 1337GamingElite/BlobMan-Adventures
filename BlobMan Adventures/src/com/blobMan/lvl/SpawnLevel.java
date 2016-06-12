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
			img.getRGB(0, 0, w, h, lvlPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("COULDN'T LOAD THE FUCKING LEVEL FILE!!!!!!!!!!");
		}
	}
	
	@Override
	protected void generateLevel() {
		
	}

}
