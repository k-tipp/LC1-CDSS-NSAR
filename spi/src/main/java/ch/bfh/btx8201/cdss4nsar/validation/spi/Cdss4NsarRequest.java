package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;
import java.util.Set;

public class Cdss4NsarRequest implements ICdss4NsarRequest {
	
	//Person
	private char sex = 'u';
	private boolean pregnant = false;
	private int age = -1;
	private List<String> allergies;
	private Set<Cdss4NsarDrug> drugs;
	private Set<Cdss4NsarLabor> labResults;
	
	public Cdss4NsarRequest(){
	}

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
	
	@Override
	public char getSex() {
		return sex;
	}

	@Override
	public void setSex(char sex) {
		this.sex = sex;
	}

	@Override
	public boolean isPregnant() {
		return pregnant;
	}

	@Override
	public void isPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public Set<Cdss4NsarDrug> getDrugs() {
		return drugs;
	}

	@Override
	public void setDrugs(Set<Cdss4NsarDrug> patDrugs) {
		this.drugs = patDrugs;
	}

	@Override
	public List<String> getAllergies() {
		return allergies;
	}

	@Override
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	@Override
	public Set<Cdss4NsarLabor> getLabResults() {
		return labResults;
	}
	
	@Override
	public void setLabResults(Set<Cdss4NsarLabor> patLabor) {
		this.labResults = patLabor;
	}
}
