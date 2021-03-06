/*
 * Java
 *
 * Copyright 2014-2015 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.net.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example open a server on {@link NetEcho

import com.is2t.examples.netembedded.logger.INetLogger;
import com.is2t.examples.netembedded.logger.NetSysoutLogger;ges to the client.
 * Example stopped when the client close the connection and print all client messages.
 */
public class ExampleEchoServer implements NetEchoConstants{

	private static int WAIT_FOR_CONNECTION = 5000;
	/**
	 * Application logger.
	 */
	private static Logger Logger = java.util.logging.Logger.getLogger(ExampleEchoServer.class.getSimpleName());

	/**
	 * Echo server main entry point.
	 */
	public static void main(String[] args) {
		// Display all messages.
		Logger.setLevel(Level.ALL);

		Logger.info("Wainting for connection to be setup...");

		try {
			// Wait for the connection to be up. Would be better to use a
			// connectivity manager (eg ej.library.iot.connectivity).
			Thread.sleep(WAIT_FOR_CONNECTION);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Logger.info("server initialization...");
		// initiate a structure to append characters sent by the client
		StringBuffer sb = new StringBuffer();
		ServerSocket serv = null;
		Socket client = null;
		InputStream is = null;
		OutputStream os = null;
		try {

			// server initialization
			serv = new ServerSocket(PORT);
			Logger.info("server initialized. Waiting for connection on port " + PORT + "...");

			// wait the client connection
			client = serv.accept();
			Logger.info("client connected. Echo client message start");
			// read client message and echo the message.
			is = client.getInputStream();
			os = client.getOutputStream();
			int readByte = -1;
			while((readByte = is.read()) != -1){
				os.write((byte)readByte);
				sb.append((char)readByte);
			}
			Logger.info("client said \""+sb.toString()+"\".");
		} catch (IOException e) {
			Logger.severe(e.getMessage());
		} finally{
			try{
				if(is != null){
					is.close();
				}
				if(os != null){
					os.close();
				}
				if(client != null){
					client.close();
				}
				if(serv != null){
					serv.close();
				}
			} catch(IOException e){}
			Logger.info("server stopped.");
		}
	}

}
