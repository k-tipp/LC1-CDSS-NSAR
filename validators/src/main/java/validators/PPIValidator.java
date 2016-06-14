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

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class PPIValidator.
 */
public class PPIValidator implements ICdss4NsarValidator {

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator#validate(ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest)
	 */
	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		for (Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
			if (!drug.isPpi()) {
				for (Cdss4NsarDrug drug2 : cdssRequest.getDrugs()) {
					if (drug2.isStereoidal()) {
						for (ICdss4NsarDrug drug3 : cdssRequest.getDrugs()) {
							if (drug3.isNsar()) {
								warnings.add(Cdss4NsarWarning.create().setName("Warnung PPI")
										.setDescription(
												"Dem Patienten wurden Steroide und NSAR verschrieben, es muss zusätzlich ein PPI verschrieben werden.")
										.setMeasurementType("").setMeasurementUnit("").setMeasurementValue("")
										.setFailedTest("NSAR + Steroid").setConflictObjOne("Patient")
										.setConflictObjTwo("").setAlertLevel("warning"));
							} else if (drug3.isNsar()) {
								if (cdssRequest.getAge() > 65) {
									warnings.add(Cdss4NsarWarning.create().setName("Warnung PPI")
											.setDescription(
													"Der Patient ist älter als 65, es muss zusätzlich ein PPI verschrieben werden.")
											.setMeasurementType("").setMeasurementUnit("").setMeasurementValue("")
											.setFailedTest("NSAR + Alter").setConflictObjOne("Patient")
											.setConflictObjTwo("").setAlertLevel("warning"));
								}
							}

						}
					}
				}
			}
			
		}
		return warnings;
	}
}
