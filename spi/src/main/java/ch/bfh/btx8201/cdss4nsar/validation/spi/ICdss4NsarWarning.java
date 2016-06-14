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
 * The Interface ICdss4NsarWarning.
 */
public interface ICdss4NsarWarning {

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();

	/**
	 * Sets the name.
	 *
	 * @param name the name
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setName(String name);

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Sets the description.
	 *
	 * @param description the description
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setDescription(String description);

	/**
	 * Gets the measurement value.
	 *
	 * @return the measurement value
	 */
	public String getMeasurementValue();

	/**
	 * Sets the measurement value.
	 *
	 * @param measurementValue the measurement value
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setMeasurementValue(String measurementValue);

	/**
	 * Gets the measurement type.
	 *
	 * @return the measurement type
	 */
	public String getMeasurementType();

	/**
	 * Sets the measurement type.
	 *
	 * @param measurementType the measurement type
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setMeasurementType(String measurementType);

	/**
	 * Gets the measurement unit.
	 *
	 * @return the measurement unit
	 */
	public String getMeasurementUnit();

	/**
	 * Sets the measurement unit.
	 *
	 * @param measurementUnit the measurement unit
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setMeasurementUnit(String measurementUnit);

	/**
	 * Gets the failed test.
	 *
	 * @return the failed test
	 */
	public String getFailedTest();

	/**
	 * Sets the failed test.
	 *
	 * @param failedTest the failed test
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setFailedTest(String failedTest);

	/**
	 * Gets the conflict obj one.
	 *
	 * @return the conflict obj one
	 */
	public String getConflictObjOne();

	/**
	 * Sets the conflict obj one.
	 *
	 * @param conflictObjOne the conflict obj one
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setConflictObjOne(String conflictObjOne);

	/**
	 * Gets the conflict obj two.
	 *
	 * @return the conflict obj two
	 */
	public String getConflictObjTwo();

	/**
	 * Sets the conflict obj two.
	 *
	 * @param conflictObjTwo the conflict obj two
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setConflictObjTwo(String conflictObjTwo);

	/**
	 * Gets the alert level.
	 *
	 * @return the alert level
	 */
	public String getAlertLevel();

	/**
	 * Sets the alert level.
	 *
	 * @param alertLevel the alert level
	 * @return the cdss4 nsar warning
	 */
	public Cdss4NsarWarning setAlertLevel(String alertLevel);
}
