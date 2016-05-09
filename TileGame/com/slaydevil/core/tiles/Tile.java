package com.slaydevil.core.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile wallTopLeftTile = new WallTopLeft(1);
	public static Tile wallNorth = new WallNorth(5);
	public static Tile wallSouth = new WallSouth(6);
	public static Tile wallEast = new WallEast(7);
	
	//class
	protected BufferedImage texture;
	protected final int id;
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 64;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId(){
		return id;
	}
}
