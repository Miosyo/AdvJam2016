package com.slaydevil.core.entities.dynamic;

import java.awt.Graphics;

import com.slaydevil.core.Handler;
import com.slaydevil.core.gfx.Assets;

public class Projectile extends DynamicEntity{
	private Handler handler;
	private float xDir;
	private float yDir;
	
	public Projectile(Handler handler, float x, float y) {
		super(handler, x, y);
		xDir = 0;
		yDir = 0;
	}

	@Override
	public void update() {
		xMove = speed * xDir;
		yMove = speed * yDir;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.woodFloor, (int)x, (int)y, width, height, null);
	}
	
	public void setDir(float x, float y){
		xDir = x;
		yDir = y;
	}
	
}
