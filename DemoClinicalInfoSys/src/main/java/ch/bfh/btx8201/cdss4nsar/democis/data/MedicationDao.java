/*
 * TODO: Insert Description 
 * 
 * No rights are granted except not declinable rights from included
 * projects, libraries etc.
 *
 * @author  Kevin Tippenhauer
 * @author	Martin Stierlin
 * @author	Lukas Wyss
 * @since	SNAPSHOT-1.0.0
 */
package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Interface MedicationDao.
 */
@Transactional
public interface MedicationDao extends CrudRepository<Medication, Long> {

	/**
	 * Find by patient.
	 *
	 * @param patient the patient
	 * @return the list
	 */
	public List<Drug> findByPatient(Patient patient);
}
