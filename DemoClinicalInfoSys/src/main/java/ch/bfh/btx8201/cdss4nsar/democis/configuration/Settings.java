package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="settings")
public class Settings {
	
	private String cdssServerIp;
	
	private String cdssServerPort;
	
	private String lisServerIp;
	
	private String lisServerPort;

	@XmlElement(name="cdss_server_ip")
	public String getCdssServerIp() {
		return cdssServerIp;
	}

	public void setCdssServerIp(String cdssServerIp) {
		this.cdssServerIp = cdssServerIp;
	}

	@XmlElement(name="cdss_server_port")
	public String getCdssServerPort() {
		return cdssServerPort;
	}

	public void setCdssServerPort(String cdssPort) {
		this.cdssServerPort = cdssPort;
	}

	@XmlElement(name="lis_server_ip")
	public String getLisServerIp() {
		return lisServerIp;
	}

	public void setLisServerIp(String lisServerIp) {
		this.lisServerIp = lisServerIp;
	}

	@XmlElement(name="lis_server_port")
	public String getLisServerPort() {
		return lisServerPort;
	}

	public void setLisServerPort(String lisServerPort) {
		this.lisServerPort = lisServerPort;
	}
	

}
