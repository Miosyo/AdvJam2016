package com.slaydevil.core.entities.statics;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}
