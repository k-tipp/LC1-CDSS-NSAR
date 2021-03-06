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

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

// TODO: Auto-generated Javadoc
/**
 * The Class AgeValidator.
 */
public class AgeValidator implements ICdss4NsarValidator {

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator#validate(ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest)
	 */
	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		if(cdssRequest.getAge() != -1) {
			if(cdssRequest.getAge() < 12) {
				for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
					if(drug.getName().toLowerCase().contains("naproxen")) {			
						warnings.add(Cdss4NsarWarning.create()
								.setName("Warnung Patient zu jung")
								.setDescription("Bei Kindern unter 12 Jahren darf kein Naproxen verschrieben werden.")
								.setMeasurementType("Alter")
								.setMeasurementUnit("Jahr")
								.setMeasurementValue(Integer.toString(cdssRequest.getAge()))
								.setFailedTest("Alter < 12 Jahre")
								.setConflictObjOne("Patient")
								.setConflictObjTwo(drug.getName())
								.setAlertLevel("warning"));
					}
				}
			}
			if(cdssRequest.getAge() < 6) {
				for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
					if(drug.getName().toLowerCase().contains("irfen")) {			
						warnings.add(Cdss4NsarWarning.create()
								.setName("Warnung Patient zu jung")
								.setDescription("Bei Kindern unter 6 Jahren darf kein Irfen verschrieben werden.")
								.setMeasurementType("Alter")
								.setMeasurementUnit("Jahr")
								.setMeasurementValue(Integer.toString(cdssRequest.getAge()))
								.setFailedTest("Alter < 6 Jahre")
								.setConflictObjOne("Patient")
								.setConflictObjTwo(drug.getName())
								.setAlertLevel("warning"));
					}
				}
			}
		}
		return warnings;
	}

}
