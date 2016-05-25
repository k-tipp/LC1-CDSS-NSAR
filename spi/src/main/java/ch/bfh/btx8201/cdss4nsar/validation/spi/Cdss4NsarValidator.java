package ch.bfh.btx8201.cdss4nsar.validation.spi;

import org.springframework.stereotype.Service;

@Service
public interface Cdss4NsarValidator {
	public String getDefinition(String word);
}
