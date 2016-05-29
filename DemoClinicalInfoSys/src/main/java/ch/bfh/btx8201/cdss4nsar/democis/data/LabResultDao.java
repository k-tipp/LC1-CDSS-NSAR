package ch.bfh.btx8201.cdss4nsar.democis.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/*
 * See here for method names:
 * http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 * 
 */
@Transactional
public interface LabResultDao extends CrudRepository<LabResult, Long> {

	List<LabResult> findByType(String type);
	
	List<LabResult> findByValue(String value);
	
	List<LabResult> findByMeasuringSize(String measuringSize);
	
	List<LabResult> findByTypeAndValue(String type, String value);
	
	List<LabResult> findByTypeAndValueAndMeasuringSize(String type, String value, String measuringSize);
}
