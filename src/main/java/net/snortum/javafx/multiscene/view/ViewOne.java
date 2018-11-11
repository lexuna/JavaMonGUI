package net.snortum.javafx.multiscene.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.controller.FightController;

/**
 * Creates and returns the scene for the first view.
 * 
 */
public class ViewOne implements ViewMaker {

	private Label playerName;
	private Scene scene;
	private Button monster;
	private Button enemy;
	private HealthBar enemyBar;
	private HealthBar healthBar;
	private Label levelLabel;

	/** Must inject a stage */
	public ViewOne(Stage stage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		Image image = new Image(getClass().getResourceAsStream("/fightstage.png"));
		BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
		root.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize)));

		monster = new Button("", new ImageView(Main.getGraphics().get(Main.getPlayer().getGraficID())));
		monster.setLayoutX(170);
		monster.setLayoutY(320);
		root.getChildren().addAll(monster);

		enemy = new Button();
		enemy.setLayoutX(590);
		enemy.setLayoutY(190);
		root.getChildren().addAll(enemy);

		HBox hBox = new HBox();
		hBox.setSpacing(10);

		healthBar = new HealthBar();
		healthBar.setValue(Main.getPlayer().getHealth(), Main.getPlayer().getMaxHealth());

		enemyBar = new HealthBar();
		enemyBar.setValue(100, 100);
		enemyBar.getProgressBar().setLayoutX(450);
		enemyBar.getProgressBar().setLayoutY(150);

		Button attack = new Button("Attack");
		attack.setOnAction(e -> FightController.onAttack(e));
		levelLabel = new Label();

		VBox vBox = new VBox();
		VBox.setMargin(attack, new Insets(20, 0, 0, 25));
		vBox.getChildren().addAll(levelLabel, healthBar.getProgressBar(), attack);

//		HBox.setMargin(vBox, new Insets(300, 20, 20, 250));
		hBox.getChildren().addAll(vBox, enemyBar.getProgressBar());
		HBox.setMargin(vBox, new Insets(340, 0, 0, 250));
		HBox.setMargin(enemyBar.getProgressBar(), new Insets(100, 0, 0, 0));

		playerName = new Label();
//		root.setLeft(playerName);

		root.setCenter(hBox);
		stage.setResizable(false);
		this.scene = new Scene(root, 770, 458);
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

	public Button getEnemy() {
		return enemy;
	}

	public HealthBar getEnemyBar() {
		return enemyBar;
	}

	public HealthBar getPlayerBar() {
		return healthBar;
	}

	public Label getPlayerLevelLabel() {
		return levelLabel;
	}
}
