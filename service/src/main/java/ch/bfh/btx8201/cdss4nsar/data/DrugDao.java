package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DrugDao extends CrudRepository<Drug, Long> {

	public List<Drug> findByName(String name);
	public List<Drug> findByIsNsar(boolean isNsar);
	public List<Drug> findAll();
}
