package lab;

import ca.uhn.hl7v2.app.Connection;

public class LabConnectionListener {

	public void connectionReceived(Connection connection) {
		System.out.println("New connection received: " + connection.getRemoteAddress().toString());
	}

	public void connectionDiscarded(Connection connection) {
		System.out.println("Lost connection from: " + connection.getRemoteAddress().toString());
	}
}
