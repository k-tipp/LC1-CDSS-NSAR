package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfigurationModel {
	
	@XmlElementWrapper(name = "validators")
	@XmlElement(name = "validator")
	private List<String> validators;

	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}	
}
