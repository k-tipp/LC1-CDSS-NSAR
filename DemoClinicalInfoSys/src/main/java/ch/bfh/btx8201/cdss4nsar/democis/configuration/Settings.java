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
package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import javax.xml.bind.annotation.XmlElement;
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
	
	/** The lis server ip. */
	private String lisServerIp;
	
	/** The lis server port. */
	private String lisServerPort;

	/**
	 * Gets the cdss server ip.
	 *
	 * @return the cdss server ip
	 */
	@XmlElement(name="cdss_server_ip")
	public String getCdssServerIp() {
		return cdssServerIp;
	}

	/**
	 * Sets the cdss server ip.
	 *
	 * @param cdssServerIp the new cdss server ip
	 */
	public void setCdssServerIp(String cdssServerIp) {
		this.cdssServerIp = cdssServerIp;
	}

	/**
	 * Gets the cdss server port.
	 *
	 * @return the cdss server port
	 */
	@XmlElement(name="cdss_server_port")
	public String getCdssServerPort() {
		return cdssServerPort;
	}

	/**
	 * Sets the cdss server port.
	 *
	 * @param cdssPort the new cdss server port
	 */
	public void setCdssServerPort(String cdssPort) {
		this.cdssServerPort = cdssPort;
	}

	/**
	 * Gets the lis server ip.
	 *
	 * @return the lis server ip
	 */
	@XmlElement(name="lis_server_ip")
	public String getLisServerIp() {
		return lisServerIp;
	}

	/**
	 * Sets the lis server ip.
	 *
	 * @param lisServerIp the new lis server ip
	 */
	public void setLisServerIp(String lisServerIp) {
		this.lisServerIp = lisServerIp;
	}

	/**
	 * Gets the lis server port.
	 *
	 * @return the lis server port
	 */
	@XmlElement(name="lis_server_port")
	public String getLisServerPort() {
		return lisServerPort;
	}

	/**
	 * Sets the lis server port.
	 *
	 * @param lisServerPort the new lis server port
	 */
	public void setLisServerPort(String lisServerPort) {
		this.lisServerPort = lisServerPort;
	}
	

}
