package com.slaydevil.core.entities.projectiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.Entity;
import com.slaydevil.core.entities.creatures.Creature;
import com.slaydevil.core.gfx.Assets;

public class Projectile extends Entity{
	private Handler handler;
	
	private float angle;
	
	public Projectile(Handler handler, float x, float y, int width, int height, float angle) {
		super(handler, x, y, width, height);
		this.handler = handler;
		this.angle = angle;
		this.bounds = new Rectangle(0, 0, width / 4, height / 4);
	}

	@Override
	public void update() {
		x += 1;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)x, (int)y, width / 4, height / 4, null);
		g.setColor(Color.red);
		g.drawRect((int)x + bounds.x, (int)y + bounds.y, bounds.width, bounds.height);
	}	
}
