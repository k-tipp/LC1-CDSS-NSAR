package ch.bfh.btx8201.cdss4nsar.validation;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class ValidationService {

	private static List<Cdss4NsarValidator> cdss4NsarValidators;
	
	private static List<Cdss4NsarDrug> drugList;
	
	private static ValidationService service;

    private ValidationService() {
    }

    public static synchronized ValidationService getInstance() throws MalformedURLException {
        if (service == null) {
            service = new ValidationService();
        }
        return service;
    }


    public List<Cdss4NsarWarning> validateRequest(Cdss4NsarRequest request) {
        List<Cdss4NsarWarning> warnings = new ArrayList<Cdss4NsarWarning>();

        try {
            Iterator<Cdss4NsarValidator> validators = ValidationService.cdss4NsarValidators.iterator();
            System.out.println("get book1");
            while (validators.hasNext()) {
            	Cdss4NsarValidator validator = validators.next();
            	Cdss4NsarWarning result = validator.validate(request, drugList);
            	if(result != null) {
            		warnings.add(result);
            	}
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
        } finally {
        	if(warnings.size() == 0) {
        		return warnings;
        	}
        }
        return null;
    }

	public List<Cdss4NsarValidator> getCdss4NsarValidators() {
		return cdss4NsarValidators;
	}

	public void setCdss4NsarValidators(List<Cdss4NsarValidator> cdss4NsarValidators) {
		ValidationService.cdss4NsarValidators = cdss4NsarValidators;
	}

	public List<Cdss4NsarDrug> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<Cdss4NsarDrug> drugList) {
		ValidationService.drugList = drugList;
	}
	
	
    
    
}
