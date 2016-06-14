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
package ch.bfh.btx8201.cdss4nsar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugImpl.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugImpl {
	
	/** The name. */
	private String name;
	
	/** The is nsar. */
	private boolean isNsar;
	
	/** The is stereoidal. */
	private boolean isStereoidal;
	
	/** The is ppi. */
	private boolean isPPI;

	/**
	 * Instantiates a new drug impl.
	 */
	public DrugImpl() {

	}

	/**
	 * Checks if is nsar.
	 *
	 * @return true, if is nsar
	 */
	public boolean isNsar() {
		return isNsar;
	}

	/**
	 * Sets the nsar.
	 *
	 * @param isNsar the new nsar
	 */
	public void setNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Checks if is stereoidal.
	 *
	 * @return true, if is stereoidal
	 */
	public boolean isStereoidal() {
		return isStereoidal;
	}

	/**
	 * Checks if is ppi.
	 *
	 * @return true, if is ppi
	 */
	public boolean isPPI() {
		return isPPI;
	}

	/**
	 * Sets the checks if is stereoidal.
	 *
	 * @param isStereoidal the new checks if is stereoidal
	 */
	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;
		
	}

	/**
	 * Sets the checks if is ppi.
	 *
	 * @param isPPI the new checks if is ppi
	 */
	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}
}
