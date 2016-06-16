package com.blobMan.lvl;

import java.util.ArrayList;
import java.util.List;

import com.blobMan.entity.Entity;
import com.blobMan.entity.projectile.Projectile;
import com.blobMan.lvl.tile.Tile;
import com.blobMan.main.gfx.Screen;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public static Level spawn = new SpawnLevel("/Levels/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).tick();
		}
	}

	private void time() {

	}

	// Projectiles use this collision
	public boolean tileCollision(double x, double y, double xa, double ya, int size) {
		boolean solid = false;
		// Nice C++ joke
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xa) + c % 2 * size / 2 - 4) / 16;
			int yt = (((int) y + (int) ya) + c / 2 * size / 2) / 16;
			if (getTile(xt, yt).isSolid())
				solid = true;
		}
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffst(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_grass)
			return Tile.grass;
		if (tiles[x + y * width] == Tile.col_yellowFlower)
			return Tile.yellowFlower;
		if (tiles[x + y * width] == Tile.col_rock)
			return Tile.rock;
		if (tiles[x + y * width] == Tile.col_dirt)
			return Tile.dirt;
		if (tiles[x + y * width] == Tile.col_blueFlower)
			return Tile.blueFlower;
		if (tiles[x + y * width] == Tile.col_woodFloor)
			return Tile.woodFloor;
		if (tiles[x + y * width] == Tile.col_stoneWall)
			return Tile.stoneWall;
		if (tiles[x + y * width] == Tile.col_bush)
			return Tile.bush;
		if (tiles[x + y * width] == Tile.col_water)
			return Tile.water;
		return Tile.voidTile;
	}

}
