package wyslu1.hl7;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.datatype.NM;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.OBR;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class Sender {

	private String host;
	private int port;
	private String uri;

	private HohClientSimple client;

	public Sender(String host, int port, String uri) throws HL7Exception, IOException {

		this.host = host;
		this.port = port;
		this.uri = uri;

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
