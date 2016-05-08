package com.slaydevil.core;

import com.slaydevil.core.input.KeyManager;
import com.slaydevil.core.worlds.World;

public class Handler {
	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}

	public int getWidth(){
		return game.width;
	}
	
	public int getHeight(){
		return game.height;
	}
	
	public KeyManager getkeyManager(){
		return game.getkeyManager();
	}
	
	//getters and setters
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
