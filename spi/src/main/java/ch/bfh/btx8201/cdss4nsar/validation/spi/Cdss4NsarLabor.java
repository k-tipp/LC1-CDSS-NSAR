package ch.bfh.btx8201.cdss4nsar.validation.spi;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface Cdss4NsarLabor {
	public String getType();
	public void setType(String type);
	
	public String getValue();
	public void setValue(String value);
	
	public String getMeasuringSize();
	public void setMeasuringSize(String measuringSize);	
}