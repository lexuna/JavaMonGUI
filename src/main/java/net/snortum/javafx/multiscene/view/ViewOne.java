package net.snortum.javafx.multiscene.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;

/**
 * Creates and returns the scene for the first view.
 * 
 */
public class ViewOne implements ViewMaker {

	private Label playerName;
	private Scene scene;
	private Button monster;

	/** Must inject a stage */
	public ViewOne(Stage stage) {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		Image image = Main.getGraphics().get(Main.getPlayer().getGraficID());
		monster = new Button("", new ImageView(image));
		monster.setLayoutX(200);
		monster.setLayoutY(200);
		root.getChildren().addAll(monster);

		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(closeButton);
		root.setBottom(bbar);

		// Kann ich hier in der View elemente hinzufügen?
		playerName = new Label();
		root.setLeft(playerName);

		stage.setResizable(false);
		this.scene = new Scene(root, 800, 460);
	}

	@Override
	public Scene getScene() {
		return scene;
	}

	public Button getMonster() {
		return monster;
	}

	public Label getPlayerNameLabel() {
		return this.playerName;
	}
}
