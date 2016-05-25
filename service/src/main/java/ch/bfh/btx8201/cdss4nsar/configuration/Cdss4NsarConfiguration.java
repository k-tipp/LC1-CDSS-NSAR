package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
 
@Configuration
@ComponentScan(basePackages = {"ch.bfh.btx8201.cdss4nsar", "validators", "ch.bfh.btx8201.cdss4nsar.validation.spi"})
public class Cdss4NsarConfiguration {
    
	@Bean
	public Jaxb2Marshaller getJAXBMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
	  Map<String, Boolean> properties = new HashMap<String, Boolean>();
	  properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	  jaxb2Marshaller.setMarshallerProperties(properties);
	  jaxb2Marshaller.setClassesToBeBound(Settings.class);
	  return jaxb2Marshaller;
	}
	
	@Bean
	public ConfigLoader getConfigLoader() throws IOException, JAXBException {
		
		ConfigLoader configLoader = new ConfigLoader();
		configLoader.setMarshaller(getJAXBMarshaller());
		configLoader.setUnmarshaller(getJAXBMarshaller());
		return configLoader;
	}	
	
	@Bean
	public Settings getSettings() throws IOException, JAXBException {
		ConfigLoader configLoader = getConfigLoader();
		configLoader.loadSettings();
		return configLoader.getSettings();
	}
	
	@SuppressWarnings({ "resource" })
	@Bean
	public List<Cdss4NsarValidator> getCdss4NsarValidators() throws IOException, JAXBException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		URLClassLoader cl = new URLClassLoader(new URL[] { new URL("cdss4nsar/lib/") });
		List<Cdss4NsarValidator> validators = new ArrayList<Cdss4NsarValidator>();
		for(String name : getSettings().getValidators()) {
			Class<?> c = cl.loadClass(name);
			if(c != null && Cdss4NsarValidator.class.isAssignableFrom(c)) {
				validators.add((Cdss4NsarValidator) c.newInstance());
			}
		}
		
		return validators;
	}
	
	@Bean
	public ValidationService getValidationService() throws MalformedURLException {
		ValidationService service = ValidationService.getInstance();
		
		return service;
		
	}
    
    
 
}
