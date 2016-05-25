package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
 
@Configuration
public class Cdss4NsarConfiguration {
    
//	@Bean
//	public CastorMarshaller getCastorMarshaller() {
//	  CastorMarshaller castorMarshaller = new CastorMarshaller();
//	  Map<String, String> castorProperties = new HashMap<String, String>();
//	  castorProperties.put("org.exolab.castor.indent", "true");
//	  castorMarshaller.setSuppressXsiType(true);
//	  castorMarshaller.setCastorProperties(castorProperties);
////	  Resource resource = new ClassPathResource("mapping.xml");
////	  castorMarshaller.setMappingLocation(resource);
//	  castorMarshaller.setTargetClass(Settings.class);
//	  return castorMarshaller;
//	}
    
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
		ConfigLoader l = new ConfigLoader();
//		Settings cm = new Settings();
//		List<String> li = new ArrayList<String>();
//		li.add("asdf");
//		li.add("qer");
//		li.add("qertzt");
//		cm.setValidators(li);
		l.setMarshaller(getJAXBMarshaller());
		l.setUnmarshaller(getJAXBMarshaller());
		l.loadSettings();
		return l;
	}	
	
	@Bean
	public ValidationService getValidationService() throws IOException, JAXBException {
		Settings configs = getConfigLoader().getSettings();
		for(String s : configs.getValidators()) {
			System.out.println("asdf   " + s);
		}
		return null;
	}
    
    
 
}
