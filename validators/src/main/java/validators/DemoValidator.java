package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class DemoValidator implements Cdss4NsarValidator {

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		if(Math.random() < 0.5) {
			warning = Cdss4NsarWarning.create().setName("Demo Warnung")
				.setDescription("Diese Warnung erscheint zufällig mit 50% Wahrscheinlichkeit.")
				.setMeasurementType("Haarlänge")
				.setMeasurementUnit("mm")
				.setMeasurementValue("13")
				.setFailedTest("Haarlänge > 10mm");
		}
		return warning;
	}

}
