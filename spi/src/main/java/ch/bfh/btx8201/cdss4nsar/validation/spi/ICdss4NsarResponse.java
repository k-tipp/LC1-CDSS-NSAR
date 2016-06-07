package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.Set;

public interface ICdss4NsarResponse {

	public Set<Cdss4NsarWarning> getWarnings();
	public Set<Cdss4NsarWarning> setWarnings();
}
