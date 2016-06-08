package ch.bfh.btx8201.cdss4nsar.democis.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy;

@Entity
@Table(name = "allergy")
public class Allergy implements ICdss4NsarAllergy {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long allergyId;

private String name;

public Allergy() {

}

public Allergy(long allergyId, String name) {
	super();
	this.allergyId = allergyId;
	this.name = name;
}

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

public long getAllergyId() {
	return allergyId;
}

public void setAllergyId(long allergyId) {
	this.allergyId = allergyId;
}

}



