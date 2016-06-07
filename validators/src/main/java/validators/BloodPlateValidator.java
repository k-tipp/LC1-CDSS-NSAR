package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class BloodPlateValidator implements Cdss4NsarValidator {

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		if(cdssRequest.getBloodPlateValue() < 150 && cdssRequest.getBloodPlateValue() != -1) {
			
			warning = Cdss4NsarWarning.create().setName("Warnung Thrombozytenwert")
				.setDescription("Thrombozytopenie liegt vor, es dürfen keine NSAR verordnet werden")
				.setMeasurementType("Anzahl / µl Blut")
				.setMeasurementUnit("Anzahl")
				.setMeasurementValue(Integer.toString(cdssRequest.getBloodPlateValue() * 1000))
				.setFailedTest("Thrombozytenwert < 150 000 / µl Blut");
		}
		return warning;
	}

}
