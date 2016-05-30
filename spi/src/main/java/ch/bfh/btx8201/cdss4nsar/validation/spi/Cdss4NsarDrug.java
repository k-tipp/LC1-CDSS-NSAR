package ch.bfh.btx8201.cdss4nsar.validation.spi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "drug")
public class Cdss4NsarDrug {
	private String name;
	private boolean isNsar;
	
	public Cdss4NsarDrug(String name, boolean isNsar) {
		super();
		this.name = name;
		this.isNsar = isNsar;
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
	
	public void setNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}
}
