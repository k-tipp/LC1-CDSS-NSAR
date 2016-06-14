package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="settings")
public class Settings {
	
	private String cdssServerIp;
	
	private String cdssServerPort;	
	
	private List<String> validators;

	@XmlElementWrapper(name = "validators")
	@XmlElement(name="validator", type=String.class)
	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}
	
	@XmlElement(name="cdss_server_ip", type=String.class)
	public String getServerIp() {
		return cdssServerIp;
	}

	public void setServerIp(String cdssServerIp) {
		this.cdssServerIp = cdssServerIp;
	}

	@XmlElement(name="cdss_server_port", type=String.class)
	public String getServerPort() {
		return cdssServerPort;
	}

	public void setServerPort(String cdssServerPort) {
		this.cdssServerPort = cdssServerPort;
	}	
	
	
	
	
}
