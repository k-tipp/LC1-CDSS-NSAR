package validators;

import java.util.HashSet;
import java.util.Set;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class DoubleValidator implements ICdss4NsarValidator {

	@Override
	public Set<Cdss4NsarWarning> validate(Cdss4NsarRequest cdssRequest) {
		Set<Cdss4NsarWarning> warnings = new HashSet<Cdss4NsarWarning>();
		if (cdssRequest.getDrugs().size() > 0)

		{
			int i = 0;
			for (ICdss4NsarDrug drug : cdssRequest.getDrugs()) {
				if (drug.isNsar()) {
					i++;
				}
			}
			if (i > 1) {
				warnings.add(Cdss4NsarWarning.create().setName("Warnung Doppelmedikation")
						.setDescription("Es wurden mehrere NSAR verschrieben")
						.setMeasurementType("Doppelmedikation")
						.setMeasurementUnit("Anzahl")
						.setMeasurementValue(Integer.toString(i))
						.setFailedTest("Doppelmedikation")
						.setConflictObjOne("Patient")
						.setConflictObjTwo("Change me in doubleVAlitator")
						.setAlertLevel("danger"));
			}

		}
		return warnings;
	}
}
