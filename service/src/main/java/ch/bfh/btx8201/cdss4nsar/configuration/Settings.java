package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="settings")
public class Settings {
	

	private List<String> validators;

	@XmlElementWrapper(name = "validators")
	@XmlElement(name="validator", type=String.class)
	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}	
}
