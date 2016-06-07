package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.Set;

public class Cdss4NsarResponse {
	
	Set<Cdss4NsarWarning> warnings;
	
	public Cdss4NsarResponse() {}
	
	public Cdss4NsarResponse(Set<Cdss4NsarWarning> warnings) {
		super();
		this.warnings = warnings;
	}

	public Set<Cdss4NsarWarning> getWarnings() {
		return warnings;
	}
}
