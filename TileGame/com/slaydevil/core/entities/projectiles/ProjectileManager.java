package com.slaydevil.core.entities.projectiles;

import java.awt.Graphics;
import java.util.ArrayList;

import com.slaydevil.core.Handler;
import com.slaydevil.core.entities.EntityManager;

public class ProjectileManager {
	private Handler handler;
	private EntityManager entityManager;

	private ArrayList<Projectile> projectiles;

	public ProjectileManager(Handler handler, EntityManager entityManager) {
		this.handler = handler;
		this.entityManager = entityManager;
		projectiles = new ArrayList<Projectile>();
	}

	public void update() {
		for (Projectile p : projectiles) {
			p.update();
		}
	}

	public void render(Graphics g) {
		for (Projectile p : projectiles){
			p.render(g);
		}
	}

	public void addProjectile(Projectile p){
		projectiles.add(p);
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
}
