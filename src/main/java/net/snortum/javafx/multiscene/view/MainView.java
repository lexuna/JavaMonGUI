package net.snortum.javafx.multiscene.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.controller.ViewController;

/**
 * Creates and returns the scene for {@link Main}.
 * 
 */
public class MainView implements ViewMaker {

	private Scene scene;

	/** Must inject a stage */
	public MainView(Stage stage) {
		// Inject stage from Main into controller
		ViewController controller = new ViewController(stage);

		// Monster select
		Button m1 = new Button("Monster 1");
		m1.setPrefSize(100, 100);
		// m1.setOnMousePressed(e -> controller.handleOnPressButton1(e)); //// START
		// HERE
		// m1.setOnMousePressed() //TODO: WHEN MONSTER BUTTON PRESSED SHOW <this>
		// MONSTER ON SCENE 2 aka pass value

		Button m2 = new Button("Monster 2");
		m2.setPrefSize(100, 100);

		Button m3 = new Button("Monster 3");
		m3.setPrefSize(100, 100);

		Button play = new Button("Play"); // Optional oder direkt über m1,m2,m3
		play.setPrefSize(100, 100);

		play.setOnMousePressed(e -> controller.handleOnPressButton1(e)); //// START HERE

		// play.setOnMousePressed(e -> controller.handleOnPressButton1TEST(e));

		// Build scene
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));

		HBox hbox = new HBox(1); // spacing = 8
		hbox.setPadding(new Insets(0, 200 - hbox.getWidth(), 0, 200 - hbox.getWidth()));
		hbox.getChildren().addAll(m1, m2, m3, play);

		BorderPane root = new BorderPane();
		root.setLeft(vbox);
		root.setCenter(hbox);
		Label label = new Label("             Hauptmenü                    Wähle Monster");
		label.setFont(new Font(32));
		root.setTop(label); // Label Wähle Monster

		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10));
		root.setBottom(bbar);

		// A button with the specified text caption and icon.
		Image imageOk = Main.getGraphics().get(1);
		Button monster1 = new Button("", new ImageView(imageOk));
		monster1.setLayoutX(400);
		monster1.setLayoutY(320);
		root.getChildren().addAll(monster1);
		scene = new Scene(root, 770, 458);

		root.getStyleClass().add("main-class");

		scene.getStylesheets().add(getClass().getResource("/mainClass.css").toExternalForm());

		// HIER BUTTON LISTENER ? Oder neue klasse?public class ?
		m1.setOnMousePressed(event -> {
			Image img = Main.getGraphics().get(1);
			monster1.setGraphic(new ImageView(img));
			ViewController.chooseMonster(1);
		});

		m2.setOnMousePressed(event -> {
			Image img = Main.getGraphics().get(2);
			monster1.setGraphic(new ImageView(img));
			ViewController.chooseMonster(2);
		});

		m3.setOnMousePressed(event -> {
			Image img = Main.getGraphics().get(3);
			monster1.setGraphic(new ImageView(img));
			ViewController.chooseMonster(3);
		});

	}

	@Override
	public Scene getScene() {
		return scene;
	}
}
