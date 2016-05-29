package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="settings")
public class Settings {
	
	private String driverClassName;
	
	private String dbUrl;
	

	private String user;
	
	private String password;
	
	@XmlElement(name="dbdriverclassname")
	public String getDriverClassName() {
		return driverClassName;
	}
	
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	@XmlElement(name="dburl")
	public String getDbUrl() {
		return dbUrl;
	}
	
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	
	@XmlElement(name="dbuser")
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@XmlElement(name="dbpassword")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
}
