package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class PregnancyValidator implements ICdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		System.out.println("--isPregnant--" + cdssRequest.isPregnant());
		if(cdssRequest.isPregnant()) {
			for(ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
				System.out.println("--isNsar--" + drug.isNsar());
				if(drug.isNsar()) {	
					
					warnings.add(Cdss4NsarWarning.create()
							.setName("Warnung Schwangerschaft")
							.setDescription("Die Patientin ist Schwanger, NSAR sind kontraindiziert")
							.setMeasurementType("Schwangerschaft")
							.setMeasurementUnit("Ja/Nein")
							.setMeasurementValue("Ja")
							.setFailedTest("Patientin ist schwanger")
							.setConflictObjOne("Patient")
							.setConflictObjTwo(drug.getName())
							.setAlertLevel("danger"));
				}
			}
		}
		return warnings;
	}
}