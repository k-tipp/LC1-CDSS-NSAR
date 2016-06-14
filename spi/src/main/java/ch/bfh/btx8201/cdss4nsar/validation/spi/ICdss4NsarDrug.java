package ch.bfh.btx8201.cdss4nsar.validation.spi;

public interface ICdss4NsarDrug {
	
	public String getName();
	
	public void setName(String name);
	
	public boolean isNsar();
	
	public void setNsar(boolean nsar);
	
	public boolean isStereoidal();
	
	public void setStereoidal(boolean stereoidal);
	
	public boolean isPpi();
	
	public void setPpi(boolean ppi);
}
