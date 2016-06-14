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
package ch.bfh.btx8201.cdss4nsar.democis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientController.
 */
@Controller
public class PatientController {
	
	/** The patient dao. */
	@Autowired
	private PatientDao patientDao;
	
	/** The drug dao. */
	@Autowired
	private DrugDao drugDao;
	
	/**
	 * Gets the patient.
	 *
	 * @param model the model
	 * @return the patient
	 */
	@RequestMapping(value="/patient", method = RequestMethod.GET)
	public String getPatient(ModelMap model) {
		model.addAttribute("patients", patientDao.findAll());
        return "patient";
	}
	
	/**
	 * Gets the patient.
	 *
	 * @param patientId the patient id
	 * @param model the model
	 * @return the patient
	 */
	@RequestMapping(path="/patient/{patientId}", method = RequestMethod.GET)
	public String getPatient(@PathVariable long patientId, ModelMap model) {
		model.addAttribute("activePatient", patientDao.findOne(patientId));
		model.addAttribute("patients", patientDao.findAll());
		model.addAttribute("drugs", drugDao.findAllByOrderByDrugIdAsc());
        return "patient";
	}
}