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
package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
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

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class DemoCisConfiguration.
 */
@Component
@Service
@EnableJpaRepositories("ch.bfh.btx8201.cdss4nsar.democis.data")
@EnableTransactionManagement
public class DemoCisConfiguration {

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
	@Scope("singleton")
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
	 * Data source.
	 *
	 * @return the data source
	 * @throws Exception the exception
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws Exception {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource("jdbc/CIS");
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
		factory.setPackagesToScan("ch.bfh.btx8201.cdss4nsar.democis.data");
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
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");// create-drop
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "false");
		return properties;
	}

	/**
	 * Gets the hapi context.
	 *
	 * @return the hapi context
	 */
	@Bean(destroyMethod = "close")
	public HapiContext getHapiContext() {
		return new DefaultHapiContext();
	}

	/**
	 * Gets the h l7 parser.
	 *
	 * @param ctx the ctx
	 * @return the h l7 parser
	 */
	@Bean
	public Parser getHL7Parser(HapiContext ctx) {
		ctx.setValidationRuleBuilder(new NoValidationBuilder());
		return ctx.getGenericParser();

	}
}
