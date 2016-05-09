package com.slaydevil.core.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
	
	private static final int TILE_SIZE = 16;
	
	public static BufferedImage player;
	public static BufferedImage grass;
	public static BufferedImage tree;
	
	public static BufferedImage wallCornerTopLeft;
	public static BufferedImage wallCornerTopRight;
	public static BufferedImage wallCornerBotLeft;
	public static BufferedImage wallCornerBotRight;
	public static BufferedImage wallNorth;
	public static BufferedImage wallSouth;
	public static BufferedImage wallEast;
	public static BufferedImage wallWest;
	
	public static void init(){
		try {
			SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
			
			player = sheet.crop(0 * TILE_SIZE, 6 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			grass = sheet.crop(6 * TILE_SIZE, 5 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			wallCornerTopLeft = sheet.crop(0 * TILE_SIZE, 0 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			
			wallNorth = sheet.crop(5 * TILE_SIZE, 4 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			wallSouth = sheet.crop(5 * TILE_SIZE, 3 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			wallEast = sheet.crop(2 * TILE_SIZE, 5 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			wallWest = sheet.crop(3 * TILE_SIZE, 5 * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
