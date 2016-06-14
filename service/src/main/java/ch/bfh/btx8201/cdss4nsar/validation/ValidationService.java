/*
 * TODO: Insert Description 
 * 
 * No rights are granted except not declinable rights from included
 * projects, libraries etc.
 *
 * @author  Kevin Tippenhauer
 * @author	Martin Stierlin
 * @author	Lukas Wyss
 * @since	SNAPSHOT-1.0.0
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationService.
 */
public class ValidationService {

	/** The cdss4 nsar validators. */
	private static List<ICdss4NsarValidator> cdss4NsarValidators;

	/** The service. */
	private static ValidationService service;

	/**
	 * Instantiates a new validation service.
	 */
	private ValidationService() {
	}

	/**
	 * Gets the single instance of ValidationService.
	 *
	 * @return single instance of ValidationService
	 * @throws MalformedURLException the malformed url exception
	 */
	public static synchronized ValidationService getInstance() throws MalformedURLException {
		if (service == null) {
			service = new ValidationService();
		}
		return service;
	}

	/**
	 * Validate request.
	 *
	 * @param request the request
	 * @return the sets the
	 */
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

	/**
	 * Gets the cdss4 nsar validators.
	 *
	 * @return the cdss4 nsar validators
	 */
	public List<ICdss4NsarValidator> getCdss4NsarValidators() {
		return cdss4NsarValidators;
	}

	/**
	 * Sets the cdss4 nsar validators.
	 *
	 * @param cdss4NsarValidators the new cdss4 nsar validators
	 */
	public void setCdss4NsarValidators(List<ICdss4NsarValidator> cdss4NsarValidators) {
		ValidationService.cdss4NsarValidators = cdss4NsarValidators;
	}
}
