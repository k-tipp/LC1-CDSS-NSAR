package ch.bfh.btx8201.cdss4nsar.hl7server;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class Sender {

	private HohClientSimple client;

	public Sender(String host, int port, String uri) throws HL7Exception, IOException {

		// Create a parser
		Parser parser = PipeParser.getInstanceWithNoValidation();

		// Create a client
		client = new HohClientSimple(host, port, uri, parser);
	}

	public void send(ISendable<Message> sendable)
			throws EncodingNotSupportedException, HL7Exception, DecodeException, IOException, EncodeException {

		client.sendAndReceiveMessage(sendable);
	}
}
