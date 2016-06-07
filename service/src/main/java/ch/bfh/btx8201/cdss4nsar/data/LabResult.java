package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor;

@Entity
@Table(name = "labresult")
public class LabResult implements ICdss4NsarLabor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long labResultId;
	
	@ManyToOne
	@JsonBackReference
	private Request request;

	@NotNull
	private String type;

	@NotNull
	private String value;

	@NotNull
	private String measuringSize;

	public LabResult() {

	}

	public LabResult(long labResultId, Request request, String type, String value, String measuringSize) {
		super();
		this.labResultId = labResultId;
		this.request = request;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
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
