package com.slaydevil.core.worlds;

import java.awt.Graphics;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.EntityManager;
import com.slaydevil.core.entities.dynamic.Player;
import com.slaydevil.core.entities.statics.Tree;
import com.slaydevil.core.tiles.Tile;
import com.slaydevil.core.utils.Utils;

public class World {
	private Handler handler;

	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private int[][] tiles;

	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 0, 0));
		loadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

		entityManager.addEntity(new Tree(handler, 192, 128));
	}

	public void update() {
		entityManager.update();
	}

	public void render(Graphics g) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.rockTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");

		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
