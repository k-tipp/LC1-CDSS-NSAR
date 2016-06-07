package ch.bfh.btx8201.cdss4nsar.validation.spi;

import java.util.List;
import java.util.Set;

public interface ICdss4NsarRequest {
	public char getSex();

	public void setSex(char sex);

	public boolean isPregnant();

	public void isPregnant(boolean pregnant);

	public int getAge();

	public void setAge(int age);

	public Set<Cdss4NsarDrug> getDrugs();

	public void setDrugs(Set<Cdss4NsarDrug> patDrugs);

	public List<String> getAllergies();

	public void setAllergies(List<String> allergies);

	public Set<Cdss4NsarLabor> getLabResults();

	public void setLabResults(Set<Cdss4NsarLabor> patLabor);
}
