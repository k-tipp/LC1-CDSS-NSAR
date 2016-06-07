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

@Entity
@Table(name = "medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long medicationId;
	
	@ManyToOne
	@JsonBackReference
	private Patient patient;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="medication_drug",
            joinColumns=
            @JoinColumn(name="medicationId", referencedColumnName="medicationId"),
      inverseJoinColumns=
            @JoinColumn(name="drugId", referencedColumnName="drugId")
    )
    @JsonManagedReference
	private Set<Drug> drugList;
    
    private String medicationDescription;

	public Medication() {}
	
	public Medication(long medicationId, Patient patient, Set<Drug> drugList) {
		super();
		this.medicationId = medicationId;
		this.patient = patient;
		this.drugList = drugList;
	}

	public long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Set<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(Set<Drug> drugList) {
		this.drugList = drugList;
	}

	public String getMedicationDescription() {
		return medicationDescription;
	}

	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}
}
