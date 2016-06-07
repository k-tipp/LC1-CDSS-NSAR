package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;
import java.util.Set;

public class Cdss4NsarRequest {
	
	//Person
	private char sex = 'u';
	private boolean pregnant = false;
	private int age = -1;
	private List<String> allergies;
	private Set<Cdss4NsarDrug> drugs;
	private Set<Cdss4NsarLabor> labResults;
	
	
	public Cdss4NsarRequest(){
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void isPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Cdss4NsarDrug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Cdss4NsarDrug> patDrugs) {
		this.drugs = patDrugs;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public Set<Cdss4NsarLabor> getLabResults() {
		return labResults;
	}

	public void setLabResults(Set<Cdss4NsarLabor> labResults) {
		this.labResults = labResults;
	}

}
