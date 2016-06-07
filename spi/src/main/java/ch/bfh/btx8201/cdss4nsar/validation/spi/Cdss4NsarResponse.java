package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;

public class Cdss4NsarResponse {
	
	final List<Cdss4NsarWarning> warnings;
	
	public Cdss4NsarResponse(List<Cdss4NsarWarning> warnings) {
		super();
		this.warnings = warnings;
	}

	public List<Cdss4NsarWarning> getWarnings() {
		return warnings;
	}
}
