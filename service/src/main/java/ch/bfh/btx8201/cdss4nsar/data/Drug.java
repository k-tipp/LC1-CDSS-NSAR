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

	private boolean isNsar;

	private boolean isStereoidal;

	private boolean isPPI;
	
	@ManyToOne
	@JsonBackReference
	private Request request;

	public Drug() {

	}

	public Drug(String name, boolean isNsar, boolean isStereoidal, boolean isPPI, Request request) {
		super();
		this.name = name;
		this.isNsar = isNsar;
		this.isStereoidal = isStereoidal;
		this.isPPI = isPPI;
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
		return isNsar;
	}

	public void setIsNsar(boolean isNsar) {
		this.isNsar = isNsar;
	}

	public boolean isStereoidal() {
		return isStereoidal;
	}

	public void setIsStereoidal(boolean isStereoidal) {
		this.isStereoidal = isStereoidal;
	}

	public boolean isPPI() {
		return isPPI;
	}

	public void setIsPPI(boolean isPPI) {
		this.isPPI = isPPI;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
