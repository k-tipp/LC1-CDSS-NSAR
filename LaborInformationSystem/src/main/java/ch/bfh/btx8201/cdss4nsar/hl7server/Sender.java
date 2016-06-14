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

// TODO: Auto-generated Javadoc
/**
 * The Class Sender.
 */
public class Sender {

	/** The client. */
	private HohClientSimple client;

	/**
	 * Instantiates a new sender.
	 *
	 * @param host the host
	 * @param port the port
	 * @param uri the uri
	 * @throws HL7Exception the h l7 exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Sender(String host, int port, String uri) throws HL7Exception, IOException {

		// Create a parser
		Parser parser = PipeParser.getInstanceWithNoValidation();

		// Create a client
		client = new HohClientSimple(host, port, uri, parser);
	}

	/**
	 * Send.
	 *
	 * @param sendable the sendable
	 * @throws EncodingNotSupportedException the encoding not supported exception
	 * @throws HL7Exception the h l7 exception
	 * @throws DecodeException the decode exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws EncodeException the encode exception
	 */
	public void send(ISendable<Message> sendable)
			throws EncodingNotSupportedException, HL7Exception, DecodeException, IOException, EncodeException {

		client.sendAndReceiveMessage(sendable);
	}
}
