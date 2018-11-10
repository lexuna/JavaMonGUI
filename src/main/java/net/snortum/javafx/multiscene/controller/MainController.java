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
 * Pressing a button displays the different scenes.
 * 
 */
public class MainController {

	private Stage stage;

	/** Inject the stage from {@link Main} */
	public MainController(Stage stage) {
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
	}

	// TEST FUNC
	public void handleOnPressButton1TEST(MouseEvent event) {
		stage.setScene(net.snortum.javafx.multiscene.Main.getScenes().get(SceneName.SCENE1).getScene());
	}

}
