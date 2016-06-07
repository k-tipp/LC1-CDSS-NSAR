package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.Set;

public interface Cdss4NsarValidator {
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest);
}
