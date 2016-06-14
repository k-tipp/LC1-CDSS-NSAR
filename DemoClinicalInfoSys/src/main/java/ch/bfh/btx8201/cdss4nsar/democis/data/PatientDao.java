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
 * The Interface PatientDao.
 */
@Transactional
public interface PatientDao extends CrudRepository<Patient, Long> {

	/**
	 * Find by lastname.
	 *
	 * @param lastname the lastname
	 * @return the list
	 */
	public List<Patient> findByLastname(String lastname);
	
	/**
	 * Find by firstname.
	 *
	 * @param firstname the firstname
	 * @return the list
	 */
	public List<Patient> findByFirstname(String firstname);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	public List<Patient> findAll();
}
