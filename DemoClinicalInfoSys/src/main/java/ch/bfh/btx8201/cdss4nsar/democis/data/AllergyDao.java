package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AllergyDao extends CrudRepository<Allergy, Long> {

	public List<Allergy> findByName(String name);
	public List<Allergy> findAll();
}