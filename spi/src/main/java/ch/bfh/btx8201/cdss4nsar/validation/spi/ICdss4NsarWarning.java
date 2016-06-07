package ch.bfh.btx8201.cdss4nsar.validation.spi;

public interface ICdss4NsarWarning {

	public String getName();

	public Cdss4NsarWarning setName(String name);

	public String getDescription();

	public Cdss4NsarWarning setDescription(String description);

	public String getMeasurementValue();

	public Cdss4NsarWarning setMeasurementValue(String measurementValue);

	public String getMeasurementType();

	public Cdss4NsarWarning setMeasurementType(String measurementType);

	public String getMeasurementUnit();

	public Cdss4NsarWarning setMeasurementUnit(String measurementUnit);

	public String getFailedTest();

	public Cdss4NsarWarning setFailedTest(String failedTest);

	public String getConflictObjOne();

	public Cdss4NsarWarning setConflictObjOne(String conflictObjOne);

	public String getConflictObjTwo();

	public Cdss4NsarWarning setConflictObjTwo(String conflictObjTwo);

	public String getAlertLevel();

	public Cdss4NsarWarning setAlertLevel(String alertLevel);
}
