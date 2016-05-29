package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DemoCisInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { DemoCisConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] {WebConfiguration.class};
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
