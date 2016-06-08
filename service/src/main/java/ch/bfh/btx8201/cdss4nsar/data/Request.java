package ch.bfh.btx8201.cdss4nsar.data;

import java.util.Set;

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

	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Drug> drugs;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Warning> warnings;
	
	private int age;
	
	private char sex;

	public Request() {
		super();
	}

	public Request(Set<LabResult> labResults, Set<Drug> drugs, Set<Warning> warnings, int age, char sex) {
		super();
		this.labResults = labResults;
		this.drugs = drugs;
		this.age = age;
		this.sex = sex;
		this.warnings = warnings;
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

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", labResults=" + labResults + ", drugs=" + drugs + ", warnings="
				+ warnings + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
