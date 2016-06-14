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
package ch.bfh.btx8201.cdss4nsar.democis.domain;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CdssRequestForm.
 */
public class CdssRequestForm {

	/** The patient id. */
	private int patientId;
	
	/** The pat age. */
	private int patAge;
	
	/** The pat sex. */
	private String patSex = "";
	
	/** The pregnant. */
	private String pregnant = "";
	
	/** The allergies. */
	private List<String> allergies = new ArrayList<String>();
	
	/** The add drug. */
	private List<String> addDrug = new ArrayList<String>();
	
	/**
	 * Instantiates a new cdss request form.
	 */
	public CdssRequestForm() {}
	
	/**
	 * Instantiates a new cdss request form.
	 *
	 * @param patientId the patient id
	 * @param patAge the pat age
	 * @param patSex the pat sex
	 * @param pregnant the pregnant
	 * @param allergies the allergies
	 * @param addDrug the add drug
	 */
	public CdssRequestForm(int patientId, int patAge, String patSex, String pregnant, List<String> allergies,
			List<String> addDrug) {
		super();
		this.patientId = patientId;
		this.patAge = patAge;
		this.patSex = patSex;
		this.pregnant = pregnant;
		this.allergies = allergies;
		this.addDrug = addDrug;
	}
	
	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public int getPatientId() {
		return patientId;
	}
	
	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * Gets the pat age.
	 *
	 * @return the pat age
	 */
	public int getPatAge() {
		return patAge;
	}
	
	/**
	 * Sets the pat age.
	 *
	 * @param patAge the new pat age
	 */
	public void setPatAge(int patAge) {
		this.patAge = patAge;
	}
	
	/**
	 * Gets the pat sex.
	 *
	 * @return the pat sex
	 */
	public String getPatSex() {
		return patSex;
	}
	
	/**
	 * Sets the pat sex.
	 *
	 * @param patSex the new pat sex
	 */
	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}
	
	/**
	 * Gets the pregnant.
	 *
	 * @return the pregnant
	 */
	public String getPregnant() {
		return pregnant;
	}
	
	/**
	 * Sets the pregnant.
	 *
	 * @param pregnant the new pregnant
	 */
	public void setPregnant(String pregnant) {
		this.pregnant = pregnant;
	}
	
	/**
	 * Gets the allergies.
	 *
	 * @return the allergies
	 */
	public List<String> getAllergies() {
		return allergies;
	}
	
	/**
	 * Sets the allergies.
	 *
	 * @param allergies the new allergies
	 */
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	/**
	 * Gets the adds the drug.
	 *
	 * @return the adds the drug
	 */
	public List<String> getAddDrug() {
		return addDrug;
	}

	/**
	 * Sets the adds the drug.
	 *
	 * @param addDrug the new adds the drug
	 */
	public void setAddDrug(List<String> addDrug) {
		this.addDrug = addDrug;
	}
}
