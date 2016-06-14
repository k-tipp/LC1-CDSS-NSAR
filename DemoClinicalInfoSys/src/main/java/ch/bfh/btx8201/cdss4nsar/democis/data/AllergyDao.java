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
 * The Interface AllergyDao.
 */
@Transactional
public interface AllergyDao extends CrudRepository<Allergy, Long> {

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<Allergy> findByName(String name);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	public List<Allergy> findAll();
}