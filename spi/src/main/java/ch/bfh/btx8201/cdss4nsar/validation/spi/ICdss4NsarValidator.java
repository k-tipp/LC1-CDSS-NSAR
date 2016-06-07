package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.Set;

public interface ICdss4NsarValidator {
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest);
}
