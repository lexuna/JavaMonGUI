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
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class FightController {

	private static Fight activeFight;

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
		ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
		try {
			FightController.getActiveFight().playerAttack(null);
			view.getEnemyBar().setValue(activeFight.getEnemy().getHealth(), activeFight.getEnemy().getMaxHealth());
			FightController.getActiveFight().enemyAttack(null);
			view.getPlayerBar().setValue(Main.getPlayer().getHealth(), Main.getPlayer().getMaxHealth());
		} catch (NoSkillImplemented e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EnemyIsDead e1) {
			// TODO Auto-generated catch block
			startNewFight();
			System.out.println("Enemy is dead");
		} catch (LevelUp e1) {
			// TODO Auto-generated catch block
			startNewFight();
			view.getPlayerLevelLabel().setText(Main.getPlayer().getLevel() + "");
			System.out.println("Enemy is dead");
			System.out.println("Level up");
		} catch (PlayerIsDead e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static Fight getActiveFight() {
		return activeFight;
	}

}