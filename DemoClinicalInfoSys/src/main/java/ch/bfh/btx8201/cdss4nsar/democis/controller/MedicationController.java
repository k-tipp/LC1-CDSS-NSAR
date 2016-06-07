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
import ch.bfh.btx8201.cdss4nsar.democis.data.LabResult;
import ch.bfh.btx8201.cdss4nsar.democis.data.Medication;
import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;
import ch.bfh.btx8201.cdss4nsar.democis.domain.CdssRequestForm;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrugImpl;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLaborImpl;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarResponse;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

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
		Set<Cdss4NsarDrugImpl> patDrugs = new HashSet<Cdss4NsarDrugImpl>();
		for (Medication medication : patient.getMedications()) {
			for(Drug drug : medication.getDrugList()) {
				patDrugs.add(new Cdss4NsarDrugImpl(drug.getName(), drug.isNsar(), drug.isStereoidal(), drug.isPPI()));
			}
		}

		Set<Cdss4NsarLaborImpl> patLabor = new HashSet<Cdss4NsarLaborImpl>();
		for(LabResult lab : patient.getLabResults()) {
			patLabor.add(new Cdss4NsarLaborImpl(lab.getType(), lab.getValue(), lab.getMeasuringSize()));
		}
		

		Cdss4NsarRequest request = new Cdss4NsarRequest();
		request.setAge(cdssRequestForm.getPatAge());
		request.setSex(cdssRequestForm.getPatSex().charAt(0));
		request.setAllergies(cdssRequestForm.getAllergies());
		request.isPregnant(!cdssRequestForm.isPregnant().isEmpty());
		request.setDrugs(patDrugs);
		request.setLabResults(patLabor);
		
		System.out.println("-------------- Sending request----------");
		System.out.println(request.getAge() + "|" + request.getSex() + "|" + request.getLabResults().size() + "|" + request.getAllergies().size() + "|" + request.getDrugs().size());
		
		RestTemplate restTemplate = new RestTemplate();
		Cdss4NsarResponse response = restTemplate.postForObject("http://localhost:8080/cdss4nsar/cdss", request, Cdss4NsarResponse.class);
		System.out.println("-------------- Got Response----------");
		for(Cdss4NsarWarning w : response.getWarnings()) {
			System.out.println(w.getName() + "|" + w.getDescription() + "|" + w.getConflictObjOne() + "|" + w.getConflictObjTwo() + "|" + w.getAlertLevel());
		}
		
		
		return response;
	}

}
