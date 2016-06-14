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

import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarResponse.
 */
public class Cdss4NsarResponse implements ICdss4NsarResponse{
	
	/** The warnings. */
	Set<Cdss4NsarWarning> warnings;
	
	/**
	 * Instantiates a new cdss4 nsar response.
	 */
	public Cdss4NsarResponse() {}
	
	/**
	 * Instantiates a new cdss4 nsar response.
	 *
	 * @param warnings the warnings
	 */
	public Cdss4NsarResponse(Set<Cdss4NsarWarning> warnings) {
		super();
		this.warnings = warnings;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarResponse#getWarnings()
	 */
	@Override
	public Set<Cdss4NsarWarning> getWarnings() {
		return warnings;
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarResponse#setWarnings()
	 */
	@Override
	public Set<Cdss4NsarWarning> setWarnings() {
		return warnings;
	}
}
