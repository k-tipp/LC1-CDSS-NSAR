package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface RequestDao extends CrudRepository<Request, Long> {

	public List<Request> findAll();
}
