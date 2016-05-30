package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;

public interface Cdss4NsarValidator {
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs);
}
