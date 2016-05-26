package hl7;

import java.io.IOException;
import java.util.Map;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;

public class HL7ReceivingApplication implements ReceivingApplication {

	public boolean canProcess(Message in) {
		return true;
	}

	public Message processMessage(Message message, Map<String, Object> metadata)
			throws ReceivingApplicationException, HL7Exception {
		String encodedMessage = new DefaultHapiContext().getPipeParser().encode(message);
		System.out.println("Received message:\n" + encodedMessage + "\n\n");
		// Now generate a simple acknowledgment message and return it
		try {
			return message.generateACK();
		} catch (IOException e) {
			throw new HL7Exception(e);
		}

	}

}
