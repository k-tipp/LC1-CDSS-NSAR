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
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

// TODO: Auto-generated Javadoc
/**
 * The Class BloodPlateValidator.
 */
public class BloodPlateValidator implements ICdss4NsarValidator {

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator#validate(ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest)
	 */
	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		for(Cdss4NsarLabor labor : cdssRequest.getLabResults()) {
			if(labor.getType().equalsIgnoreCase("Thrombozyten")) {
				if(Integer.parseInt(labor.getValue()) < 150) {
					for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
						if(drug.isNsar()) {
							warnings.add(Cdss4NsarWarning.create().setName("Warnung Thrombozytenwert")
									.setDescription("Das Blutungsrisiko ist bei Gabe von NSAR ist erhöht, Nutzen/Risiko abwägen.")
									.setMeasurementType("G/l")
									.setMeasurementUnit("Anzahl")
									.setMeasurementValue(labor.getValue())
									.setFailedTest("Thrombozytenwert < 150 G/l")
									.setConflictObjOne("Patient")
									.setConflictObjTwo(drug.getName())
									.setAlertLevel("warning"));
						}
					}
				}
			}
		}
		return warnings;
	}

}
