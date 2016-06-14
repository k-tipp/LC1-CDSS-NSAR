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
package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
@XmlRootElement(name="settings")
public class Settings {
	
	/** The cdss server ip. */
	private String cdssServerIp;
	
	/** The cdss server port. */
	private String cdssServerPort;	
	
	/** The validators. */
	private List<String> validators;

	/**
	 * Gets the validators.
	 *
	 * @return the validators
	 */
	@XmlElementWrapper(name = "validators")
	@XmlElement(name="validator", type=String.class)
	public List<String> getValidators() {
		return validators;
	}

	/**
	 * Sets the validators.
	 *
	 * @param validators the new validators
	 */
	public void setValidators(List<String> validators) {
		this.validators = validators;
	}
	
	/**
	 * Gets the server ip.
	 *
	 * @return the server ip
	 */
	@XmlElement(name="cdss_server_ip", type=String.class)
	public String getServerIp() {
		return cdssServerIp;
	}

	/**
	 * Sets the server ip.
	 *
	 * @param cdssServerIp the new server ip
	 */
	public void setServerIp(String cdssServerIp) {
		this.cdssServerIp = cdssServerIp;
	}

	/**
	 * Gets the server port.
	 *
	 * @return the server port
	 */
	@XmlElement(name="cdss_server_port", type=String.class)
	public String getServerPort() {
		return cdssServerPort;
	}

	/**
	 * Sets the server port.
	 *
	 * @param cdssServerPort the new server port
	 */
	public void setServerPort(String cdssServerPort) {
		this.cdssServerPort = cdssServerPort;
	}	
	
	
	
	
}
