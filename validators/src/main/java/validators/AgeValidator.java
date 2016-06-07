package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class AgeValidator implements Cdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		if(cdssRequest.getAge() != -1) {
			if(cdssRequest.getAge() < 12) {
				for(Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
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
				for(Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
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
