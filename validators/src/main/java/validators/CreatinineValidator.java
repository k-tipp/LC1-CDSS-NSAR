package validators;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

public class CreatinineValidator implements Cdss4NsarValidator {

	Cdss4NsarWarning warningSerum;
	Cdss4NsarWarning warningClearance;

	public CreatinineValidator() {
		this.warningSerum = Cdss4NsarWarning.create()
				.setName("Warnung Kreatininserum")
				.setDescription("Kreatininserum ist hoch, Kreatinin Clearance muss geprüft werden.")
				.setMeasurementType("Kreatininserum")
				.setMeasurementUnit("mg/dl")
				.setFailedTest("Kreatininserum > 1.36");
		
		this.warningClearance = Cdss4NsarWarning.create()
				.setName("Warnung Kreatinin Clearance")
				.setMeasurementType("Kreatinin Clearance")
				.setMeasurementUnit("ml/min");
	}

	@Override
	public Cdss4NsarWarning validate(Cdss4NsarRequest cdssRequest, List<Cdss4NsarDrug> drugs) {
		Cdss4NsarWarning warning = null;
		if (cdssRequest.getCreatinineClearance() != -1) {
			if (cdssRequest.getCreatinineClearance() < 30) {
				warning = warningClearance;
				warning.setDescription("Sehr wahrscheinliches Nierenversagen. NSAR sollten nicht verschrieben werden, Kreatinin Clearance < 30")
					.setMeasurementValue(Integer.toString(cdssRequest.getCreatinineClearance()))
					.setFailedTest("Kreatinin Clearance < 30 ml/min");
			} else if (cdssRequest.getCreatinineClearance() < 95) {
				warning = warningClearance;
				warning.setDescription("Mögliches Nierenversagen, Kreatinin Clearance < 95")
					.setMeasurementValue(Integer.toString(cdssRequest.getCreatinineClearance()))
					.setFailedTest("Kreatinin Clearance < 95 ml/min");
			} else if(cdssRequest.getCreatinineClearance() < 98) {
				if(Character.toLowerCase(cdssRequest.getSex()) == 'u') {
					warning = warningClearance;
					warning.setDescription("Geschlecht sollte bestimmt werden. Mögliches Nierenversagen, Kreatinin Clearance < 98")
						.setMeasurementValue(Integer.toString(cdssRequest.getCreatinineClearance()))
						.setFailedTest("Kreatinin Clearance < 98 ml/min");
				} else if (Character.toLowerCase(cdssRequest.getSex()) == 'm') {
					warning = warningClearance;
					warning.setDescription("Mögliches Nierenversagen, Kreatinin Clearance < 98")
						.setMeasurementValue(Integer.toString(cdssRequest.getCreatinineClearance()))
						.setFailedTest("Kreatinin Clearance < 98 ml/min");
				}
			}
		}
		if (cdssRequest.getCreatinineSerum() > 1.36) {

			warning = warningSerum;
			warning.setMeasurementValue(Double.toString(cdssRequest.getCreatinineSerum()));
		}
		return warning;
	}

}
