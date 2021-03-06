/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.ecom.hotplug;


import ej.ecom.DeviceManager;
import ej.ecom.io.CommPort;

/**
 * This example listens for dynamic {@link CommPort} hot plugging.
 * When a new {@link CommPort} is plugged, its descriptor is dumped in JSON format.
 */
public class ExampleHotPlug {

	/**
	 * This is the main entry point.
	 * Simply registers the listener: it will be notified when a CommPort is registered or unregistered
	 * @see CommPortListener
	 */
	public static void main(String[] args) {
		System.out.println("ECOM-COMM Hotplug Example");
		DeviceManager.addRegistrationListener(new CommPortListener(), CommPort.class);
		System.out.println("=> Listener registered. Waiting for CommPort plug or unplug.");
	}

}