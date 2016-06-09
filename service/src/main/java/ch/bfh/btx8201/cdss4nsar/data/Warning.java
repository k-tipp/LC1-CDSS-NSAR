package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "warning")
public class Warning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long warningId;
	private String name;
	private String description;
	private String measurementValue;
	private String measurementType;
	private String measurementUnit;
	private String failedTest;
	private String conflictObjOne;
	private String conflictObjTwo;
	private String alertLevel;
	
	@ManyToOne
	@JsonBackReference
	private Request request;
	
	public Warning() {}
	
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
	
	public static Warning create() {
		return new Warning();
	}

	public String getName() {
		return name;
	}


	public Warning setName(String name) {
		this.name = name;
		return this;
	}


	public String getDescription() {
		return description;
	}


	public Warning setDescription(String description) {
		this.description = description;
		return this;
	}


	public String getMeasurementValue() {
		return measurementValue;
	}


	public Warning setMeasurementValue(String measurementValue) {
		this.measurementValue = measurementValue;
		return this;
	}


	public String getMeasurementType() {
		return measurementType;
	}


	public Warning setMeasurementType(String measurementType) {
		this.measurementType = measurementType;
		return this;
	}


	public String getMeasurementUnit() {
		return measurementUnit;
	}


	public Warning setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
		return this;
	}

	public String getFailedTest() {
		return failedTest;
	}

	public Warning setFailedTest(String failedTest) {
		this.failedTest = failedTest;
		return this;
	}


	public String getConflictObjOne() {
		return conflictObjOne;
	}


	public Warning setConflictObjOne(String conflictObjOne) {
		this.conflictObjOne = conflictObjOne;
		return this;
	}


	public String getConflictObjTwo() {
		return conflictObjTwo;
	}


	public Warning setConflictObjTwo(String conflictObjTwo) {
		this.conflictObjTwo = conflictObjTwo;
		return this;
	}


	public String getAlertLevel() {
		return alertLevel;
	}


	public Warning setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
		return this;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
