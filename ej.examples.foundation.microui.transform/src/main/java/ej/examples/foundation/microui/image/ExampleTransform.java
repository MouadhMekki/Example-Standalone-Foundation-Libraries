/*
 * Java
 *
 * Copyright 2009-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.image;

import java.io.IOException;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.microui.display.Image;

/**
 * Use different image transformations
 */
public class ExampleTransform {

	private static final String IMAGE = "/images/microej_logo.png"; // image

	public static void main(String[] args) throws IOException {
		// Starts microUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDefaultDisplay();

		// Creates the model
		TransformModel model = new TransformModel(Image.createImage(IMAGE));

		// Creates the controller
		TransformEventHandler controller = new TransformEventHandler(d.getWidth(), d.getHeight());

		// Creates an ImageView (using whole display area)
		TransformDisplayable view = new TransformDisplayable(d, controller);

		// Set the MVC links
		model.addObserver(view);
		controller.setModel(model);
		controller.setView(view);

		view.show();
	}
}
