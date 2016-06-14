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
package ch.bfh.btx8201.cdss4nsar.democis.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor;

// TODO: Auto-generated Javadoc
/**
 * The Class LabResult.
 */
@Entity
@Table(name = "labresult")
public class LabResult implements ICdss4NsarLabor {

	/** The lab result id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long labResultId;
	
	/** The patient. */
	@ManyToOne
	@JsonBackReference
	private Patient patient;

	/** The type. */
	@NotNull
	private String type;

	/** The value. */
	@NotNull
	private String value;

	/** The measuring size. */
	@NotNull
	private String measuringSize;

	/**
	 * Instantiates a new lab result.
	 */
	public LabResult() {

	}

	/**
	 * Instantiates a new lab result.
	 *
	 * @param labResultId the lab result id
	 * @param patient the patient
	 * @param type the type
	 * @param value the value
	 * @param measuringSize the measuring size
	 */
	public LabResult(long labResultId, Patient patient, String type, String value, String measuringSize) {
		super();
		this.labResultId = labResultId;
		this.patient = patient;
		this.type = type;
		this.value = value;
		this.measuringSize = measuringSize;
	}

	/**
	 * Gets the lab result id.
	 *
	 * @return the lab result id
	 */
	public long getLabResultId() {
		return labResultId;
	}

	/**
	 * Sets the lab result id.
	 *
	 * @param labResultId the new lab result id
	 */
	public void setLabResultId(long labResultId) {
		this.labResultId = labResultId;
	}

	/**
	 * Gets the patient.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getType()
	 */
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setType(java.lang.String)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getValue()
	 */
	public String getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setValue(java.lang.String)
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getMeasuringSize()
	 */
	public String getMeasuringSize() {
		return measuringSize;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setMeasuringSize(java.lang.String)
	 */
	public void setMeasuringSize(String measuringSize) {
		this.measuringSize = measuringSize;
	}
}
