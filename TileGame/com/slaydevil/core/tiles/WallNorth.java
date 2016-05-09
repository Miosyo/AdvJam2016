package com.slaydevil.core.tiles;

import com.slaydevil.core.gfx.Assets;

public class WallNorth extends Tile {

	public WallNorth(int id) {
		super(Assets.wallNorth, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
