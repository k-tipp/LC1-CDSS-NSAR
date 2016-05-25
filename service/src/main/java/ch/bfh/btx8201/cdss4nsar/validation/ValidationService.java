package ch.bfh.btx8201.cdss4nsar.validation;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;

@Service
public class ValidationService {

	@Autowired
	public List<Cdss4NsarValidator> cdss4NsarValidators;
	
	private static ValidationService service;

    private ValidationService() {
    }

    public static synchronized ValidationService getInstance() throws MalformedURLException {
        if (service == null) {
            service = new ValidationService();
        }
        return service;
    }


    public String getDefinition(String word) {
        String definition = null;

        try {
            Iterator<Cdss4NsarValidator> validators = this.cdss4NsarValidators.iterator();
            while (definition == null && validators.hasNext()) {
            	Cdss4NsarValidator d = validators.next();
                definition = d.getDefinition(word);
            }
        } catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();

        }
        return definition;
    }

	public List<Cdss4NsarValidator> getCdss4NsarValidators() {
		return cdss4NsarValidators;
	}

	public void setCdss4NsarValidators(List<Cdss4NsarValidator> cdss4NsarValidators) {
		this.cdss4NsarValidators = cdss4NsarValidators;
	}
    
    
}
