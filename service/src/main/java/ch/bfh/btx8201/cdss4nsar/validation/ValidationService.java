package ch.bfh.btx8201.cdss4nsar.validation;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;

public class ValidationService {

	private static List<Cdss4NsarValidator> cdss4NsarValidators;
	
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
    	System.out.println("get book0");
        String definition = null;

        try {
            Iterator<Cdss4NsarValidator> validators = this.cdss4NsarValidators.iterator();
            System.out.println("get book1");
            while (definition == null && validators.hasNext()) {
            	System.out.println("get book2");
            	Cdss4NsarValidator d = validators.next();
            	System.out.println("get book3");
                definition = d.getDefinition(word);
                System.out.println("definition");
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
