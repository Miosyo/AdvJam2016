package com.slaydevil.core.states;

import java.awt.Graphics;

import com.slaydevil.core.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	public static State getCurrentState() {
		return currentState;
	}
	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
