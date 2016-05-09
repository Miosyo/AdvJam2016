package com.slaydevil.core.tiles;

import com.slaydevil.core.gfx.Assets;

public class WallEast extends Tile {

	public WallEast(int id) {
		super(Assets.wallEast, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
