package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLaborImpl;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class BloodPlateValidator implements Cdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		for(Cdss4NsarLaborImpl labor : cdssRequest.getLabResults()) {
			if(labor.getType().equalsIgnoreCase("Thrombozyten")) {
				if(Integer.parseInt(labor.getValue()) < 150) {
					for(Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
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
