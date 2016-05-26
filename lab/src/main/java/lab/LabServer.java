package lab;

import java.util.concurrent.Executors;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

public class LabServer {
	
	private int port = 4000;
	private boolean useTLS = false;
	
	
	private HapiContext ctx = new DefaultHapiContext();
	private HL7Service server = ctx.newServer(port, useTLS);
	
	public LabServer()
	{
		ctx.setValidationRuleBuilder(new NoValidationBuilder());
		
	}

}
