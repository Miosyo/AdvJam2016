package com.slaydevil.core.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.slaydevil.core.Handler;
import com.slaydevil.core.gfx.Assets;
import com.slaydevil.core.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

		bounds.x = 0;
		bounds.y = height / 3 * 2;
		bounds.width = 56;
		bounds.height = height / 3;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) x, (int) y, width, height, null);

		// debug render
		g.setColor(Color.red);
		g.drawRect((int) x + (int) bounds.getX(), (int) y + (int) bounds.getY(), (int) bounds.getWidth(),
				(int) bounds.getHeight());
	}

}
