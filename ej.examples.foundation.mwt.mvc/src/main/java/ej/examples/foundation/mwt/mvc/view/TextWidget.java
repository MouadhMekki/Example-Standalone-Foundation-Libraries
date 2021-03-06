/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.mwt.mvc.view;

import ej.examples.foundation.mwt.mvc.model.PercentageModel;
import ej.microui.display.GraphicsContext;


public class TextWidget extends PercentageWidget {

	/**
	 * @param model
	 */
	public TextWidget(PercentageModel model) {
		super(model);
	}

	/**
	 */
	public TextWidget() {
		super();
	}

	@Override
	public void render(GraphicsContext g) {

		super.render(g);

		// build message to print
		String message = new StringBuffer()
				.append("Value: ")
				.append(percentage().getValue())
				.append("%")
				.toString();

		// draw message in the middle of the view
		g.drawString(message, getWidth() / 2 + getX(), getHeight() / 2 + getY(),
				GraphicsContext.VCENTER | GraphicsContext.HCENTER);

	}
}
