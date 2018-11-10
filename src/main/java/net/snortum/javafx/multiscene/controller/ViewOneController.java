
package net.snortum.javafx.multiscene.controller;

import javafx.stage.Stage;
import net.snortum.javafx.multiscene.view.ViewOne;

/**
 * Controller for {@link ViewOne}.
 * 
 */
public class ViewOneController {

	private Stage stage;

	/** Must inject a stage */
	public ViewOneController(Stage stage) {
		if (stage == null) {
			throw new IllegalArgumentException("Stage cannot be null");
		}

		this.stage = stage;
	}
}
