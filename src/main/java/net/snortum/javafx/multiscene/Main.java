package net.snortum.javafx.multiscene;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.model.Player;
import net.snortum.javafx.multiscene.model.SceneName;
import net.snortum.javafx.multiscene.view.MainView;
import net.snortum.javafx.multiscene.view.ViewMaker;
import net.snortum.javafx.multiscene.view.ViewOne;

/**
 * Builds all scenes and display the main one.
 */
public class Main extends Application {

	/** Holds the various scenes to switch between */
	private static Map<SceneName, ViewMaker> scenes = new HashMap<>();
	private static Map<Integer, Image> graphics = new HashMap<>();
	private static Player character;

	static {
		graphics.put(1, new Image(MainView.class.getResourceAsStream("/idle.gif")));
		graphics.put(2, new Image(MainView.class.getResourceAsStream("/monster2.gif")));
		graphics.put(3, new Image(MainView.class.getResourceAsStream("/monster5.gif")));
	}

	public static void main(String[] args) {
		character = new Player(1, "");
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		// Create and store all scenes up front
		scenes.put(SceneName.MAIN, new MainView(stage));
		scenes.put(SceneName.SCENE1, new ViewOne(stage));

		// Start with the main scene
		stage.setScene(scenes.get(SceneName.MAIN).getScene());
		stage.setTitle("JAVAMON 0.01");
		stage.show();
	}

	/** Returns a Map of the scenes by {@link SceneName} */
	public static Map<SceneName, ViewMaker> getScenes() {
		return scenes;
	}

	public static Player getPlayer() {
		return character;
	}

	public static Map<Integer, Image> getGraphics() {
		return graphics;
	}
}
