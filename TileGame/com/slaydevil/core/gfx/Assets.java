package com.slaydevil.core.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
	
	private static final int TILE_SIZE = 16;
	
	public static BufferedImage player;
	public static BufferedImage stoneWall;
	public static BufferedImage stoneFloor;
	public static BufferedImage woodFloor;
	public static BufferedImage grass1;
	public static BufferedImage grass2;
	public static BufferedImage tree;
	public static BufferedImage treeTiled;
	public static BufferedImage rock;
	
	public static void init(){
		try {
			SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/basictiles.png"));
			
			player = sheet.crop(3 * TILE_SIZE, 3 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			stoneWall = sheet.crop(0 * TILE_SIZE, 0 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			stoneFloor = sheet.crop(1 * TILE_SIZE, 0 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			woodFloor = sheet.crop(0 * TILE_SIZE, 1 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			grass1 = sheet.crop(0 * TILE_SIZE, 8 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			grass2 = sheet.crop(1 * TILE_SIZE, 8 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			tree = sheet.crop(4 * TILE_SIZE, 9 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			treeTiled = sheet.crop(4 * TILE_SIZE, 11 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			rock = sheet.crop(2 * TILE_SIZE, 7 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
