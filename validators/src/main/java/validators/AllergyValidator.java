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
package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class AllergyValidator.
 */
public class AllergyValidator implements ICdss4NsarValidator {

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator#validate(ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest)
	 */
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
