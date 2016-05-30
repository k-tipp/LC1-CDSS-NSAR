package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class PregnancyValidator implements Cdss4NsarValidator {

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		if(cdssRequest.isPregnant()) {
			
			warning = Cdss4NsarWarning.create().setName("Warnung Schwangerschaft")
				.setDescription("Die Patientin ist Schwanger, es dürfen keine NSAR verordnet werden")
				.setMeasurementType("Schwangerschaft")
				.setMeasurementUnit("Ja/Nein")
				.setMeasurementValue("Ja")
				.setFailedTest("Patientin ist schwanger");
		}
		return warning;
	}

}
