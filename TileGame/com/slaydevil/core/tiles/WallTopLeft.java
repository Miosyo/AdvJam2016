package com.slaydevil.core.tiles;


import com.slaydevil.core.gfx.Assets;

public class WallTopLeft extends Tile{

	public WallTopLeft(int id) {
		super(Assets.wallCornerTopLeft, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
