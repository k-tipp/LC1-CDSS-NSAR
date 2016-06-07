package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarRequest;

@Entity
@Table(name = "request")
public class Request implements ICdss4NsarRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;

	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<LabResult> labResults;
	
	@OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Drug> drugs;

	public Request() {
		super();
	}

	public Request(long requestId, Set<LabResult> labResults, Set<Drug> drugs) {
		super();
		this.requestId = requestId;
		this.labResults = labResults;
		this.drugs = drugs;
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

	@Override
	public char getSex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSex(char sex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPregnant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isPregnant(boolean pregnant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDrugs(Set<Cdss4NsarDrug> patDrugs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAllergies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllergies(List<String> allergies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLabResults(Set<Cdss4NsarLabor> patLabor) {
		// TODO Auto-generated method stub
		
	}
	
	
}
