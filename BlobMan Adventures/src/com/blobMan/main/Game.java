package com.blobMan.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.blobMan.entity.mob.Player;
import com.blobMan.lvl.Level;
import com.blobMan.lvl.TileCoords;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.input.Keyboard;
import com.blobMan.main.input.Mouse;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	// Window Size
	private static int width = 300, height = 225;
	private static int scale = 3;
	private static String title = "BlobMan Adventures - Work In Progress";
	private static ImageIcon icon = new ImageIcon("res/icon.png");

	private Thread gameThread;
	private JFrame window;
	private Keyboard key;
	private Level lvl;
	private Player player;
	private boolean running = false;

	private Screen screen;

	private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		window = new JFrame();

		lvl = Level.spawn;

		key = new Keyboard();
		addKeyListener(key);
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		
		TileCoords playerSpawn = new TileCoords(20, 66);
		player = new Player(playerSpawn.getX(), playerSpawn.getY(), key);
		player.init(lvl);
	}
	
	public static int getWindowWidth() {
		return width * scale;
	}



	public static int getWindowHeight() {
		return height * scale;
	}



	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "BlobMan");
		gameThread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Game Loop
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double NS = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / NS;
			lastTime = now;
			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				window.setTitle(title + " | " + frames + " fps, " + ticks + " ticks");
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void tick() {
		key.tick();
		if (key.esc)
			System.exit(0);
		player.tick();
		lvl.tick();
	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		lvl.render(xScroll, yScroll, screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);

		// Coordinates
		g.setColor(Color.BLACK); 
		g.setFont(new Font("Verdana", 0, 50));
		
/*		g.fillRect(Mouse.getX() - 32, Mouse.getY() - 32, 64, 64);
		g.drawString("Button: " + Mouse.getButton(), 80, 80);*/

		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		Game game = new Game();

		game.window.setResizable(false);
		game.window.setTitle(Game.title);
		game.window.add(game);
		game.window.pack();
		game.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.window.setLocationRelativeTo(null);
		game.window.setIconImage(icon.getImage());
		game.window.setVisible(true);

		game.start();
	}

}
