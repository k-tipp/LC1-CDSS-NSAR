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
package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	
	/** The request. */
	@ManyToOne
	@JsonBackReference
	private Request request;

	/**
	 * Instantiates a new allergy.
	 */
	public Allergy() {

	}

	/**
	 * Instantiates a new allergy.
	 *
	 * @param request the request
	 * @param name the name
	 */
	public Allergy(Request request, String name) {
		super();
		this.name = name;
		this.request = request;
	}

	/**
	 * Gets the alletgy id.
	 *
	 * @return the alletgy id
	 */
	public long getAlletgyId() {
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

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the new request
	 */
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
