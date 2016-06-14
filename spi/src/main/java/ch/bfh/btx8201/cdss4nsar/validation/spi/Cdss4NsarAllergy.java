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
package ch.bfh.btx8201.cdss4nsar.validation.spi;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarAllergy.
 */
public class Cdss4NsarAllergy implements ICdss4NsarAllergy {

	/** The name. */
	private String name;

	/**
	 * Instantiates a new cdss4 nsar allergy.
	 */
	public Cdss4NsarAllergy() {
		super();
	}

	/**
	 * Instantiates a new cdss4 nsar allergy.
	 *
	 * @param name the name
	 */
	public Cdss4NsarAllergy(String name) {
		super();
		this.name = name;
		
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


}
