package net.snortum.javafx.multiscene.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.model.SceneName;
import net.snortum.javafx.multiscene.view.ViewOne;

/**
 * This class is a controller for the view. it contains all ActionHandler.
 * 
 */
public class ViewController {

	private Stage stage;

	public ViewController(Stage stage) {
		this.stage = stage;
	}

	/**
	 * This method is the ActionHandler for the play button;
	 * 
	 * @param event
	 */
	public void handleOnPressButton1(MouseEvent event) {
		ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
		Label label = view.getPlayerNameLabel();

		label.setText(Main.getPlayer().getName() + ", " + Main.getPlayer().getHealth());
		Button monster = view.getMonster();
		monster.setGraphic(new ImageView(Main.getGraphics().get(Main.getPlayer().getGraficID())));
		stage.setScene(view.getScene());
		view.getPlayerLevelLabel().setText(Main.getPlayer().getLevel() + "");
		FightController.startNewFight();
	}

	/**
	 * ActionHandler for the monster button;
	 * 
	 * @param x
	 */
	public static void chooseMonster(int x) {
		Main.getPlayer().setGraficID(x);
	}

	public static void showPlayerDmg(int dmg) {

		ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
		Label label = view.getPlayerDmg();
		label.setText(dmg + "");
	}

	public static void showEnemyDmg(int dmg) {

		ViewOne view = (ViewOne) Main.getScenes().get(SceneName.SCENE1);
		Label label = view.getEnemyDmg();
		label.setText(dmg + "");
	}
}
