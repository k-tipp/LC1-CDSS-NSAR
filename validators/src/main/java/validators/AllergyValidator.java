package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;

public class AllergyValidator implements ICdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		if (cdssRequest.getDrugs().size() > 0) {
			for (String allergy : cdssRequest.getAllergies()) {
				for (ICdss4NsarDrug drug : cdssRequest.getDrugs()) {

					if (drug.getName().toLowerCase().contains(allergy.toLowerCase())) {
						warnings.add(Cdss4NsarWarning.create().setName("Warnung Allergie")
								.setMeasurementType("Allergie").setMeasurementUnit("")
								.setDescription("Es besteht eine Allergie gegen " + allergy).setMeasurementValue("")
								.setFailedTest("Allergie").setConflictObjOne("Patient")
								.setConflictObjTwo(drug.getName()).setAlertLevel("danger"));
					}

				}
			}
		}
		return warnings;
	}
}
