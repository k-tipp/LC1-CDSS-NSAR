package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarLaborImpl {

	private String type;

	private String value;

	private String measuringSize;


	public Cdss4NsarLaborImpl() {
		super();
	}

	public Cdss4NsarLaborImpl(String type, String value, String measuringSize) {
		super();
		this.type = type;
		this.value = value;
		this.measuringSize = measuringSize;
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
