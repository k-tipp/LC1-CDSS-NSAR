package ch.bfh.btx8201.cdss4nsar.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy;

@Entity
@Table(name = "allergy")
public class Allergy implements ICdss4NsarAllergy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long allergyId;

	private String name;

	
	@ManyToOne
	@JsonBackReference
	private Request request;

	public Allergy() {

	}

	public Allergy(Request request, String name) {
		super();
		this.name = name;
		this.request = request;
	}

	public long getAlletgyId() {
		return allergyId;
	}

	public void setAllergyId(long allergyId) {
		this.allergyId = allergyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
