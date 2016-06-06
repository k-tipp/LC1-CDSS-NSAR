package ch.bfh.btx8201.cdss4nsar.democis.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;

@Entity
@Table(name = "labresult")
public class LabResult implements Cdss4NsarLabor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long labResultId;
	
	@ManyToOne
	private Patient patient;

	@NotNull
	private String type;

	@NotNull
	private String value;

	@NotNull
	private String measuringSize;

	public LabResult() {

	}

	public LabResult(long labResultId, Patient patient, String type, String value, String measuringSize) {
		super();
		this.labResultId = labResultId;
		this.patient = patient;
		this.type = type;
		this.value = value;
		this.measuringSize = measuringSize;
	}

	public long getLabResultId() {
		return labResultId;
	}

	public void setLabResultId(long labResultId) {
		this.labResultId = labResultId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMeasuringSize() {
		return measuringSize;
	}

	public void setMeasuringSize(String measuringSize) {
		this.measuringSize = measuringSize;
	}
}
