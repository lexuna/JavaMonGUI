package net.snortum.javafx.multiscene.model;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class Statics {

	/**
	 * die spielzeit in millis
	 */
	private long playTime;
	private int defeatedEnemies;
	private int fights;
	private long startTime;

	/**
	 * Konstruktor startet die Zeitmessung
	 */
	public Statics() {
		this.startTime = System.currentTimeMillis();
	}

	public void endSession() {
		long now = System.currentTimeMillis();
		long sessionPlaytime = now - startTime;
		playTime += sessionPlaytime;
	}

	public long getPlayTime() {
		return playTime;
	}

	public int getDefeatedEnemies() {
		return defeatedEnemies;
	}

	public int getFights() {
		return fights;
	}

	public void defeatEnemy() {
		defeatedEnemies++;
	}

	public void startFight() {
		fights++;
	}

}