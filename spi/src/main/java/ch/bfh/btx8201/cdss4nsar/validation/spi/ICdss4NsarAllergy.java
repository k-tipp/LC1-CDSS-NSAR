package ch.bfh.btx8201.cdss4nsar.validation.spi;

//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "name")
public interface ICdss4NsarAllergy {
	public String getName();
	public void setName(String name);
	
}
