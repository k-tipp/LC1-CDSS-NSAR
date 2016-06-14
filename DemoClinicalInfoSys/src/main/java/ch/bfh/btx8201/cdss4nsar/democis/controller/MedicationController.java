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

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_PATIENT;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.parser.Parser;
import ch.bfh.btx8201.cdss4nsar.democis.configuration.Settings;
import ch.bfh.btx8201.cdss4nsar.democis.data.Drug;
import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.LabResult;
import ch.bfh.btx8201.cdss4nsar.democis.data.LabResultDao;
import ch.bfh.btx8201.cdss4nsar.democis.data.Medication;
import ch.bfh.btx8201.cdss4nsar.democis.data.Patient;
import ch.bfh.btx8201.cdss4nsar.democis.data.PatientDao;
import ch.bfh.btx8201.cdss4nsar.democis.domain.CdssRequestForm;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import wyslu1.hl7.Sender;

// TODO: Auto-generated Javadoc
/**
 * The Class MedicationController.
 */
@RestController
@RequestMapping("/")
public class MedicationController {

	/** The drug dao. */
	@Autowired
	private DrugDao drugDao;
	
	/** The lab result dao. */
	@Autowired
	private LabResultDao labResultDao;

	/** The patient dao. */
	@Autowired
	private PatientDao patientDao;
	
	/** The settings. */
	@Autowired
	private Settings settings;
	
	/** The hl7 parser. */
	@Autowired
	private Parser hl7Parser;

	/**
	 * Gets the h l7.
	 *
	 * @param s the s
	 * @return the h l7
	 * @throws HL7Exception the h l7 exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws DecodeException the decode exception
	 * @throws EncodeException the encode exception
	 */
	@RequestMapping(value = "/hl7", method = RequestMethod.POST)
	public void getHL7(@RequestBody String s) throws HL7Exception, IOException, DecodeException, EncodeException {

//		HapiContext ctx = new DefaultHapiContext();
//		ctx.setValidationRuleBuilder(new NoValidationBuilder());
//		Parser parser = ctx.getGenericParser();
//		Parser parser = new PipeParser();

		Message message = null;
		Message ack = null;
		
		message = hl7Parser.parse(s);
	
		ORU_R01 oru = (ORU_R01)message;
		ack = message.generateACK();
		MessageSendable ms = new MessageSendable(ack); 
		
		
		
		ORU_R01_PATIENT patient = oru.getPATIENT_RESULT().getPATIENT();
		ORU_R01_OBSERVATION observation = oru.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION();
		
		
		// ******** DB Values ********* 
		String patientID = patient.getPID().getPatientID().getCx1_IDNumber().getValue();
		String type = observation.getOBX().getObx3_ObservationIdentifier().getCwe2_Text().encode();
		String value = observation.getOBX().getObx5_ObservationValue()[0].encode();
		String units = observation.getOBX().getObx6_Units().getCwe1_Identifier().encode();
		//*******************************************
		
		LabResult result = new LabResult();
		result.setMeasuringSize(units);
		result.setPatient(patientDao.findOne(Long.parseLong(patientID)));
		result.setType(type);
		result.setValue(value);
		labResultDao.save(result);
		
		Sender sender = new Sender(settings.getLisServerIp(), Integer.parseInt(settings.getLisServerPort()), "/hl7/incoming");
		sender.send(ms);
		sender = null;
	}

	/**
	 * Post patient4 cdss request.
	 *
	 * @param patientId the patient id
	 * @param cdssRequestForm the cdss request form
	 * @return the object node
	 * @throws MalformedURLException the malformed url exception
	 */
	@RequestMapping(path = "/patient/{patientId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ObjectNode postPatient4CdssRequest(@PathVariable long patientId, @ModelAttribute CdssRequestForm cdssRequestForm)
			throws MalformedURLException {

		Patient patient = patientDao.findOne(patientId);
		Set<Cdss4NsarDrug> patDrugs = new HashSet<Cdss4NsarDrug>();
		for (Medication medication : patient.getMedications()) {
			for (Drug drug : medication.getDrugList()) {
				patDrugs.add(new Cdss4NsarDrug(drug.getName(), drug.isNsar(), drug.isStereoidal(), drug.isPpi()));
			}
		}
		
		for(String drugId : cdssRequestForm.getAddDrug()) {
			
			Drug drug = drugDao.findOne(Long.parseLong(drugId));
			patDrugs.add(new Cdss4NsarDrug(drug.getName(), drug.isNsar(), drug.isStereoidal(), drug.isPpi()));
		}

		Set<Cdss4NsarLabor> patLabor = new HashSet<Cdss4NsarLabor>();
		for (LabResult lab : patient.getLabResults()) {
			patLabor.add(new Cdss4NsarLabor(lab.getType(), lab.getValue(), lab.getMeasuringSize()));
		}

		Cdss4NsarRequest request = new Cdss4NsarRequest();
		request.setAge(cdssRequestForm.getPatAge());
		request.setSex(cdssRequestForm.getPatSex().charAt(0));
		request.setAllergies(cdssRequestForm.getAllergies());
		request.isPregnant(cdssRequestForm.getPregnant().equals("pregnant"));
		request.setDrugs(patDrugs);
		request.setLabResults(patLabor);
		

		
		System.out.println("-------------- Sending request----------");
		System.out.println(request.getAge() + "|" + request.getSex() + "|" + request.getLabResults().size() + "|"
				+ request.getAllergies().size() + "|" + request.isPregnant());

		RestTemplate restTemplate = new RestTemplate();
		String resultViewUrl = restTemplate.postForObject("http://" + settings.getCdssServerIp() + ":" + settings.getCdssServerPort() + "/cdss4nsar/cdss", request, String.class);

		System.out.println("-------------- Got Response----------");
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("resultViewUrl", resultViewUrl);
		System.out.println(resultViewUrl);
		return objectNode1;
	}

	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public Settings getSettings() {
		return settings;
	}

	/**
	 * Sets the settings.
	 *
	 * @param settings the new settings
	 */
	public void setSettings(Settings settings) {
		this.settings = settings;
	}



}
