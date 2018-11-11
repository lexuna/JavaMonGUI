package net.snortum.javafx.multiscene.model;

import net.snortum.javafx.multiscene.Main;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:36
 */
public class Fight {

	private Player player;
	private Enemy enemy;

	public Fight() {
		this.player = Main.getPlayer();
		this.enemy = new Enemy();
	}

	/**
	 * get the player attack dmg and count it on the enemy's health
	 * 
	 * @param skill default null
	 * @return playerAttackDmg for GUI
	 * @throws NoSkillImplemented if skill != null
	 * @throws EnemyIsDead
	 * @throws LevelUp
	 */
	public int playerAttack(Skill skill) throws NoSkillImplemented, EnemyIsDead, LevelUp {
		int playerAttackDmg = player.attack(skill);
		if (enemy.takeDmg(playerAttackDmg)) {
			throw new EnemyIsDead("the player killed the enemy");
		}
		return playerAttackDmg;
	}

	/**
	 * 
	 * get the enemy attack dmg and count it on the player's health
	 * 
	 * @param skill default null
	 * @return enemyAttackDmg for GUI
	 * @throws NoSkillImplemented if skill != null
	 * @throws PlayerIsDead
	 */
	public int enemyAttack(Skill skill) throws NoSkillImplemented, PlayerIsDead {
		int enemyAttackDmg = enemy.attack(skill);
		if (player.takeDmg(enemyAttackDmg)) {
			throw new PlayerIsDead("the enemy killed the player");
		}
		return enemyAttackDmg;
	}

	public Enemy getEnemy() {
		return enemy;
	}

}