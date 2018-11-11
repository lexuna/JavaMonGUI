package net.snortum.javafx.multiscene.view;

import javafx.scene.control.ProgressBar;

public class HealthBar {

	private static final String GREEN = "-fx-accent: green; ";
	private static final String RED = "-fx-accent: red; ";
	private static final String ORANGE = "-fx-accent: orange; ";
	private static final String YELLOW = "-fx-accent: yellow; ";

	private ProgressBar pBar;

	public HealthBar() {
		pBar = new ProgressBar();
	}

	public void setValue(int health, int maxHealth) {
		if (health < maxHealth * 0.25) {
			pBar.setStyle(RED);
		} else if (health < maxHealth / 2) {
			pBar.setStyle(ORANGE);
		} else if (health < maxHealth * 0.75) {
			pBar.setStyle(YELLOW);
		} else {
			pBar.setStyle(GREEN);
		}

		double procent = ((100.0 * health) / maxHealth) / 100.0;
		pBar.setProgress(procent);
	}

	public ProgressBar getProgressBar() {
		return pBar;
	}
}
