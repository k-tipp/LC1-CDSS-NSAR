package ch.bfh.btx8201.cdss4nsar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drug implements Cdss4NsarDrug {
	
	private String name;
	
	private boolean isNsar;
	
	private boolean isStereoidal;
	
	private boolean isPPI;

	public Drug() {

	}

	@Override
	public boolean isNsar() {
		return isNsar;
	}

	@Override
	public void setNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public boolean isStereoidal() {
		return isStereoidal;
	}

	public boolean isPPI() {
		return isPPI;
	}

	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;
		
	}

	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}
}
