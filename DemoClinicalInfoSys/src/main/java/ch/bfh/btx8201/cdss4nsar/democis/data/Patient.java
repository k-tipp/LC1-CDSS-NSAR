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

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;

	@NotNull
	private String lastname;

	@NotNull
	private String firstname;

	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Medication> medications;

	public Patient() {

	}

	public Patient(long patientId, String lastname, String firstname, Set<LabResult> labResults,
			Set<Medication> medications) {
		super();
		this.patientId = patientId;
		this.lastname = lastname;
		this.firstname = firstname;
		this.labResults = labResults;
		this.medications = medications;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Set<LabResult> getLabResults() {
		return labResults;
	}

	public void setLabResults(Set<LabResult> labResults) {
		this.labResults = labResults;
	}

	public Set<Medication> getMedications() {
		return medications;
	}

	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}
}
