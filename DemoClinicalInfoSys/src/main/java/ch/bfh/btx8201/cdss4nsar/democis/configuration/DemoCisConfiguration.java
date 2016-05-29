package ch.bfh.btx8201.cdss4nsar.democis.configuration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@Service
@EnableJpaRepositories("ch.bfh.btx8201.cdss4nsar.democis.data")
@EnableTransactionManagement
public class DemoCisConfiguration {
	
//	@Autowired
//	public LabResultDao labResultDao;
//	
//	@Autowired
//	public PatientDao patientDao;

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

	@Bean(destroyMethod = "close")
	@Primary
	public DataSource dataSource() throws IOException, JAXBException, SQLException {
		Settings settings = getSettings();
		return DataSourceBuilder.create().username(settings.getUser()).password(settings.getPassword())
				.url(settings.getDbUrl()).driverClassName(settings.getDriverClassName()).build();
	};

	@Bean(destroyMethod = "close")
	public EntityManagerFactory entityManagerFactory() throws IOException, JAXBException, SQLException {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setJpaProperties(getAdditionalProperties());
		factory.setPackagesToScan("ch.bfh.btx8201.cdss4nsar.democis.data");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException, JAXBException, SQLException {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public Properties getAdditionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

}
