package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class PPIValidator implements ICdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		for (Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
			if (!drug.isPPI()) {
				for (Cdss4NsarDrug drug : cdssRequest.getDrugs()) {
					if (drug.isSteroid()) {
						for (ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
							if (drug.isNsar()) {
								warnings.add(Cdss4NsarWarning.create().setName("Warnung PPI")
										.setDescription(
												"Dem Patienten wurden Steroide und NSAR verschrieben, es muss zusätzlich ein PPI verschrieben werden.")
										.setMeasurementType("").setMeasurementUnit("").setMeasurementValue("")
										.setFailedTest("NSAR + Steroid").setConflictObjOne("Patient")
										.setConflictObjTwo("").setAlertLevel("warning"));
							} else if (drug.isNsar()) {
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
			return warnings;
		}

	}
}
