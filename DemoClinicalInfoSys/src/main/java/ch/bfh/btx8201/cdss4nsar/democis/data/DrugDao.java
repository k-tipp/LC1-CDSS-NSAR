package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DrugDao extends CrudRepository<Drug, Long> {

	public List<Drug> findByName(String name);
	public List<Drug> findByIsNsar(boolean isNsar);
}
