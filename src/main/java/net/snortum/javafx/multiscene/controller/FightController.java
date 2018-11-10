package net.snortum.javafx.multiscene.controller;

import javafx.event.ActionEvent;
import net.snortum.javafx.multiscene.model.Fight;

/**
 * @author hannahn
 * @version 1.0
 * @created 30-Okt-2018 08:51:37
 */
public class FightController {

	private static Fight activeFight;

	public FightController() {

	}

	public void finalize() throws Throwable {

	}

	public static void startNewFight() {
		activeFight = new Fight();
	}

	/**
	 * startet ein neuen Kampf
	 */
	public void run() {

	}

	public static void onAttack(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}