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

@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;

	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Drug> drugs;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Warning> warnings;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Allergy> allergies;
	
	private int age;
	
	private char sex;
	
	private boolean isPregnant;

	public Request() {
		super();
	}


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

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Set<LabResult> getLabResults() {
		return labResults;
	}

	public void setLabResults(Set<LabResult> labResults) {
		this.labResults = labResults;
	}

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Set<Warning> getWarnings() {
		return warnings;
	}

	public void setWarnings(Set<Warning> warnings) {
		this.warnings = warnings;
	}
	
	public Set<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(Set<Allergy> allergies) {
		this.allergies = allergies;
	}

	public boolean isPregnant() {
		return isPregnant;
	}
	
	public void setPregnant(boolean isPregnant) {
		this.isPregnant = isPregnant;
	}



	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", labResults=" + labResults + ", drugs=" + drugs + ", warnings="
				+ warnings + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
