package com.slaydevil.core.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.slaydevil.core.Game;
import com.slaydevil.core.Handler;

public class DebugEntity extends StaticEntity {

	public DebugEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		if (Game.fps > 58)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.drawString("FPS: " + Game.fps + " Delta: " + Game.deltaTime, (int) x, (int) y);
	}

}
