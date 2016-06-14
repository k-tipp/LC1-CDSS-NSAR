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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy;

// TODO: Auto-generated Javadoc
/**
 * The Class Allergy.
 */
@Entity
@Table(name = "allergy")
public class Allergy implements ICdss4NsarAllergy {

	/** The allergy id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long allergyId;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new allergy.
	 */
	public Allergy() {

	}

	/**
	 * Instantiates a new allergy.
	 *
	 * @param allergyId the allergy id
	 * @param name the name
	 */
	public Allergy(long allergyId, String name) {
		super();
		this.allergyId = allergyId;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the allergy id.
	 *
	 * @return the allergy id
	 */
	public long getAllergyId() {
		return allergyId;
	}

	/**
	 * Sets the allergy id.
	 *
	 * @param allergyId the new allergy id
	 */
	public void setAllergyId(long allergyId) {
		this.allergyId = allergyId;
	}
}
