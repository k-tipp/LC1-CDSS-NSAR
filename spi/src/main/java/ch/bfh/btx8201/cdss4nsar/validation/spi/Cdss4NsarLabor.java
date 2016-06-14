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
 * The Class Cdss4NsarLabor.
 */
public class Cdss4NsarLabor implements ICdss4NsarLabor {

	/** The type. */
	private String type;

	/** The value. */
	private String value;

	/** The measuring size. */
	private String measuringSize;


	/**
	 * Instantiates a new cdss4 nsar labor.
	 */
	public Cdss4NsarLabor() {
		super();
	}

	/**
	 * Instantiates a new cdss4 nsar labor.
	 *
	 * @param type the type
	 * @param value the value
	 * @param measuringSize the measuring size
	 */
	public Cdss4NsarLabor(String type, String value, String measuringSize) {
		super();
		this.type = type;
		this.value = value;
		this.measuringSize = measuringSize;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#getMeasuringSize()
	 */
	@Override
	public String getMeasuringSize() {
		return measuringSize;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarLabor#setMeasuringSize(java.lang.String)
	 */
	@Override
	public void setMeasuringSize(String measuringSize) {
		this.measuringSize = measuringSize;
	}
}
