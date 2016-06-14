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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
public class App {

	/** The msgs. */
	private static ArrayList<Message> msgs = new ArrayList<Message>();
	
	/** The user input. */
	private static Scanner userInput = new Scanner(System.in);
	
	/** The sender. */
	private static Sender sender;
	
	/** The receiver. */
	private static Receiver receiver = new Receiver();
	
	/** The receiver server. */
	private static ReceiverServer receiverServer = new ReceiverServer(8080, "HL7", "incoming", receiver);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		sender = new Sender("localhost", 8080, "/demoCIS/hl7");
		receiverServer.start();

		System.out.println("Welcome to the Lab Höheweg");
		command();

	}

	/**
	 * Input.
	 *
	 * @return the string
	 */
	public static String input() {

		String input = userInput.nextLine();
		return input.toLowerCase();
	}

	/**
	 * Command.
	 *
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void command() throws FileNotFoundException {
		System.out.println("please enter command:");
		switch (input()) {
		case "read":
			msgs.clear();
			System.out.println("specify filename to read:");
			FileReader reader = new FileReader(input());
			Hl7InputStreamMessageIterator iterator = new Hl7InputStreamMessageIterator(reader);
			System.out.println("the following messages have been found:");
			int i = 1;

			while (iterator.hasNext()) {
				Message msg = iterator.next();
				msgs.add(msg);
				System.out.println(i + ". message is:");
				try {
					System.out.println(msg.encode());
				} catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			command();
			break;
		case "send":
			for (Message msg : msgs) {
				try {
					sender.send(new MessageSendable(msg));
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
			command();
			break;
		}
	}
}
