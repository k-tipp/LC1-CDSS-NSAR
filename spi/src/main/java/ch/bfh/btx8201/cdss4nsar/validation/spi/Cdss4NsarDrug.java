package ch.bfh.btx8201.cdss4nsar.validation.spi;

public interface Cdss4NsarDrug {
	
	public String getName();
	
	public void setName(String name);
	
	public boolean isNsar();
	
	public void setNsar(boolean isNsar);
	
	public boolean isStereoidal();
	
	public void setIsStereoidal(boolean isStereoidal);
	
	public boolean isPPI();
	
	public void setIsPPI(boolean isPPI);
}
