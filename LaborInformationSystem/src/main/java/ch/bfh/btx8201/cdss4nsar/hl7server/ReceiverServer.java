/*
 * TODO: Insert Description 
 * 
 * No rights are granted except not declinable rights from included
 * projects, libraries etc.
 *
 * @author  Kevin Tippenhauer
 * @author	Martin Stierlin
 * @author	Lukas Wyss
 * @since	SNAPSHOT-1.0.0
 */
package ch.bfh.btx8201.cdss4nsar.hl7server;


import javax.servlet.Servlet;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

// TODO: Auto-generated Javadoc
/**
 * The Class ReceiverServer.
 */
public class ReceiverServer {
	
	/** The port. */
	private int port;
	
	/** The server. */
	private Server server;

	/**
	 * Instantiates a new receiver server.
	 *
	 * @param port the port
	 * @param contextUri the context uri
	 * @param incomingUri the incoming uri
	 * @param receiver the receiver
	 */
	public ReceiverServer(int port, String contextUri, String incomingUri, Receiver receiver) {

		this.port = port;

		// Create a Jetty server instance
		server = new Server(this.port);
		Context context = new Context(server, "/" + contextUri, Context.SESSIONS);
		Servlet servlet = receiver;

		context.addServlet(new ServletHolder(servlet), "/" + incomingUri);

	}

	/**
	 * Start.
	 *
	 * @throws Exception the exception
	 */
	public void start() throws Exception {
		server.start();
	}

	/**
	 * Stop.
	 *
	 * @throws Exception the exception
	 */
	public void stop() throws Exception {
		server.stop();
	}
}
