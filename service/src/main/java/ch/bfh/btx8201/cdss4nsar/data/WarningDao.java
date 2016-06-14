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
package ch.bfh.btx8201.cdss4nsar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


// TODO: Auto-generated Javadoc
/**
 * The Interface WarningDao.
 */
public interface WarningDao extends CrudRepository<Warning, Long> {

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<Warning> findByName(String name);
	
	/**
	 * Find by alert level.
	 *
	 * @param alertLevel the alert level
	 * @return the list
	 */
	public List<Warning> findByAlertLevel(String alertLevel);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	public List<Warning> findAll();
}
