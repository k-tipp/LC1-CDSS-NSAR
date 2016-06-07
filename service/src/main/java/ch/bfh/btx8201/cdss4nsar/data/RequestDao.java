package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RequestDao extends CrudRepository<Request, Long> {

	public List<Request> findByLastname(String lastname);
	public List<Request> findByFirstname(String firstname);
	public List<Request> findAll();
	public Request findOne(long requestId);
}
