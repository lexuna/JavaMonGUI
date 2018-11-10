package net.snortum.javafx.multiscene.model;

import java.util.List;
import java.util.Random;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class Player {

	private int graficID; // default 0
	private long level; // default 1
	private int xp; // default 0
	private String name;
	private int health;// default 100
	private int maxHealth;// default 100
	private int maxDmg; // default 25
	private int minDmg;// default 10
	private List<Skill> skills; // default null
	private List<Item> items; // default null
	private Statics statics;

	/**
	 * Konstruktor, erstellt die Statics und startet so die playTime
	 * 
	 * @param graficID default 0
	 */
	public Player(int graficID, String name) {
		this.graficID = graficID;
		this.level = 1;
		this.xp = 0;
		this.name = name;
		this.maxHealth = 100;
		this.health = maxHealth;
		this.maxDmg = 25;
		this.minDmg = 10;
		this.statics = new Statics();
	}

	public int attack(Skill skill) throws NoSkillImplemented {
		if (skill == null) {
			Random rand = new Random();
			return rand.nextInt(maxDmg - minDmg) + minDmg;
		} else {
			throw new NoSkillImplemented("No player attack skill");
		}
	}

	/**
	 * count the dmg to player's health, check if player is dead
	 * 
	 * @param dmg
	 * @return true if enemy is defeated
	 */
	public boolean takeDmg(int dmg) {
		health -= dmg;
		if (health <= 0) {
			return true;
		}
		return false;
	}

	public void addXP(int xp) throws LevelUp {
		double constA = 8.7;
		double constB = -40;
		double constC = 111;
		long oldLevel = level;
		this.xp += xp;
		level = Math.round(Math.max(Math.floor(constA * Math.log(this.xp + constC) + constB), 1));
		if (oldLevel != level) {
			maxHealth += 10;
			health = maxHealth;
			maxDmg += 5;
			minDmg += 5;
			throw new LevelUp();
		}
	}

	public Statics getStatics() {
		return statics;
	}

	public long getLevel() {
		return level;
	}

	public int getGraficID() {
		return graficID;
	}

	public int getXp() {
		return xp;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setGraficID(int graficID) {
		this.graficID = graficID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getMaxDmg() {
		return maxDmg;
	}

	public int getMinDmg() {
		return minDmg;
	}
}