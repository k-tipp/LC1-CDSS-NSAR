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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;

// TODO: Auto-generated Javadoc
/**
 * The Class Drug.
 */
@Entity
@Table(name = "drug")
public class Drug implements ICdss4NsarDrug {

	/** The drug id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long drugId;

	/** The name. */
	private String name;

	/** The nsar. */
	private boolean nsar;

	/** The stereoidal. */
	private boolean stereoidal;

	/** The ppi. */
	private boolean ppi;
	
	/** The medication list. */
	@ManyToMany(mappedBy = "drugList", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Medication> medicationList;

	/**
	 * Instantiates a new drug.
	 */
	public Drug() {

	}

	/**
	 * Instantiates a new drug.
	 *
	 * @param name the name
	 * @param nsar the nsar
	 * @param stereoidal the stereoidal
	 * @param ppi the ppi
	 * @param medicationList the medication list
	 */
	public Drug(String name, boolean nsar, boolean stereoidal, boolean ppi, Set<Medication> medicationList) {
		super();
		this.name = name;
		this.nsar = nsar;
		this.stereoidal = stereoidal;
		this.ppi = ppi;
		this.medicationList = medicationList;
	}

	/**
	 * Gets the drug id.
	 *
	 * @return the drug id
	 */
	public long getDrugId() {
		return drugId;
	}

	/**
	 * Sets the drug id.
	 *
	 * @param drugId the new drug id
	 */
	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isNsar()
	 */
	public boolean isNsar() {
		return nsar;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setNsar(boolean)
	 */
	public void setNsar(boolean nsar) {
		this.nsar = nsar;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isStereoidal()
	 */
	public boolean isStereoidal() {
		return stereoidal;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setStereoidal(boolean)
	 */
	public void setStereoidal(boolean stereoidal) {
		this.stereoidal = stereoidal;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isPpi()
	 */
	public boolean isPpi() {
		return ppi;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setPpi(boolean)
	 */
	public void setPpi(boolean ppi) {
		this.ppi = ppi;
	}

	/**
	 * Gets the medication list.
	 *
	 * @return the medication list
	 */
	public Set<Medication> getMedicationList() {
		return medicationList;
	}

	/**
	 * Sets the medication list.
	 *
	 * @param medicationList the new medication list
	 */
	public void setMedicationList(Set<Medication> medicationList) {
		this.medicationList = medicationList;
	}

	
}
