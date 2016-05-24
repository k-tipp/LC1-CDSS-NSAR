package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ch.bfh.btx8201.cdss4nsar")
public class Cdss4NsarConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
    
    @Bean
    public ResourceResolver getResourceResolver() {
    	PathResourceResolver resourceResolver = new PathResourceResolver();
    	resourceResolver.setAllowedLocations(new PathResource("/WEB-INF/config/"));
    	return resourceResolver;
    }
    
    @Bean
    public ConfigurationModel getConfigurationModel() throws IOException, JAXBException {
    	return getConfigLoader().getSettings();
    }
    
	@Bean
	public CastorMarshaller getCastorMarshaller() {
	  CastorMarshaller castorMarshaller = new CastorMarshaller();
	  Map<String, String> castorProperties = new HashMap<String, String>();
//	  castorProperties.put("org.exolab.castor.indent", "true");
//	  castorMarshaller.setCastorProperties(castorProperties);
//	  Resource resource = new ClassPathResource("mapping.xml");
//	  castorMarshaller.setMappingLocation(resource);
	  castorMarshaller.setTargetClass(ConfigurationModel.class);
	  return castorMarshaller;
	}
	
	@Bean
	public ConfigLoader getConfigLoader() throws IOException, JAXBException {
		ConfigLoader l = new ConfigLoader();
		l.setMarshaller(getCastorMarshaller());
		l.setUnmarshaller(getCastorMarshaller());
		l.loadSettings();
		return l;
	}	
	
	@Bean
	public ValidationService getValidationService() throws IOException, JAXBException {
		ConfigurationModel configs = getConfigurationModel();
		for(String s : configs.getValidators()) {
			System.out.println(s);
		}
		return null;
	}
    
    
 
}
