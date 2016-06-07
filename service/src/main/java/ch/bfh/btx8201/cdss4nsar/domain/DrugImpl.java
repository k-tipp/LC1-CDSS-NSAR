package ch.bfh.btx8201.cdss4nsar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrugImpl {
	
	private String name;
	
	private boolean isNsar;
	
	private boolean isStereoidal;
	
	private boolean isPPI;

	public DrugImpl() {

	}

	public boolean isNsar() {
		return isNsar;
	}

	public void setNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	public String getName() {
		return this.name;
	}

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
