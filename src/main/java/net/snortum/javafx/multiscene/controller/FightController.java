package net.snortum.javafx.multiscene.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.model.EnemyIsDead;
import net.snortum.javafx.multiscene.model.Fight;
import net.snortum.javafx.multiscene.model.LevelUp;
import net.snortum.javafx.multiscene.model.NoSkillImplemented;
import net.snortum.javafx.multiscene.model.PlayerIsDead;
import net.snortum.javafx.multiscene.model.SceneName;
import net.snortum.javafx.multiscene.view.ViewOne;

/**
 * THis class is the controller for a fight.
 * 
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class FightController {

	private static Fight activeFight;
	private static boolean dead;

	public FightController() {

	}

	public void finalize() throws Throwable {

	}

	public static void startNewFight() {
		activeFight = new Fight();
		int id = activeFight.getEnemy().getGraficID();
		Image image = Main.getGraphics().get(id);
		ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
		view.getEnemy().setGraphic(new ImageView(image));
		view.getEnemyBar().setValue(activeFight.getEnemy().getHealth(), activeFight.getEnemy().getMaxHealth());
	}

	public void run() {

	}

	public static void onAttack(ActionEvent e) {
		if (!dead) {
			ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
			try {
				int playerDmg = FightController.getActiveFight().playerAttack(null);
				ViewController.showPlayerDmg(playerDmg);
				view.getEnemyBar().setValue(activeFight.getEnemy().getHealth(), activeFight.getEnemy().getMaxHealth());
				int enemyDmg = FightController.getActiveFight().enemyAttack(null);
				view.getPlayerBar().setValue(Main.getPlayer().getHealth(), Main.getPlayer().getMaxHealth());
				ViewController.showEnemyDmg(enemyDmg);
			} catch (NoSkillImplemented e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (EnemyIsDead e1) {
				// TODO Auto-generated catch block
				startNewFight();
			} catch (LevelUp e1) {
				// TODO Auto-generated catch block
				startNewFight();
				view.getPlayerLevelLabel().setText(Main.getPlayer().getLevel() + "");
			} catch (PlayerIsDead e1) {
				view.getDead().setText("Game Over!");
				dead = true;
			}
		}
	}

	public static Fight getActiveFight() {
		return activeFight;
	}

}