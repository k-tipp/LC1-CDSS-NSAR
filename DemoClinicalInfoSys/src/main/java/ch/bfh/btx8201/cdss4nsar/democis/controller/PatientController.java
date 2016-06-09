package ch.bfh.btx8201.cdss4nsar.democis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;

@Controller
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private DrugDao drugDao;
	
//	@RequestMapping(value="patient/create", method = RequestMethod.POST)
//	public String createPatient(Patient patient) {
//        patientDao.save(patient);
//        return "redirect:patient";
//	}
	
	@RequestMapping(value="/patient", method = RequestMethod.GET)
	public String getPatient(ModelMap model) {
		model.addAttribute("patients", patientDao.findAll());
		
        return "patient";
	}
	
	@RequestMapping(path="/patient/{patientId}", method = RequestMethod.GET)
	public String getPatient(@PathVariable long patientId, ModelMap model) {
		model.addAttribute("activePatient", patientDao.findOne(patientId));
		model.addAttribute("patients", patientDao.findAll());
		model.addAttribute("drugs", drugDao.findAllByOrderByDrugIdAsc());
        return "patient";
	}
	

	

}