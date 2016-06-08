package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarAllergy implements ICdss4NsarAllergy {

	private String name;

	public Cdss4NsarLabor() {
		super();
	}

	public Cdss4NsarLabor(String name) {
		super();
		this.name = name;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}


}
