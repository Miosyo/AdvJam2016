package com.slaydevil.core.states;

import java.awt.Graphics;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.dynamic.Player;
import com.slaydevil.core.entities.statics.Tree;
import com.slaydevil.core.worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/testWorld.txt");
		handler.setWorld(world);
	}

	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
