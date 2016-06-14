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


import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.api.IMessageHandler;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.raw.server.HohRawServlet;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Receiver.
 */
public class Receiver extends HohRawServlet{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new receiver.
	 */
	public Receiver(){
		setMessageHandler(new MessageHandler());
		
	}
	
	/**
	 * The Class MessageHandler.
	 */
	private static class MessageHandler implements IMessageHandler<String>
	{

		/* (non-Javadoc)
		 * @see ca.uhn.hl7v2.hoh.api.IMessageHandler#messageReceived(ca.uhn.hl7v2.hoh.api.IReceivable)
		 */
		public IResponseSendable<String> messageReceived(IReceivable<String> received) throws MessageProcessingException {
			String incomingRawMsg = received.getMessage();
			System.out.println("Received message: \n"+ incomingRawMsg);
		
			@SuppressWarnings("resource")
			HapiContext ctx = new DefaultHapiContext();
			ctx.setValidationRuleBuilder(new NoValidationBuilder());
			Parser parser = ctx.getGenericParser();
	

			Message message = null;
			Message ack = null;
			String response = null;
			try {
				message = parser.parse(incomingRawMsg);
				ack = message.generateACK();
				response = ack.encode();
			
			} catch (Exception e) {
				return new RawSendable(response);
				
			} 
			RawSendable rs = new RawSendable(response); 
			return rs;
	            }
            
           
			
			
		}
		
	}
