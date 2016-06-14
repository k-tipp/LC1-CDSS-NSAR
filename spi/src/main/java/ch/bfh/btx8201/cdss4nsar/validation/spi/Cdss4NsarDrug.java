/*
 * TODO: Insert Description 
 * 
 * No rights are granted except not declinable rights from included
 * projects, libraries etc.
 *
 * @author  Kevin Tippenhauer
 * @author	Martin Stierlin
 * @author	Lukas Wyss
 * @since	SNAPSHOT-1.0.0
 */
package ch.bfh.btx8201.cdss4nsar.validation.spi;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarDrug.
 */
public class Cdss4NsarDrug implements ICdss4NsarDrug {

	/** The name. */
	private String name;
	
	/** The nsar. */
	private boolean nsar;
	
	/** The stereoidal. */
	private boolean stereoidal;
	
	/** The ppi. */
	private boolean ppi;
	
	/**
	 * Instantiates a new cdss4 nsar drug.
	 */
	public Cdss4NsarDrug() {}
	
	/**
	 * Instantiates a new cdss4 nsar drug.
	 *
	 * @param name the name
	 * @param nsar the nsar
	 * @param stereoidal the stereoidal
	 * @param ppi the ppi
	 */
	public Cdss4NsarDrug(String name, boolean nsar, boolean stereoidal, boolean ppi) {
		super();
		this.name = name;
		this.nsar = nsar;
		this.stereoidal = stereoidal;
		this.ppi = ppi;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isNsar()
	 */
	public boolean isNsar() {
		return nsar;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setNsar(boolean)
	 */
	public void setNsar(boolean nsar) {
		this.nsar = nsar;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isStereoidal()
	 */
	public boolean isStereoidal() {
		return stereoidal;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setStereoidal(boolean)
	 */
	public void setStereoidal(boolean stereoidal) {
		this.stereoidal = stereoidal;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#isPpi()
	 */
	public boolean isPpi() {
		return ppi;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug#setPpi(boolean)
	 */
	public void setPpi(boolean ppi) {
		this.ppi = ppi;
	}
	
	
}
