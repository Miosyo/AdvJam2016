package com.slaydevil.core.entities.projectiles;

import java.awt.Graphics;

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
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.woodFloor, (int)x, (int)y, width / 4, height / 4, null);
	}	
}
