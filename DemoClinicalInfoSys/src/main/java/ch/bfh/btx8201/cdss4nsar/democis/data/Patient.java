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

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Patient.
 */
@Entity
@Table(name = "patient")
public class Patient {

	/** The patient id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;

	/** The lastname. */
	@NotNull
	private String lastname;

	/** The firstname. */
	@NotNull
	private String firstname;

	/** The lab results. */
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	/** The medications. */
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Medication> medications;

	/**
	 * Instantiates a new patient.
	 */
	public Patient() {

	}

	/**
	 * Instantiates a new patient.
	 *
	 * @param patientId the patient id
	 * @param lastname the lastname
	 * @param firstname the firstname
	 * @param labResults the lab results
	 * @param medications the medications
	 */
	public Patient(long patientId, String lastname, String firstname, Set<LabResult> labResults,
			Set<Medication> medications) {
		super();
		this.patientId = patientId;
		this.lastname = lastname;
		this.firstname = firstname;
		this.labResults = labResults;
		this.medications = medications;
	}

	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public long getPatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lab results.
	 *
	 * @return the lab results
	 */
	public Set<LabResult> getLabResults() {
		return labResults;
	}

	/**
	 * Sets the lab results.
	 *
	 * @param labResults the new lab results
	 */
	public void setLabResults(Set<LabResult> labResults) {
		this.labResults = labResults;
	}

	/**
	 * Gets the medications.
	 *
	 * @return the medications
	 */
	public Set<Medication> getMedications() {
		return medications;
	}

	/**
	 * Sets the medications.
	 *
	 * @param medications the new medications
	 */
	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}
}
