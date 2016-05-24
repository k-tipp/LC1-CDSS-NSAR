package ch.bfh.btx8201.cdss4nsar.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resources;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class ConfigLoader {
	private static final String FILE_NAME = "webapp/WEB-INF/config/config.xml";
	private ConfigurationModel settings = new ConfigurationModel();

	private Marshaller marshaller;
	
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

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

	public void loadSettings() throws IOException, JAXBException {
		File f = new File(FILE_NAME);

		System.out.println(f.getAbsolutePath());
		FileInputStream is = null;
		try {
			is = new FileInputStream(FILE_NAME);
			this.settings = (ConfigurationModel) this.unmarshaller.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public ConfigurationModel getSettings() {
		return settings;
	}

	public void setSettings(ConfigurationModel settings) {
		this.settings = settings;
	}
	
	
}
