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
 * The Class CreatinineValidator.
 */
public class CreatinineValidator implements ICdss4NsarValidator {

	/** The warning serum. */
	Cdss4NsarWarning warningSerum;
	
	/** The warning clearance. */
	Cdss4NsarWarning warningClearance;

	/**
	 * Instantiates a new creatinine validator.
	 */
	public CreatinineValidator() {
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator#validate(ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest)
	 */
	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		for(Cdss4NsarLabor labor : cdssRequest.getLabResults()) {
			if(labor.getType().equalsIgnoreCase("Creatinin Clearance")) {
				if (Integer.parseInt(labor.getValue()) < 30) {
					for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
						if(drug.isNsar()) {
							warnings.add(Cdss4NsarWarning.create()
									.setName("Warnung Kreatinin Clearance")
									.setMeasurementType("Kreatinin Clearance")
									.setMeasurementUnit("ml/min/1.73m2")
									.setDescription("Erhöhtes Risiko durch eingeschränkte Nierenfunktion, von NSAR wird abgeraten.")
									.setMeasurementValue(labor.getValue())
									.setFailedTest("Kreatinin Clearance < 30 ml/min/1.73m2")
									.setConflictObjOne("Patient")
									.setConflictObjTwo(drug.getName())
									.setAlertLevel("danger"));
						}
					}	
				} else if (Integer.parseInt(labor.getValue()) <= 60) {
					for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
						if(drug.isNsar()) {
							warnings.add(Cdss4NsarWarning.create()
									.setName("Warnung Kreatinin Clearance")
									.setMeasurementType("Kreatinin Clearance")
									.setMeasurementUnit("ml/min/1.73m2")
									.setDescription("Erhöhtes Risiko durch eingeschränkte Nierenfunktion, Nutzen/Risiko abwägen.")
									.setMeasurementValue(labor.getValue())
									.setFailedTest("Kreatinin Clearance <= 60 ml/min/1.73m2")
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
