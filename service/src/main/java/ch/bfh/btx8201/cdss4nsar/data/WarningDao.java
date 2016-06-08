package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WarningDao extends CrudRepository<Warning, Long> {

	public List<Warning> findByName(String name);
	public List<Warning> findByAlertLevel(String alertLevel);
	public List<Warning> findAll();
}
