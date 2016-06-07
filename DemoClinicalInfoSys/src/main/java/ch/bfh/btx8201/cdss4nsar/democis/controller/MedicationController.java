package ch.bfh.btx8201.cdss4nsar.democis.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.bfh.btx8201.cdss4nsar.democis.data.Drug;
import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.Medication;
import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;
import ch.bfh.btx8201.cdss4nsar.democis.domain.CdssRequestForm;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarResponse;

@RestController
@RequestMapping("/")
public class MedicationController {

	@Autowired
	DrugDao drugDao;

	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/druglist", method = RequestMethod.GET)
	@ResponseBody
	public String getDrugList(ModelMap modal) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Iterable<Drug> drugIterable = drugDao.findAll();
		List<Cdss4NsarDrug> drugList = new ArrayList<Cdss4NsarDrug>();
		drugIterable.forEach(drug -> drugList.add(drug));
		return mapper.writeValueAsString(drugList);
	}

	@RequestMapping(value = "/medication/create", method = RequestMethod.GET)
	public String getCreateMedication(ModelMap modal) throws JsonProcessingException {
		return "redirect:cdss";
	}

	@RequestMapping(value = "/cdss", method = RequestMethod.GET)
	public String getCdss(ModelMap modal) throws JsonProcessingException {
		return "cdss";
	}

	@RequestMapping(path = "/patient/{patientId}", method = RequestMethod.POST)
	public Cdss4NsarResponse postPatient(@PathVariable long patientId, @ModelAttribute CdssRequestForm cdssRequestForm) {

		Patient patient = patientDao.findOne(patientId);
		Set<Cdss4NsarDrug> patDrugs = new HashSet<Cdss4NsarDrug>();
		for (Medication medication : patient.getMedications()) {
			patDrugs.addAll(medication.getDrugList());
		}

		Set<Cdss4NsarLabor> patLabor = new HashSet<Cdss4NsarLabor>();
		patLabor.addAll(patient.getLabResults());

		Cdss4NsarRequest request = new Cdss4NsarRequest();
		request.setAge(cdssRequestForm.getPatAge());
		request.setSex(cdssRequestForm.getPatSex().charAt(0));
		request.setAllergies(cdssRequestForm.getAllergies());
		request.isPregnant(!cdssRequestForm.isPregnant().isEmpty());
		request.setDrugs(patDrugs);
		request.setLabResults(patLabor);
		
		RestTemplate restTemplate = new RestTemplate();
		Cdss4NsarResponse response = restTemplate.postForObject("http://localhost:8080/cdss4nsar/cdss", request, Cdss4NsarResponse.class);
<<<<<<< HEAD
		System.out.println("-------------- Got Response----------");
		for(Cdss4NsarWarning w : response.getWarnings()) {
			System.out.println(w.getName() + "|" + w.getDescription() + "|" + w.getConflictObjOne() + "|" + w.getConflictObjTwo() + "|" + w.getAlertLevel());
		}
=======
>>>>>>> parent of a1b0b83... asdfghjk
		
		return response;
	}

}
