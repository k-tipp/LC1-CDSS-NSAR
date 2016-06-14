/*
 * TODO: Insert Description 
 * 
 * No rights are granted except not declinable rights from included
 * projects, libraries etc.
 *
 * @author  Kevin Tippenhauer
 * @author	Martin Stierlin
 * @author	Lukas Wyss
 * @since	SNAPSHOT-1.0.0
 */
package ch.bfh.btx8201.cdss4nsar.validation.spi;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarWarning.
 */
public class Cdss4NsarWarning implements ICdss4NsarWarning{
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The measurement value. */
	private String measurementValue;
	
	/** The measurement type. */
	private String measurementType;
	
	/** The measurement unit. */
	private String measurementUnit;
	
	/** The failed test. */
	private String failedTest;
	
	/** The conflict obj one. */
	private String conflictObjOne;
	
	/** The conflict obj two. */
	private String conflictObjTwo;
	
	/** The alert level. */
	private String alertLevel;
	
	/**
	 * Instantiates a new cdss4 nsar warning.
	 */
	public Cdss4NsarWarning() {}
	
	/**
	 * Instantiates a new cdss4 nsar warning.
	 *
	 * @param name the name
	 * @param description the description
	 * @param measurementValue the measurement value
	 * @param measurementType the measurement type
	 * @param measurementUnit the measurement unit
	 * @param failedTest the failed test
	 * @param conflictObjOne the conflict obj one
	 * @param conflictObjTwo the conflict obj two
	 * @param alertLevel the alert level
	 */
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
	
	/**
	 * Creates the.
	 *
	 * @return the cdss4 nsar warning
	 */
	public static Cdss4NsarWarning create() {
		return new Cdss4NsarWarning();
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setName(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setName(String name) {
		this.name = name;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setDescription(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setDescription(String description) {
		this.description = description;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getMeasurementValue()
	 */
	@Override
	public String getMeasurementValue() {
		return measurementValue;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setMeasurementValue(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getMeasurementType()
	 */
	@Override
	public String getMeasurementType() {
		return measurementType;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setMeasurementType(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getMeasurementUnit()
	 */
	@Override
	public String getMeasurementUnit() {
		return measurementUnit;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setMeasurementUnit(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getFailedTest()
	 */
	@Override
	public String getFailedTest() {
		return failedTest;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setFailedTest(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setFailedTest(String failedTest) {
		this.failedTest = failedTest;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getConflictObjOne()
	 */
	@Override
	public String getConflictObjOne() {
		return conflictObjOne;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setConflictObjOne(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setConflictObjOne(String conflictObjOne) {
		this.conflictObjOne = conflictObjOne;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getConflictObjTwo()
	 */
	@Override
	public String getConflictObjTwo() {
		return conflictObjTwo;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setConflictObjTwo(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setConflictObjTwo(String conflictObjTwo) {
		this.conflictObjTwo = conflictObjTwo;
		return this;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#getAlertLevel()
	 */
	@Override
	public String getAlertLevel() {
		return alertLevel;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarWarning#setAlertLevel(java.lang.String)
	 */
	@Override
	public Cdss4NsarWarning setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
		return this;
	}
}
