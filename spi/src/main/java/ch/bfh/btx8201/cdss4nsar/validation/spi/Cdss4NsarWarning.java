package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarWarning {
	
	private String name;
	private String description;
	private String measurementValue;
	private String measurementType;
	private String measurementUnit;
	private String failedTest;
	
	public Cdss4NsarWarning() {}

	public Cdss4NsarWarning(String name, String description, String measurementValue, String measurementType,
			String measurementUnit, String failedTest) {
		super();
		this.name = name;
		this.description = description;
		this.measurementValue = measurementValue;
		this.measurementType = measurementType;
		this.measurementUnit = measurementUnit;
		this.failedTest = failedTest;
	}
	
	public static Cdss4NsarWarning create() {
		return new Cdss4NsarWarning();
	}

	public String getName() {
		return name;
	}

	public Cdss4NsarWarning setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Cdss4NsarWarning setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getMeasurementValue() {
		return measurementValue;
	}

	public Cdss4NsarWarning setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
		return this;
	}

	public String getMeasurementType() {
		return measurementType;
	}

	public Cdss4NsarWarning setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
		return this;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public Cdss4NsarWarning setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
		return this;
	}

	public String getFailedTest() {
		return failedTest;
	}

	public Cdss4NsarWarning setFailedTest(String failedTest) {
		this.failedTest = failedTest;
		return this;
	}
}
