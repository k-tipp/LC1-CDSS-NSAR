package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;

@Entity
@Table(name = "drug")
public class Drug implements ICdss4NsarDrug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long drugId;

	private String name;

	private boolean nsar;

	private boolean stereoidal;

	private boolean ppi;
	
	@ManyToOne
	@JsonBackReference
	private Request request;

	public Drug() {

	}

	public Drug(String name, boolean nsar, boolean stereoidal, boolean ppi, Request request) {
		super();
		this.name = name;
		this.nsar = nsar;
		this.stereoidal = stereoidal;
		this.ppi = ppi;
		this.request = request;
	}

	public long getDrugId() {
		return drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
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

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	
	
}
