package ch.bfh.btx8201.cdss4nsar.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ValidationService {

	@Autowired
	public List<String> validators;
	
	public ValidationService(List<String> validators) {
		
	}
}
