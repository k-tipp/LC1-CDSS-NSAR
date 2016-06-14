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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

/**
 * The Class ConfigLoader.
 */
public class ConfigLoader {
	
	/** The Constant FILE_NAME. */
	private static final String FILE_NAME = "cdss4nsar/cis_config.xml";
	
	/** The settings. */
	private Settings settings = new Settings();

	/** The marshaller. */
	private Marshaller marshaller;
	
	/** The unmarshaller. */
	private Unmarshaller unmarshaller;

	/**
	 * Sets the marshaller.
	 *
	 * @param marshaller the new marshaller
	 */
	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	/**
	 * Sets the unmarshaller.
	 *
	 * @param unmarshaller the new unmarshaller
	 */
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	/**
	 * Save settings.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JAXBException the JAXB exception
	 */
	public void saveSettings() throws IOException, JAXBException {
		FileOutputStream os = null;
		try {
			
			os = new FileOutputStream(FILE_NAME);
			this.marshaller.marshal(settings, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	/**
	 * Load settings.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JAXBException the JAXB exception
	 */
	public void loadSettings() throws IOException, JAXBException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(FILE_NAME);
			this.settings = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the new settings
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	
}
