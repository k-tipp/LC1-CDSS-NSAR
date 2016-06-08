package ch.bfh.btx8201.cdss4nsar.validation.spi;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "name")
public interface ICdss4NsarLabor {
	public String getName();
	public void setName(String name);
	
}
