package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarWarning implements ICdss4NsarWarning{
	
	private String name;
	private String description;
	private String measurementValue;
	private String measurementType;
	private String measurementUnit;
	private String failedTest;
	private String conflictObjOne;
	private String conflictObjTwo;
	private String alertLevel;
	
	public Cdss4NsarWarning() {}
	
	public Cdss4NsarWarning(String name, String description, String measurementValue, String measurementType,
			String measurementUnit, String failedTest, String conflictObjOne, String conflictObjTwo, String alertLevel) {
		super();
		this.name = name;
		this.description = description;
		this.measurementValue = measurementValue;
		this.measurementType = measurementType;
		this.measurementUnit = measurementUnit;
		this.failedTest = failedTest;
		this.conflictObjOne = conflictObjOne;
		this.conflictObjTwo = conflictObjTwo;
		this.alertLevel = alertLevel;
	}
	
	public static Cdss4NsarWarning create() {
		return new Cdss4NsarWarning();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Cdss4NsarWarning setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Cdss4NsarWarning setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String getMeasurementValue() {
		return measurementValue;
	}

	@Override
	public Cdss4NsarWarning setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
		return this;
	}

	@Override
	public String getMeasurementType() {
		return measurementType;
	}

	@Override
	public Cdss4NsarWarning setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
		return this;
	}

	@Override
	public String getMeasurementUnit() {
		return measurementUnit;
	}

	@Override
	public Cdss4NsarWarning setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
		return this;
	}

	@Override
	public String getFailedTest() {
		return failedTest;
	}

	@Override
	public Cdss4NsarWarning setFailedTest(String failedTest) {
		this.failedTest = failedTest;
		return this;
	}

	@Override
	public String getConflictObjOne() {
		return conflictObjOne;
	}

	@Override
	public Cdss4NsarWarning setConflictObjOne(String conflictObjOne) {
		this.conflictObjOne = conflictObjOne;
		return this;
	}

	@Override
	public String getConflictObjTwo() {
		return conflictObjTwo;
	}

	@Override
	public Cdss4NsarWarning setConflictObjTwo(String conflictObjTwo) {
		this.conflictObjTwo = conflictObjTwo;
		return this;
	}

	@Override
	public String getAlertLevel() {
		return alertLevel;
	}

	@Override
	public Cdss4NsarWarning setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
		return this;
	}
}
