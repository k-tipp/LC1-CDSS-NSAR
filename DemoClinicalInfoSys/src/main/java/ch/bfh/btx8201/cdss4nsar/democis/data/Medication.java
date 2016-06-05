package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

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

@Entity
@Table(name = "medication")
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long medicationId;
	
	@ManyToOne
	private Patient patient;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="medication_drug",
            joinColumns=
            @JoinColumn(name="medicationId", referencedColumnName="medicationId"),
      inverseJoinColumns=
            @JoinColumn(name="drugId", referencedColumnName="drugId")
    )
	private List<Drug> drugList;

	public Medication() {}
	
	public Medication(long medicationId, Patient patient, List<Drug> drugList) {
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

	public List<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<Drug> drugList) {
		this.drugList = drugList;
	}
	
	

	
}
