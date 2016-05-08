package com.slaydevil.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.slaydevil.core.display.Display;
import com.slaydevil.core.gfx.Assets;
import com.slaydevil.core.input.KeyManager;
import com.slaydevil.core.states.GameState;
import com.slaydevil.core.states.State;

public class Game implements Runnable{
	private Display display;
	
	public String title;
	public int width;
	public int height;
	
	private boolean running = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	
	private KeyManager keyManager;
	
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		handler = new Handler(this);
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(handler);
		State.setCurrentState(gameState);
	}
	
	private void update(){
		keyManager.update();
		if (State.getCurrentState() != null)
			State.getCurrentState().update();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if (State.getCurrentState() != null)
			State.getCurrentState().render(g);
				
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1){	
				update();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000){
				System.out.println("Updates " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getkeyManager() {
		return keyManager;
	}
	
	public synchronized void start(){
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}