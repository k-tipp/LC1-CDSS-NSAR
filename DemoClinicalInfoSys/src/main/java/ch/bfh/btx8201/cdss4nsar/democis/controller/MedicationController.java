package ch.bfh.btx8201.cdss4nsar.democis.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;
import ch.bfh.btx8201.cdss4nsar.democis.data.Drug;
import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.LabResult;
import ch.bfh.btx8201.cdss4nsar.democis.data.Medication;
import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;
import ch.bfh.btx8201.cdss4nsar.democis.domain.CdssRequestForm;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.ICdss4NsarDrug;
import wyslu1.hl7.Sender;

@RestController
@RequestMapping("/")
public class MedicationController {

	@Autowired
	private DrugDao drugDao;

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private Parser parser;

	@RequestMapping(value = "/druglist", method = RequestMethod.GET)
	@ResponseBody
	public String getDrugList(ModelMap modal) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Iterable<Drug> drugIterable = drugDao.findAll();
		List<ICdss4NsarDrug> drugList = new ArrayList<ICdss4NsarDrug>();
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

	@RequestMapping(value = "/hl7", method = RequestMethod.POST)
	public void getHL7(@RequestBody String s) throws HL7Exception, IOException, DecodeException, EncodeException {

		Message message = null;
		Message ack = null;
		String response = null;
		

		message = parser.parse(s);
		ack = message.generateACK();
		response = ack.encode();
		MessageSendable ms = new MessageSendable(ack); 
		System.out.println("ACHTUNG HIER IST DIE RESPONSE: +++ "+response+" +++ ");
		
		Sender sender = new Sender("localhost", 8070, "/hl7/incoming");
		sender.send(ms);
		sender = null;

	}

	@RequestMapping(path = "/patient/{patientId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ObjectNode postPatient4CdssRequest(@PathVariable long patientId, @ModelAttribute CdssRequestForm cdssRequestForm)
			throws MalformedURLException {

		Patient patient = patientDao.findOne(patientId);
		Set<Cdss4NsarDrug> patDrugs = new HashSet<Cdss4NsarDrug>();
		for (Medication medication : patient.getMedications()) {
			for (Drug drug : medication.getDrugList()) {
				patDrugs.add(new Cdss4NsarDrug(drug.getName(), drug.isNsar(), drug.isStereoidal(), drug.isPPI()));
			}
		}

		Set<Cdss4NsarLabor> patLabor = new HashSet<Cdss4NsarLabor>();
		for (LabResult lab : patient.getLabResults()) {
			patLabor.add(new Cdss4NsarLabor(lab.getType(), lab.getValue(), lab.getMeasuringSize()));
		}

		Cdss4NsarRequest request = new Cdss4NsarRequest();
		request.setAge(cdssRequestForm.getPatAge());
		request.setSex(cdssRequestForm.getPatSex().charAt(0));
		request.setAllergies(cdssRequestForm.getAllergies());
		request.isPregnant(!cdssRequestForm.isPregnant().isEmpty());
		request.setDrugs(patDrugs);
		request.setLabResults(patLabor);

		System.out.println("-------------- Sending request----------");
		System.out.println(request.getAge() + "|" + request.getSex() + "|" + request.getLabResults().size() + "|"
				+ request.getAllergies().size() + "|" + request.getDrugs().size());

		RestTemplate restTemplate = new RestTemplate();
		// Cdss4NsarResponse response =
		// restTemplate.postForObject("http://localhost:8080/cdss4nsar/cdss",
		// request, Cdss4NsarResponse.class);

		String resultViewUrl = restTemplate.postForObject("http://localhost:8080/cdss4nsar/cdss", request, String.class);
		System.out.println("-------------- Got Response----------");
		// for(Cdss4NsarWarning w : response.getWarnings()) {
		// System.out.println(w.getName() + "|" + w.getDescription() + "|" +
		// w.getConflictObjOne() + "|" + w.getConflictObjTwo() + "|" +
		// w.getAlertLevel());
		// }
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("resultViewUrl", resultViewUrl);
		System.out.println(resultViewUrl);
		return objectNode1;
	}



}
