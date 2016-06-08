package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface AllergyDao extends CrudRepository<Allergy, Long> {

	public List<Allergy> findByName(String name);
	public List<Allergy> findAll();
}
