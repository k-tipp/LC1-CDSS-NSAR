package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

	@OneToMany(mappedBy = "patient")
	private List<LabResult> labResults;

	public Patient() {

	}

	public Patient(long patientId, String lastname, String firstname, List<LabResult> labResults) {
		super();
		this.patientId = patientId;
		this.lastname = lastname;
		this.firstname = firstname;
		this.labResults = labResults;
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

	public List<LabResult> getLabResults() {
		return labResults;
	}

	public void setLabResults(List<LabResult> labResults) {
		this.labResults = labResults;
	}
}
