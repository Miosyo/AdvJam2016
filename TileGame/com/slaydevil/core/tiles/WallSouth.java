package com.slaydevil.core.tiles;

import com.slaydevil.core.gfx.Assets;

public class WallSouth extends Tile {

	public WallSouth(int id) {
		super(Assets.wallSouth, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
