package net.snortum.javafx.multiscene.model;

import java.util.Random;

import net.snortum.javafx.multiscene.Main;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:36
 */
public class Enemy {

	private static final String[] NAMES = { "Enemy 1", "Enemy 2" };
	private String name;
	private int graficId;
	private int health; // default 25
	private int maxHealth; // default 25
	private int maxDmg; // default 10
	private int minDmg; // default 5
	private int dropChangce; // default 50
	private int xp; // default 15

	public Enemy() {
		int playerLevel = (int) Main.getPlayer().getLevel();
		Random rand = new Random();
		graficId = rand.nextInt(3) + 1;
		int randMod = rand.nextInt(playerLevel) + (playerLevel - 5);
		this.name = NAMES[rand.nextInt(1)];
		this.maxHealth = 25;
		this.maxDmg = 10;
		this.minDmg = 5;
		this.xp = 15;

		randMod /= 2;
		if (randMod > 0) {
			this.maxHealth *= randMod;
			this.maxDmg *= randMod;
			this.minDmg *= randMod;
			this.xp *= randMod / 5;
		}
		this.health = maxHealth;
	}

	/**
	 * @param skill default null
	 * @return dmg
	 * @throws NoSkillImplemented if sill!=null
	 */
	public int attack(Skill skill) throws NoSkillImplemented {
		if (skill == null) {
			Random rand = new Random();
			return rand.nextInt(maxDmg - minDmg) + minDmg;
		} else {
			throw new NoSkillImplemented("No enemy attack skill");
		}
	}

	/**
	 * count the dmg to enemys health, check if enemy is dead and count the statics
	 * is enemy is dead
	 * 
	 * @param dmg
	 * @return true if enemy is defeated
	 * @throws LevelUp
	 */
	public boolean takeDmg(int dmg) throws LevelUp {
		health -= dmg;
		if (health <= 0) {
			Main.getPlayer().getStatics().defeatEnemy();
			Main.getPlayer().addXP(xp);
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getDropChangce() {
		return dropChangce;
	}

	public int getXp() {
		return xp;
	}

	public int getMaxDmg() {
		return maxDmg;
	}

	public int getGraficID() {
		return graficId;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

}