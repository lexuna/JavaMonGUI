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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
	private Label enemyDmg;
	private Label playerDmg;
	private Label dead;

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

		dead = new Label();
		dead.setFont(new Font(40));
		dead.setTextFill(Color.web("#FF0000"));

		enemy = new Button();
		enemy.setLayoutX(590);
		enemy.setLayoutY(190);
		root.getChildren().addAll(enemy);

		enemyDmg = new Label();
		enemyDmg.setFont(new Font(25));
		enemyDmg.setTextFill(Color.web("#00FF00"));
		playerDmg = new Label();
		playerDmg.setFont(new Font(25));
		playerDmg.setTextFill(Color.web("#FF0000"));

		VBox hBox = new VBox();
		hBox.setSpacing(10);

		healthBar = new HealthBar();
		healthBar.setValue(Main.getPlayer().getHealth(), Main.getPlayer().getMaxHealth());

		enemyBar = new HealthBar();
		enemyBar.setValue(100, 100);

		Button attack = new Button("Attack");
		attack.setOnAction(e -> FightController.onAttack(e));
		levelLabel = new Label();

		VBox vBox = new VBox();
		VBox.setMargin(attack, new Insets(20, 0, 0, 25));
		hBox.getChildren().addAll(levelLabel, healthBar.getProgressBar(), attack);
		vBox.setSpacing(10);

		vBox.getChildren().addAll(enemyDmg, enemyBar.getProgressBar(), playerDmg, dead, hBox);
		VBox.setMargin(hBox, new Insets(20, 0, 0, 240));
		VBox.setMargin(enemyBar.getProgressBar(), new Insets(50, 0, 0, 380));
		VBox.setMargin(enemyDmg, new Insets(30, 0, 0, 570));
		VBox.setMargin(playerDmg, new Insets(0, 0, 0, 148));
		VBox.setMargin(dead, new Insets(20, 0, 0, 245));

		playerName = new Label();
//		root.setLeft(playerName);

		root.setCenter(vBox);
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

	public Label getEnemyDmg() {
		return enemyDmg;
	}

	public Label getPlayerDmg() {
		return playerDmg;
	}

	public Label getDead() {
		return dead;
	}
}
