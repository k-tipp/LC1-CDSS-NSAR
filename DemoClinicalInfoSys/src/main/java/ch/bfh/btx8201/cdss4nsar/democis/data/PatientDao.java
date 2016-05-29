package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PatientDao extends CrudRepository<Patient, Long> {

	public List<Patient> findByLastname(String lastname);
	public List<Patient> findByFirstname(String firstname);
}
