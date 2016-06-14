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
 * The Interface ICdss4NsarResponse.
 */
public interface ICdss4NsarResponse {

	/**
	 * Gets the warnings.
	 *
	 * @return the warnings
	 */
	public Set<Cdss4NsarWarning> getWarnings();
	
	/**
	 * Sets the warnings.
	 *
	 * @return the sets the
	 */
	public Set<Cdss4NsarWarning> setWarnings();
}
