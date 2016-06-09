package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarDrug implements ICdss4NsarDrug {

	private String name;
	private boolean nsar;
	private boolean stereoidal;
	private boolean ppi;
	
	public Cdss4NsarDrug() {}
	
	public Cdss4NsarDrug(String name, boolean nsar, boolean stereoidal, boolean ppi) {
		super();
		this.name = name;
		this.nsar = nsar;
		this.stereoidal = stereoidal;
		this.ppi = ppi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isNsar() {
		return nsar;
	}

	public void setNsar(boolean nsar) {
		this.nsar = nsar;
	}

	public boolean isStereoidal() {
		return stereoidal;
	}

	public void setStereoidal(boolean stereoidal) {
		this.stereoidal = stereoidal;
	}

	public boolean isPpi() {
		return ppi;
	}

	public void setPpi(boolean ppi) {
		this.ppi = ppi;
	}
	
	
}
