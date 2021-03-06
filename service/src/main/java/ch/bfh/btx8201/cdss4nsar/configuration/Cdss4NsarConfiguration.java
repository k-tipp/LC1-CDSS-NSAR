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
package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarConfiguration.
 */
@Component
@Service
@EnableJpaRepositories("ch.bfh.btx8201.cdss4nsar.data")
@EnableTransactionManagement
public class Cdss4NsarConfiguration {

	/**
	 * Gets the JAXB marshaller.
	 *
	 * @return the JAXB marshaller
	 */
	@Bean
	public Jaxb2Marshaller getJAXBMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		Map<String, Boolean> properties = new HashMap<String, Boolean>();
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxb2Marshaller.setMarshallerProperties(properties);
		jaxb2Marshaller.setClassesToBeBound(Settings.class);
		return jaxb2Marshaller;
	}

	/**
	 * Gets the config loader.
	 *
	 * @return the config loader
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JAXBException the JAXB exception
	 */
	@Bean
	public ConfigLoader getConfigLoader() throws IOException, JAXBException {

		ConfigLoader configLoader = new ConfigLoader();
		configLoader.setMarshaller(getJAXBMarshaller());
		configLoader.setUnmarshaller(getJAXBMarshaller());
		return configLoader;
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JAXBException the JAXB exception
	 */
	@Bean
	@Scope("singleton")
	public Settings getSettings() throws IOException, JAXBException {
		ConfigLoader configLoader = getConfigLoader();
		configLoader.loadSettings();
		return configLoader.getSettings();
	}

	/**
	 * Gets the validation service.
	 *
	 * @return the validation service
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JAXBException the JAXB exception
	 */
	@Bean
	public ValidationService getValidationService()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, JAXBException {
		// System.out.println("asdfsadfasdfsadfsadf");
		List<URL> jarFiles = new ArrayList<URL>();
		File dir = new File("cdss4nsar/lib");
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith((".jar"))) {
				jarFiles.add(new URL("jar", "", "file:/" + file.getAbsolutePath() + "!/"));
//				System.out.println(new URL("jar", "", file.toURI().toURL().toString()) + "!/");
			}
		}
//		this.getClass().getClassLoader();

		URLClassLoader cl = URLClassLoader.newInstance(jarFiles.toArray(new URL[jarFiles.size()]),
				this.getClass().getClassLoader());

//		System.out.println(jarFiles.get(0).getProtocol());
//		JarURLConnection uc = (JarURLConnection) new URL(jarFiles.get(0).toString()).openConnection();
//		Enumeration<JarEntry> e = uc.getJarFile().entries();
//		while (e.hasMoreElements()) {
//			System.out.println(e.nextElement().getName());
//		}

		// URL myJarFile = new URL("jar","","file:"+jarPath);
		// System.out.println("asdf3");
		//
		List<ICdss4NsarValidator> validators = new ArrayList<ICdss4NsarValidator>();
		Settings settings = getSettings();
		for (String name : settings.getValidators()) {
			this.getClass().getClassLoader();
			Class<?> c = cl.loadClass(name);

			if (c != null) {
				validators.add((ICdss4NsarValidator) c.newInstance());
				System.out.println("Added validator: " + name + "\r\n");
			}
		}

		cl.close();

		ValidationService service = ValidationService.getInstance();
		service.setCdss4NsarValidators(validators);

		return service;
	}

//	@Bean
//	public List<Cdss4NsarDrug> getDrugList() throws IOException, JAXBException {
//		ObjectMapper mapper = new ObjectMapper();
//		RestTemplate restTemplate = new RestTemplate();
//		String drugList = restTemplate.getForObject("http://localhost:8080/demoCIS/druglist", String.class);
//		return mapper.readValue(drugList, new TypeReference<List<Drug>>(){});
//	}
	
	/**
 * Data source.
 *
 * @return the data source
 * @throws Exception the exception
 */
@Bean(destroyMethod = "close")
	@Primary
	public DataSource dataSource() throws Exception {
		  JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		  DataSource dataSource = dataSourceLookup.getDataSource("jdbc/CDSS");
		  return dataSource;
	};

	/**
	 * Entity manager factory.
	 *
	 * @return the entity manager factory
	 * @throws Exception the exception
	 */
	@Bean(destroyMethod = "close")
	@Scope("singleton")
	public EntityManagerFactory entityManagerFactory() throws Exception {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource());
		factory.setJpaProperties(getAdditionalProperties());
		factory.setPackagesToScan("ch.bfh.btx8201.cdss4nsar.data");
		factory.afterPropertiesSet();

		return factory.getObject();
	}

    /**
     * Transaction manager.
     *
     * @param emf the emf
     * @return the jpa transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

	/**
	 * Gets the additional properties.
	 *
	 * @return the additional properties
	 */
	@Bean
	public Properties getAdditionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");//create-drop
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "false");
		return properties;
	}
}
