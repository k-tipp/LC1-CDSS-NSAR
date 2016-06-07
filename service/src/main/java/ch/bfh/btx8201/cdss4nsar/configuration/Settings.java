package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="settings")
public class Settings {
	
	private String driverClassName;
	
	private String dbUrl;
	
	private String user;
	
	private String password;
	
	private List<String> validators;

	@XmlElementWrapper(name = "validators")
	@XmlElement(name="validator", type=String.class)
	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}

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
