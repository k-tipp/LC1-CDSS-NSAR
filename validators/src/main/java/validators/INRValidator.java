package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class INRValidator implements Cdss4NsarValidator {

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		if(cdssRequest.getInr() > 1.1) {
			
			warning = Cdss4NsarWarning.create().setName("Warnung Blutgerinnung")
				.setDescription("INR > 1.1, es dürfen keine NSAR verordnet werden")
				.setMeasurementType("INR")
				.setMeasurementUnit("prothrombin time")
				.setMeasurementValue(Double.toString(cdssRequest.getInr()))
				.setFailedTest("INR > 1.1");
		}
		return warning;
	}

}
