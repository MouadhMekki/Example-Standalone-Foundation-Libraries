/*
 * Java
 *
 * Copyright 2011-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.image;

import java.util.Observable;

import ej.microui.display.Image;

public class ImageModel extends Observable {

	/**
	 * Current image.
	 */
	private Image image; // null init

	/**
	 * Current image path.
	 */
	private String imagePath;

	/**
	 * @return The current image.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @return The current image path.
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Create a new image from the path.
	 *
	 * @param path
	 *            New image path.
	 */
	public void setImage(String path) {

		this.imagePath = path;
		this.image = loadImage(path);

		// notifies its listeners that it has changed
		setChanged();
		notifyObservers();

	}

	private Image loadImage(String path) {
		System.out.print("Try to load the image: \"");
		System.out.print(path);
		System.out.print("\"... ");

		try {
			// try to load the image
			Image image = Image.createImage(path);
			System.out.println("loading done!");
			return image;

		} catch (Throwable e) {
			// IOException, MicroUIException, OutOfMemory...

			// several errors are possible:
			//
			// - the image is a runtime image:
			// * the path is invalid
			// * the image resource has not been added as application resource
			// * the platform cannot allocate some memory to decode the image
			// * the platform cannot load this kind of dynamic image
			//
			// - the image is a compile-time image:
			// * the path is invalid
			// * the pre-processing step has failed

			System.out.println("\nThe image loading has failed. Check your .list path and the image path.");
			return null;
		}
	}

}
