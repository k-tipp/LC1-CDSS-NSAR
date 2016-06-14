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
package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Warning.
 */
@Entity
@Table(name = "warning")
public class Warning {
	
	/** The warning id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long warningId;
	
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
	
	/** The request. */
	@ManyToOne
	@JsonBackReference
	private Request request;
	
	/**
	 * Instantiates a new warning.
	 */
	public Warning() {}
	
	/**
	 * Instantiates a new warning.
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
	 * @param request the request
	 */
	public Warning(String name, String description, String measurementValue, String measurementType,
			String measurementUnit, String failedTest, String conflictObjOne, String conflictObjTwo, String alertLevel, Request request) {
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
		this.request = request;
	}
	
	/**
	 * Creates the.
	 *
	 * @return the warning
	 */
	public static Warning create() {
		return new Warning();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name.
	 *
	 * @param name the name
	 * @return the warning
	 */
	public Warning setName(String name) {
		this.name = name;
		return this;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets the description.
	 *
	 * @param description the description
	 * @return the warning
	 */
	public Warning setDescription(String description) {
		this.description = description;
		return this;
	}


	/**
	 * Gets the measurement value.
	 *
	 * @return the measurement value
	 */
	public String getMeasurementValue() {
		return measurementValue;
	}


	/**
	 * Sets the measurement value.
	 *
	 * @param measurementValue the measurement value
	 * @return the warning
	 */
	public Warning setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
		return this;
	}


	/**
	 * Gets the measurement type.
	 *
	 * @return the measurement type
	 */
	public String getMeasurementType() {
		return measurementType;
	}


	/**
	 * Sets the measurement type.
	 *
	 * @param measurementType the measurement type
	 * @return the warning
	 */
	public Warning setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
		return this;
	}


	/**
	 * Gets the measurement unit.
	 *
	 * @return the measurement unit
	 */
	public String getMeasurementUnit() {
		return measurementUnit;
	}


	/**
	 * Sets the measurement unit.
	 *
	 * @param measurementUnit the measurement unit
	 * @return the warning
	 */
	public Warning setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
		return this;
	}

	/**
	 * Gets the failed test.
	 *
	 * @return the failed test
	 */
	public String getFailedTest() {
		return failedTest;
	}

	/**
	 * Sets the failed test.
	 *
	 * @param failedTest the failed test
	 * @return the warning
	 */
	public Warning setFailedTest(String failedTest) {
		this.failedTest = failedTest;
		return this;
	}


	/**
	 * Gets the conflict obj one.
	 *
	 * @return the conflict obj one
	 */
	public String getConflictObjOne() {
		return conflictObjOne;
	}


	/**
	 * Sets the conflict obj one.
	 *
	 * @param conflictObjOne the conflict obj one
	 * @return the warning
	 */
	public Warning setConflictObjOne(String conflictObjOne) {
		this.conflictObjOne = conflictObjOne;
		return this;
	}


	/**
	 * Gets the conflict obj two.
	 *
	 * @return the conflict obj two
	 */
	public String getConflictObjTwo() {
		return conflictObjTwo;
	}


	/**
	 * Sets the conflict obj two.
	 *
	 * @param conflictObjTwo the conflict obj two
	 * @return the warning
	 */
	public Warning setConflictObjTwo(String conflictObjTwo) {
		this.conflictObjTwo = conflictObjTwo;
		return this;
	}


	/**
	 * Gets the alert level.
	 *
	 * @return the alert level
	 */
	public String getAlertLevel() {
		return alertLevel;
	}


	/**
	 * Sets the alert level.
	 *
	 * @param alertLevel the alert level
	 * @return the warning
	 */
	public Warning setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
		return this;
	}

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the new request
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
