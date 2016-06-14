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

import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICdss4NsarRequest.
 */
public interface ICdss4NsarRequest {
	
	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public char getSex();

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(char sex);

	/**
	 * Checks if is pregnant.
	 *
	 * @return true, if is pregnant
	 */
	public boolean isPregnant();

	/**
	 * Checks if is pregnant.
	 *
	 * @param pregnant the pregnant
	 */
	public void isPregnant(boolean pregnant);

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge();

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age);

	/**
	 * Gets the drugs.
	 *
	 * @return the drugs
	 */
	public Set<Cdss4NsarDrug> getDrugs();

	/**
	 * Sets the drugs.
	 *
	 * @param patDrugs the new drugs
	 */
	public void setDrugs(Set<Cdss4NsarDrug> patDrugs);

	/**
	 * Gets the allergies.
	 *
	 * @return the allergies
	 */
	public List<String> getAllergies();

	/**
	 * Sets the allergies.
	 *
	 * @param allergies the new allergies
	 */
	public void setAllergies(List<String> allergies);

	/**
	 * Gets the lab results.
	 *
	 * @return the lab results
	 */
	public Set<Cdss4NsarLabor> getLabResults();

	/**
	 * Sets the lab results.
	 *
	 * @param patLabor the new lab results
	 */
	public void setLabResults(Set<Cdss4NsarLabor> patLabor);
}
