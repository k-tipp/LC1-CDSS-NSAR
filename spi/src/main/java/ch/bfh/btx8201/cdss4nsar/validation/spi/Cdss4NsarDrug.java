package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarDrug implements ICdss4NsarDrug {

	private String name;
	private boolean isNsar;
	private boolean isStereoidal;
	private boolean isPPI;
	
	public Cdss4NsarDrug() {}
	
	public Cdss4NsarDrug(String name, boolean isNsar, boolean isStereoidal, boolean isPPI) {
		super();
		this.name = name;
		this.isNsar = isNsar;
		this.isStereoidal = isStereoidal;
		this.isPPI = isPPI;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean isNsar() {
		return isNsar;
	}
	
	@Override
	public void setIsNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}
	
	@Override
	public boolean isStereoidal() {
		return isStereoidal;
	}
	
	@Override
	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;
	}
	
	@Override
	public boolean isPPI() {
		return isPPI;
	}
	
	@Override
	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}
}
