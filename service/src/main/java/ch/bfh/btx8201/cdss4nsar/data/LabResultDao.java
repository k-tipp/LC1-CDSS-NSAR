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
/*
 * See here for method names:
 * http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * 
 */

/**
 * The Interface LabResultDao.
 */
public interface LabResultDao extends CrudRepository<LabResult, Long> {

	/**
	 * Find by type.
	 *
	 * @param type the type
	 * @return the list
	 */
	List<LabResult> findByType(String type);
	
	/**
	 * Find by value.
	 *
	 * @param value the value
	 * @return the list
	 */
	List<LabResult> findByValue(String value);
	
	/**
	 * Find by measuring size.
	 *
	 * @param measuringSize the measuring size
	 * @return the list
	 */
	List<LabResult> findByMeasuringSize(String measuringSize);
	
	/**
	 * Find by type and value.
	 *
	 * @param type the type
	 * @param value the value
	 * @return the list
	 */
	List<LabResult> findByTypeAndValue(String type, String value);
	
	/**
	 * Find by type and value and measuring size.
	 *
	 * @param type the type
	 * @param value the value
	 * @param measuringSize the measuring size
	 * @return the list
	 */
	List<LabResult> findByTypeAndValueAndMeasuringSize(String type, String value, String measuringSize);
}
