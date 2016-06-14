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
 * The Class Cdss4NsarRequest.
 */
public class Cdss4NsarRequest implements ICdss4NsarRequest {
	
	/** The sex. */
	//Person
	private char sex = 'u';
	
	/** The pregnant. */
	private boolean pregnant = false;
	
	/** The age. */
	private int age = -1;
	
	/** The allergies. */
	private List<String> allergies;
	
	/** The drugs. */
	private Set<Cdss4NsarDrug> drugs;
	
	/** The lab results. */
	private Set<Cdss4NsarLabor> labResults;
	
	/**
	 * Instantiates a new cdss4 nsar request.
	 */
	public Cdss4NsarRequest(){
	}

	/**
	 * Instantiates a new cdss4 nsar request.
	 *
	 * @param sex the sex
	 * @param pregnant the pregnant
	 * @param age the age
	 * @param allergies the allergies
	 * @param drugs the drugs
	 * @param labResults the lab results
	 */
	public Cdss4NsarRequest(char sex, boolean pregnant, int age, List<String> allergies, Set<Cdss4NsarDrug> drugs,
			Set<Cdss4NsarLabor> labResults) {
		super();
		this.sex = sex;
		this.pregnant = pregnant;
		this.age = age;
		this.allergies = allergies;
		this.drugs = drugs;
		this.labResults = labResults;
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#getSex()
	 */
	@Override
	public char getSex() {
		return sex;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#setSex(char)
	 */
	@Override
	public void setSex(char sex) {
		this.sex = sex;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#isPregnant()
	 */
	@Override
	public boolean isPregnant() {
		return pregnant;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#isPregnant(boolean)
	 */
	@Override
	public void isPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#getAge()
	 */
	@Override
	public int getAge() {
		return age;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#setAge(int)
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#getDrugs()
	 */
	@Override
	public Set<Cdss4NsarDrug> getDrugs() {
		return drugs;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#setDrugs(java.util.Set)
	 */
	@Override
	public void setDrugs(Set<Cdss4NsarDrug> patDrugs) {
		this.drugs = patDrugs;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#getAllergies()
	 */
	@Override
	public List<String> getAllergies() {
		return allergies;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#setAllergies(java.util.List)
	 */
	@Override
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#getLabResults()
	 */
	@Override
	public Set<Cdss4NsarLabor> getLabResults() {
		return labResults;
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest#setLabResults(java.util.Set)
	 */
	@Override
	public void setLabResults(Set<Cdss4NsarLabor> patLabor) {
		this.labResults = patLabor;
	}
}
