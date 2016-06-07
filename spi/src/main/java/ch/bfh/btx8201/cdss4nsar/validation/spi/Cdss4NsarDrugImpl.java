package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarDrugImpl implements Cdss4NsarDrug {

	private String name;
	private boolean isNsar;
	private boolean isStereoidal;
	private boolean isPPI;
	
	public Cdss4NsarDrugImpl() {}
	
	public Cdss4NsarDrugImpl(String name, boolean isNsar, boolean isStereoidal, boolean isPPI) {
		super();
		this.name = name;
		this.isNsar = isNsar;
		this.isStereoidal = isStereoidal;
		this.isPPI = isPPI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isNsar() {
		return isNsar;
	}
	public void setIsNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}
	public boolean isStereoidal() {
		return isStereoidal;
	}
	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;
	}
	public boolean isPPI() {
		return isPPI;
	}
	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}
	
	
}
