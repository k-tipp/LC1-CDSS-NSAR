package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarAllergy implements ICdss4NsarAllergy {

	private String name;

	public Cdss4NsarAllergy() {
		super();
	}

	public Cdss4NsarAllergy(String name) {
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
