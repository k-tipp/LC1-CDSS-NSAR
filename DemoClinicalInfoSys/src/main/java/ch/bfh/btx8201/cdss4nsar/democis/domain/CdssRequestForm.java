package ch.bfh.btx8201.cdss4nsar.democis.domain;

import java.util.ArrayList;
import java.util.List;

public class CdssRequestForm {

	private int patientId;
	private int patAge;
	private String patSex = "";
	private String pregnant = "";
	private List<String> allergies = new ArrayList<String>();
	
	public CdssRequestForm() {}
	
	public CdssRequestForm(int patientId, int patAge, String patSex, String pregnant, List<String> allergies) {
		super();
		this.patientId = patientId;
		this.patAge = patAge;
		this.patSex = patSex;
		this.pregnant = pregnant;
		this.allergies = allergies;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getPatAge() {
		return patAge;
	}
	public void setPatAge(int patAge) {
		this.patAge = patAge;
	}
	public String getPatSex() {
		return patSex;
	}
	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}
	public String getPregnant() {
		return pregnant;
	}
	public void setPregnant(String pregnant) {
		this.pregnant = pregnant;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	
	
	
}
