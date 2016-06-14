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
 * The Interface ICdss4NsarDrug.
 */
public interface ICdss4NsarDrug {
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name);
	
	/**
	 * Checks if is nsar.
	 *
	 * @return true, if is nsar
	 */
	public boolean isNsar();
	
	/**
	 * Sets the nsar.
	 *
	 * @param nsar the new nsar
	 */
	public void setNsar(boolean nsar);
	
	/**
	 * Checks if is stereoidal.
	 *
	 * @return true, if is stereoidal
	 */
	public boolean isStereoidal();
	
	/**
	 * Sets the stereoidal.
	 *
	 * @param stereoidal the new stereoidal
	 */
	public void setStereoidal(boolean stereoidal);
	
	/**
	 * Checks if is ppi.
	 *
	 * @return true, if is ppi
	 */
	public boolean isPpi();
	
	/**
	 * Sets the ppi.
	 *
	 * @param ppi the new ppi
	 */
	public void setPpi(boolean ppi);
}
