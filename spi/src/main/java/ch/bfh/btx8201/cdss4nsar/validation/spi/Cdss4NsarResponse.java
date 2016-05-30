package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;

public class Cdss4NsarResponse {
	
	final String requestId;
	final List<Cdss4NsarWarning> warnings;
	
	public Cdss4NsarResponse(String id, List<Cdss4NsarWarning> warnings) {
		super();
		this.requestId = id;
		this.warnings = warnings;
	}

	public String getId() {
		return requestId;
	}

	public List<Cdss4NsarWarning> getWarnings() {
		return warnings;
	}
}
