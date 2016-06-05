package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MedicationDao extends CrudRepository<Medication, Long> {

	public List<Drug> findByPatient(Patient patient);
}
