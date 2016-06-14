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

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Request.
 */
@Entity
@Table(name = "request")
public class Request {

	/** The request id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;

	/** The lab results. */
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	/** The drugs. */
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Drug> drugs;
	
	/** The warnings. */
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Warning> warnings;
	
	/** The allergies. */
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Allergy> allergies;
	
	/** The age. */
	private int age;
	
	/** The sex. */
	private char sex;
	
	/** The is pregnant. */
	private boolean isPregnant;

	/**
	 * Instantiates a new request.
	 */
	public Request() {
		super();
	}


	/**
	 * Instantiates a new request.
	 *
	 * @param labResults the lab results
	 * @param drugs the drugs
	 * @param warnings the warnings
	 * @param allergies the allergies
	 * @param age the age
	 * @param sex the sex
	 * @param isPregnant the is pregnant
	 */
	public Request(Set<LabResult> labResults, Set<Drug> drugs, Set<Warning> warnings, Set<Allergy> allergies, int age,
			char sex, boolean isPregnant) {
		super();
		this.labResults = labResults;
		this.drugs = drugs;
		this.warnings = warnings;
		this.allergies = allergies;
		this.age = age;
		this.sex = sex;
		this.isPregnant = isPregnant;
	}

	/**
	 * Gets the request id.
	 *
	 * @return the request id
	 */
	public long getRequestId() {
		return requestId;
	}

	/**
	 * Sets the request id.
	 *
	 * @param requestId the new request id
	 */
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	/**
	 * Gets the lab results.
	 *
	 * @return the lab results
	 */
	public Set<LabResult> getLabResults() {
		return labResults;
	}

	/**
	 * Sets the lab results.
	 *
	 * @param labResults the new lab results
	 */
	public void setLabResults(Set<LabResult> labResults) {
		this.labResults = labResults;
	}

	/**
	 * Gets the drugs.
	 *
	 * @return the drugs
	 */
	public Set<Drug> getDrugs() {
		return drugs;
	}

	/**
	 * Sets the drugs.
	 *
	 * @param drugs the new drugs
	 */
	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/**
	 * Gets the warnings.
	 *
	 * @return the warnings
	 */
	public Set<Warning> getWarnings() {
		return warnings;
	}

	/**
	 * Sets the warnings.
	 *
	 * @param warnings the new warnings
	 */
	public void setWarnings(Set<Warning> warnings) {
		this.warnings = warnings;
	}
	
	/**
	 * Gets the allergies.
	 *
	 * @return the allergies
	 */
	public Set<Allergy> getAllergies() {
		return allergies;
	}

	/**
	 * Sets the allergies.
	 *
	 * @param allergies the new allergies
	 */
	public void setAllergies(Set<Allergy> allergies) {
		this.allergies = allergies;
	}

	/**
	 * Checks if is pregnant.
	 *
	 * @return true, if is pregnant
	 */
	public boolean isPregnant() {
		return isPregnant;
	}
	
	/**
	 * Sets the pregnant.
	 *
	 * @param isPregnant the new pregnant
	 */
	public void setPregnant(boolean isPregnant) {
		this.isPregnant = isPregnant;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", labResults=" + labResults + ", drugs=" + drugs + ", warnings="
				+ warnings + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
