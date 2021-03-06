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
package ch.bfh.btx8201.cdss4nsar.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ch.bfh.btx8201.cdss4nsar.configuration.Settings;
import ch.bfh.btx8201.cdss4nsar.data.Allergy;
import ch.bfh.btx8201.cdss4nsar.data.Drug;
import ch.bfh.btx8201.cdss4nsar.data.LabResult;
import ch.bfh.btx8201.cdss4nsar.data.Request;
import ch.bfh.btx8201.cdss4nsar.data.RequestDao;
import ch.bfh.btx8201.cdss4nsar.data.Warning;
import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarLabor;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarRestController.
 */
@RestController
public class Cdss4NsarRestController {

	/** The request dao. */
	@Autowired
	RequestDao requestDao;

	/** The settings. */
	@Autowired
	Settings settings;

	/**
	 * Do cdss request.
	 *
	 * @param httpRequest the http request
	 * @return the string
	 * @throws MalformedURLException the malformed url exception
	 * @throws JsonProcessingException the json processing exception
	 * @throws URISyntaxException the URI syntax exception
	 */
	@RequestMapping(value = "/cdss", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String doCdssRequest(@RequestBody Cdss4NsarRequest httpRequest)
			throws MalformedURLException, JsonProcessingException, URISyntaxException {

		ValidationService service = ValidationService.getInstance();
		System.out.println(httpRequest.getAge() + "|" + httpRequest.getSex() + "|" + httpRequest.getLabResults().size()
				+ "|" + httpRequest.getAllergies().size() + "|" + httpRequest.getDrugs().size());
		System.out.println("-------Send response--------");

		Request request = parseRequest(httpRequest);
		Set<Warning> warnings = new HashSet<Warning>();
		for (Cdss4NsarWarning warn : service.validateRequest(httpRequest)) {
			Warning tmpWarn = new Warning(warn.getName(), warn.getDescription(), warn.getMeasurementValue(),
					warn.getMeasurementType(), warn.getMeasurementUnit(), warn.getFailedTest(),
					warn.getConflictObjOne(), warn.getConflictObjTwo(), warn.getAlertLevel(), request);
			warnings.add(tmpWarn);
		}
		
		request.setWarnings(warnings);

		Request savedRequest = requestDao.save(request);
		String token = Long.toString(savedRequest.getRequestId());

		return "http://" + settings.getServerIp() + ":" + settings.getServerPort() + "/cdss4nsar/result/" + token;
	}

	/**
	 * Parses the request.
	 *
	 * @param req the req
	 * @return the request
	 */
	private Request parseRequest(Cdss4NsarRequest req) {
		Request request = new Request();
		Set<Drug> drugs = new HashSet<Drug>();
		for (Cdss4NsarDrug d : req.getDrugs()) {
			
			drugs.add(new Drug(d.getName(), d.isNsar(), d.isStereoidal(), d.isPpi(), request));
		}

		Set<LabResult> labs = new HashSet<LabResult>();
		for (Cdss4NsarLabor l : req.getLabResults()) {
			labs.add(new LabResult(request, l.getType(), l.getValue(), l.getMeasuringSize()));
		}
		
		Set<Allergy> allergies = new HashSet<Allergy>();
		for (String s : req.getAllergies()) {
			allergies.add(new Allergy(request, s));
		}

		request.setDrugs(drugs);
		request.setLabResults(labs);
		request.setAllergies(allergies);
		request.setAge(req.getAge());
		request.setSex(req.getSex());
		request.setPregnant(req.isPregnant());

		return request;
	}
}
