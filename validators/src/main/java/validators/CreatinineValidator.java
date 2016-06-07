package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class CreatinineValidator implements ICdss4NsarValidator {

	Cdss4NsarWarning warningSerum;
	Cdss4NsarWarning warningClearance;

	public CreatinineValidator() {
	}

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
