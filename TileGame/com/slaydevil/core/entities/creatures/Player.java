package com.slaydevil.core.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.slaydevil.core.Game;
import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.projectiles.Projectile;
import com.slaydevil.core.gfx.Assets;

public class Player extends Creature {
	private Handler handler;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y);
		this.handler = handler;
		bounds.x = 8;
		bounds.y = 32;
		bounds.width = width - 16;
		bounds.height = height - 40;
	}

	@Override
	public void update() {
		getInput();
		move();
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getkeyManager().up)
			yMove = -speed;
		if (handler.getkeyManager().down)
			yMove = speed;
		if (handler.getkeyManager().left)
			xMove = -speed;
		if (handler.getkeyManager().right)
			xMove = speed;
		if (handler.getkeyManager().fire)
			handler.getWorld().getEntityManager().addEntity(new Projectile(handler, x, y, width, height, 0));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);

		// debug render
		g.setColor(Color.red);
		g.drawRect((int) x + (int) bounds.getX(), (int) y + (int) bounds.getY(), (int) bounds.getWidth(),
				(int) bounds.getHeight());
	}
}
