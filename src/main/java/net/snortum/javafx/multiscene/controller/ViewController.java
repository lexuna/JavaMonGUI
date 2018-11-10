package net.snortum.javafx.multiscene.controller;

import net.snortum.javafx.multiscene.Main;

public class ViewController {

	public static void chooseMonster(int x) {
		Main.getPlayer().setGraficID(x);
	}

}
