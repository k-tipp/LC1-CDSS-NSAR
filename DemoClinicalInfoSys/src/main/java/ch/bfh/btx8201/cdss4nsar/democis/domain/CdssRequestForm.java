package ch.bfh.btx8201.cdss4nsar.democis.domain;

import java.util.List;

import ch.bfh.btx8201.cdss4nsar.democis.data.LabResult;

public class CdssRequestForm {

	int patientId;
	int patAge;
	String patSex;
	boolean isPregnant;
	List<String> patAllergics;
	List<String> patDrug;
	List<LabResult> labResults;
	public CdssRequestForm(int patientId, int patAge, String patSex, boolean isPregnant, List<String> patAllergics,
			List<String> patDrug, List<LabResult> labResults) {
		super();
		this.patientId = patientId;
		this.patAge = patAge;
		this.patSex = patSex;
		this.isPregnant = isPregnant;
		this.patAllergics = patAllergics;
		this.patDrug = patDrug;
		this.labResults = labResults;
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
	public boolean isPregnant() {
		return isPregnant;
	}
	public void setPregnant(boolean isPregnant) {
		this.isPregnant = isPregnant;
	}
	public List<String> getPatAllergics() {
		return patAllergics;
	}
	public void setPatAllergics(List<String> patAllergics) {
		this.patAllergics = patAllergics;
	}
	public List<String> getPatDrug() {
		return patDrug;
	}
	public void setPatDrug(List<String> patDrug) {
		this.patDrug = patDrug;
	}
	public List<LabResult> getLabResults() {
		return labResults;
	}
	public void setLabResults(List<LabResult> labResults) {
		this.labResults = labResults;
	}
	
	
}
