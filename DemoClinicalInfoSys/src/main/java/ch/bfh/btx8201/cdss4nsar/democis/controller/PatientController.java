package ch.bfh.btx8201.cdss4nsar.democis.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;

@RestController
public class PatientController {
	
	@RequestMapping(value="patient/create", method = RequestMethod.POST)
	public String createPatient(ModelMap model) {
        return "redirect:patient/view";
	}
	
	@RequestMapping(value="patient/create", method = RequestMethod.GET)
	public void patient(ModelMap model) {
        model.addAttribute("new_patient", new Patient());
	}
}