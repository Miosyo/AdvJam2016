package com.slaydevil.core.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.creatures.Player;

public class EntityManager {
	private Handler handler;
	private Player player;

	private ArrayList<Entity> entities;
	private ArrayList<Entity> entityBuffer;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.height < b.getY() + b.height) {
				return -1;
			} else {
				return 1;
			}
		}
	};

	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		entityBuffer = new ArrayList<Entity>();
		addEntity(player);
	}

	public void update() {
		for (Entity e : entities) {
			e.update();
		}
		// Sort buffer into entity array
		for (Entity e : entityBuffer) {
			if (e.alive)
				entities.add(e);
			else
				entities.remove(e);
		}
		entityBuffer.clear();
		// sort render order for entities based on y axis
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}

	public void addEntity(Entity e) {
		entityBuffer.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
