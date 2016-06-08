package ch.bfh.btx8201.cdss4nsar.validation.spi;

//@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface ICdss4NsarDrug {
	
	public String getName();
	
	public void setName(String name);
	
	public boolean isNsar();
	
	public void setIsNsar(boolean isNsar);
	
	public boolean isStereoidal();
	
	public void setIsStereoidal(boolean isStereoidal);
	
	public boolean isPPI();
	
	public void setIsPPI(boolean isPPI);
}
