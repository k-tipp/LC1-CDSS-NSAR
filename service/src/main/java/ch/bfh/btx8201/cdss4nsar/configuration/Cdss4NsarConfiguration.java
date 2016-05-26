package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
 
//@Configuration
//@ComponentScan(basePackages = {"ch.bfh.btx8201.cdss4nsar", "validators", "ch.bfh.btx8201.cdss4nsar.validation.spi"})
@Component
@Service
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
	
	@Bean
	public ValidationService getValidationService() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, JAXBException {
//		System.out.println("asdfsadfasdfsadfsadf");
		List<URL> jarFiles = new ArrayList<URL>();
		  File dir = new File("cdss4nsar/lib");
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".jar"))) {
		      jarFiles.add(new URL("jar", "", "file:/" + file.getAbsolutePath() + "!/"));
		      System.out.println(new URL("jar", "", file.toURI().toURL().toString() ) + "!/");
		    }
		  }
		  System.out.println("asdfsadfasdfsadfsadf2");
		URLClassLoader cl = URLClassLoader.newInstance(jarFiles.toArray(new URL[jarFiles.size()]));
		System.out.println(jarFiles.get(0).getProtocol());
		JarURLConnection uc = 
				(JarURLConnection) new URL(jarFiles.get(0).toString()).openConnection();
		Enumeration<JarEntry> e = uc.getJarFile().entries();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement().getName());
		}
		
//		URL myJarFile = new URL("jar","","file:"+jarPath);
		System.out.println("asdf3");
		
		List<Cdss4NsarValidator> validators = new ArrayList<Cdss4NsarValidator>();
		System.out.println("asdf4");
		for(String name : getSettings().getValidators()) {
			System.out.println("name: " + name);
			this.getClass().getClassLoader();
			Class<?> c = cl.loadClass("validators.DemoValidator");
			System.out.println(c.getClass().getInterfaces()[0].getName());
			if(c != null) {
				System.out.println("add validator");
				validators.add((Cdss4NsarValidator) c.newInstance());
			}
		}
		
		cl.close();
		
		ValidationService service = ValidationService.getInstance();
		service.setCdss4NsarValidators(validators);
		
		return service;
		
	} 
}
