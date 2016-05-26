package hl7;

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionListener;

public class HL7ConnectionListener implements ConnectionListener {

	public void connectionReceived(Connection connection) {
		System.out.println("New connection received: " + connection.getRemoteAddress().toString());
	}

	public void connectionDiscarded(Connection connection) {
		System.out.println("Lost connection from: " + connection.getRemoteAddress().toString());
	}
}
