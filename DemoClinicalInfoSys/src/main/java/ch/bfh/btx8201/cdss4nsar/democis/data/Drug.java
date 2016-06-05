package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	@ManyToMany(mappedBy="drugList",fetch=FetchType.EAGER)
    private List<Medication> medicationList;

	public Drug() {

	}

	public Drug(long drugId, String name, boolean isNsar, List<Medication> medicationList) {
		super();
		this.drugId = drugId;
		this.name = name;
		this.isNsar = isNsar;
		this.medicationList = medicationList;
	}

	@Override
	public boolean isNsar() {
		return isNsar;
	}

	@Override
	public void setNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
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
