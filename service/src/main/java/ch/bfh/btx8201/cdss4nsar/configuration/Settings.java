package ch.bfh.btx8201.cdss4nsar.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;


@XmlRootElement(name="settings")
public class Settings {
	
	private List<String> validators;
	private List<Cdss4NsarDrug> drugs;

	@XmlElementWrapper(name = "validators")
	@XmlElement(name="validator", type=String.class)
	public List<String> getValidators() {
		return validators;
	}

	public void setValidators(List<String> validators) {
		this.validators = validators;
	}

	@XmlElementWrapper(name = "drugs")
	@XmlElement(name="drug", type=Cdss4NsarDrug.class)
	public List<Cdss4NsarDrug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Cdss4NsarDrug> drugs) {
		this.drugs = drugs;
	}
	
	
	
	
}
