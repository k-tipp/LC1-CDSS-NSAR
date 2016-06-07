package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;

@Entity
@Table(name = "drug")
public class Drug implements Cdss4NsarDrug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long drugId;

	private String name;

	private boolean isNsar;

	private boolean isStereoidal;

	private boolean isPPI;
	
	@ManyToMany(mappedBy = "drugList", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Medication> medicationList;

	public Drug() {

	}

	public Drug(long drugId, String name, boolean isNsar, Set<Medication> medicationList) {
		super();
		this.drugId = drugId;
		this.name = name;
		this.isNsar = isNsar;
		this.medicationList = medicationList;
	}

	public boolean isNsar() {
		return isNsar;
	}

	public void setIsNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(Set<Medication> medicationList) {
		this.medicationList = medicationList;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public boolean isStereoidal() {
		return isStereoidal;
	}

	public boolean isPPI() {
		return isPPI;
	}

	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;

	}

	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}
}
