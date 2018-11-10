package net.snortum.javafx.multiscene.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;

/**
 * This is the base for all views.
 */
public class ViewBase implements ViewMaker {

	private Stage stage;
	private Scene scene;

	/**
	 * Construct a view base.
	 * 
	 * @param stage     the primary stage from {@link Main}
	 * @param labelText the text for the label
	 * @param handler   the "back" button handler
	 */
	public ViewBase(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}

		this.stage = stage;
	}

	private void createScene() {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		Label label = new Label("This Is A Label!");
		label.setFont(new Font(32));
		root.setCenter(label);

		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10, 0, 0, 10));
		bbar.getButtons().addAll(closeButton);
		root.setBottom(bbar);
		
		stage.setResizable(false);
		this.scene = new Scene(root, 800, 460);
	}

	@Override
	public Scene getScene() {
		if (scene == null) {
			createScene();
		}
		return scene;
	}
}
