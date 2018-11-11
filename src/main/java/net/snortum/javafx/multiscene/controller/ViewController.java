package net.snortum.javafx.multiscene.controller;

import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.model.SceneName;
import net.snortum.javafx.multiscene.view.ViewOne;

/**
 * Pressing a button displays the different scenes.
 * 
 */
public class ViewController {

	private Stage stage;

	/** Inject the stage from {@link Main} */
	public ViewController(Stage stage) {
		this.stage = stage;
	}

	/** Display the first scene */
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
