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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Medication.
 */
@Entity
@Table(name = "medication")
public class Medication {

	/** The medication id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long medicationId;
	
	/** The patient. */
	@ManyToOne
	@JsonBackReference
	private Patient patient;

    /** The drug list. */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="medication_drug",
            joinColumns=
            @JoinColumn(name="medicationId", referencedColumnName="medicationId"),
      inverseJoinColumns=
            @JoinColumn(name="drugId", referencedColumnName="drugId")
    )
    @JsonManagedReference
	private Set<Drug> drugList;
    
    /** The medication description. */
    private String medicationDescription;

	/**
	 * Instantiates a new medication.
	 */
	public Medication() {}
	
	/**
	 * Instantiates a new medication.
	 *
	 * @param medicationId the medication id
	 * @param patient the patient
	 * @param drugList the drug list
	 */
	public Medication(long medicationId, Patient patient, Set<Drug> drugList) {
		super();
		this.medicationId = medicationId;
		this.patient = patient;
		this.drugList = drugList;
	}

	/**
	 * Gets the medication id.
	 *
	 * @return the medication id
	 */
	public long getMedicationId() {
		return medicationId;
	}

	/**
	 * Sets the medication id.
	 *
	 * @param medicationId the new medication id
	 */
	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
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

	/**
	 * Gets the drug list.
	 *
	 * @return the drug list
	 */
	public Set<Drug> getDrugList() {
		return drugList;
	}

	/**
	 * Sets the drug list.
	 *
	 * @param drugList the new drug list
	 */
	public void setDrugList(Set<Drug> drugList) {
		this.drugList = drugList;
	}

	/**
	 * Gets the medication description.
	 *
	 * @return the medication description
	 */
	public String getMedicationDescription() {
		return medicationDescription;
	}

	/**
	 * Sets the medication description.
	 *
	 * @param medicationDescription the new medication description
	 */
	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}
}
