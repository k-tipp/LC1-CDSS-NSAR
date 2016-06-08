package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface WarningDao extends CrudRepository<Warning, Long> {

	public List<Warning> findByName(String name);
	public List<Warning> findByAlertLevel(String alertLevel);
	public List<Warning> findAll();
}
