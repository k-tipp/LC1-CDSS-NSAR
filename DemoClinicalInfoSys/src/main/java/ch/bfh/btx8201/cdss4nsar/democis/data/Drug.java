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

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;

@Entity
@Table(name = "drug")
public class Drug implements ICdss4NsarDrug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long drugId;

	private String name;

	private boolean nsar;

	private boolean stereoidal;

	private boolean ppi;
	
	@ManyToMany(mappedBy = "drugList", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Medication> medicationList;

	public Drug() {

	}

	public Drug(String name, boolean nsar, boolean stereoidal, boolean ppi, Set<Medication> medicationList) {
		super();
		this.name = name;
		this.nsar = nsar;
		this.stereoidal = stereoidal;
		this.ppi = ppi;
		this.medicationList = medicationList;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNsar() {
		return nsar;
	}

	public void setNsar(boolean nsar) {
		this.nsar = nsar;
	}

	public boolean isStereoidal() {
		return stereoidal;
	}

	public void setStereoidal(boolean stereoidal) {
		this.stereoidal = stereoidal;
	}

	public boolean isPpi() {
		return ppi;
	}

	public void setPpi(boolean ppi) {
		this.ppi = ppi;
	}

	public Set<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(Set<Medication> medicationList) {
		this.medicationList = medicationList;
	}

	
}
