package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarAllergy;

@Entity
@Table(name = "allergy")



public class Allergy implements ICdss4NsarAllergy{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long drugId;

private String name;

private boolean isNsar;

private boolean isStereoidal;

private boolean isPPI;

@ManyToMany(mappedBy = "allergyList", fetch = FetchType.EAGER)
@JsonBackReference
private Set<Allergy> allergyList;

public Allergy() {

}

public Allergy(long allergyId, String name, Set<Allergy> allergyList) {
	super();
	this.allergyId = allergyId;
	this.name = name;
	this.allergyList = allergyList;
}

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Allergy> getAllergyList() {
	return medicationList;
}

public void setAllergyList(Set<Allergy> allergyList) {
	this.allergyList = allergyList;
}

public long getAllergyId() {
	return allergyId;
}

public void setAllergyId(long allergyId) {
	this.allergyId = allergyId;
}

}



