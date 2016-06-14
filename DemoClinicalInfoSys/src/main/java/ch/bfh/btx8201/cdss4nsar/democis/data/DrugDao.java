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
 * The Interface DrugDao.
 */
@Transactional
public interface DrugDao extends CrudRepository<Drug, Long> {

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<Drug> findByName(String name);
	
	/**
	 * Find all by order by drug id asc.
	 *
	 * @return the list
	 */
	public List<Drug> findAllByOrderByDrugIdAsc();
	
	/**
	 * Find top1 by name.
	 *
	 * @param name the name
	 * @return the drug
	 */
	public Drug findTop1ByName(String name);
}
