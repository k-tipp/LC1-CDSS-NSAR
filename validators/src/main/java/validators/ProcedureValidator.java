package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class ProcedureValidator implements Cdss4NsarValidator {

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		String procedure = cdssRequest.getProcedure();
		if(procedure != null && !procedure.isEmpty()) {
			if(procedure.contains("Band") || procedure.contains("Sehne"))
			warning = Cdss4NsarWarning.create().setName("Warnung Behandlung")
				.setDescription("Patient wird an Bänder oder Sehnen operiert, es sollten keine NSAR verordnet werden")
				.setMeasurementType("Behandlung")
				.setMeasurementUnit("Ja/Nein")
				.setMeasurementValue("Ja")
				.setFailedTest("Operation an Bänder oder Sehnen.");
		}
		return warning;
	}

}
