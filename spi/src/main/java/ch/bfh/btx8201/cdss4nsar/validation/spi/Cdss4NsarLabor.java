package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarLabor implements ICdss4NsarLabor {

	private String type;

	private String value;

	private String measuringSize;


	public Cdss4NsarLabor() {
		super();
	}

	public Cdss4NsarLabor(String type, String value, String measuringSize) {
		super();
		this.type = type;
		this.value = value;
		this.measuringSize = measuringSize;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getMeasuringSize() {
		return measuringSize;
	}

	@Override
	public void setMeasuringSize(String measuringSize) {
		this.measuringSize = measuringSize;
	}
}
