package ch.bfh.btx8201.cdss4nsar.democis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;

@RestController
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@RequestMapping(value="patient/create", method = RequestMethod.POST)
	public String createPatient(Patient patient) {
        patientDao.save(patient);
        return "redirect:patient";
	}
	
	@RequestMapping(value="patient/create", method = RequestMethod.GET)
	public void createPatient(ModelMap model) {
        model.addAttribute("new_patient", new Patient());
	}
}