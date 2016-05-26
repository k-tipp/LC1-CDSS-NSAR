package hl7;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

public class HL7Server {
	
	
	private HapiContext ctx = new DefaultHapiContext();
	private HL7Service server; 
	private ReceivingApplication handler = new HL7ReceivingApplication();
	
	
	public HL7Server(int port, boolean useTls) throws Exception
	{
		ctx.setValidationRuleBuilder(new NoValidationBuilder());
		server = ctx.newServer(port, useTls);
		server.registerApplication("*", "*", handler);
		server.registerConnectionListener(new HL7ConnectionListener());
		server.startAndWait();
	}
}
