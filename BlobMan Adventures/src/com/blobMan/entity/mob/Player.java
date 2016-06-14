package com.blobMan.entity.mob;

import com.blobMan.main.Game;
import com.blobMan.main.gfx.Screen;
import com.blobMan.main.gfx.Sprite;
import com.blobMan.main.input.Keyboard;
import com.blobMan.main.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	// Player spawns at the default location
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_down;
	}

	// Creates Player at a Set Location
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down;
	}

	public void tick() {
		int xa = 0, ya = 0;
		if (anim < 6969)
			anim++;
		else
			anim = 0;
		anim++;
		int moveSpeed = 2;

		if (input.control && !input.shift)
			moveSpeed /= 2;
		if (input.shift && !input.control)
			moveSpeed *= 1.9;

		if (input.up)
			ya -= moveSpeed;
		if (input.down)
			ya += moveSpeed;
		if (input.left)
			xa -= moveSpeed;
		if (input.right)
			xa += moveSpeed;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		tickShooting();
	}
	
	private void tickShooting() {

		if (Mouse.getButton() == 1) {
			double dx  = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		boolean yFlipped = false;
		boolean xFlipped = false;

		if (dir == 0) {
			sprite = Sprite.player_up;
			if (walking) {
				if (anim % 50 > 25) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_side;
			xFlipped = true;
			if (walking) {
				if (anim % 50 > 25) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_down;
			if (walking) {
				if (anim % 50 > 25) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 50 > 25) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, xFlipped, yFlipped);
	}

}
