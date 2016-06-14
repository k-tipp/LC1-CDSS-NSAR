package ch.bfh.btx8201.cdss4nsar.validation;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class ValidationService {

	private static List<ICdss4NsarValidator> cdss4NsarValidators;

	private static ValidationService service;

	private ValidationService() {
	}

	public static synchronized ValidationService getInstance() throws MalformedURLException {
		if (service == null) {
			service = new ValidationService();
		}
		return service;
	}

	public Set<Cdss4NsarWarning> validateRequest(Cdss4NsarRequest request) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();

		try {
			Iterator<ICdss4NsarValidator> validators = ValidationService.cdss4NsarValidators.iterator();
			System.out.println("get book1");
			while (validators.hasNext()) {
				ICdss4NsarValidator validator = validators.next();
				Set<Cdss4NsarWarning> result = validator.validate(request);
				if (result != null) {
					warnings.addAll(result);
				}

			}
		} catch (ServiceConfigurationError serviceError) {
			serviceError.printStackTrace();
		}
		return warnings;
	}

	public List<ICdss4NsarValidator> getCdss4NsarValidators() {
		return cdss4NsarValidators;
	}

	public void setCdss4NsarValidators(List<ICdss4NsarValidator> cdss4NsarValidators) {
		ValidationService.cdss4NsarValidators = cdss4NsarValidators;
	}
}
