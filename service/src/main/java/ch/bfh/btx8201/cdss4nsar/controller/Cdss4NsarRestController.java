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

@RestController
public class Cdss4NsarRestController {

	@Autowired
	RequestDao requestDao;

	@Autowired
	Settings settings;

	@RequestMapping(value = "/cdss", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String doCdssRequest(@RequestBody Cdss4NsarRequest httpRequest)
			throws MalformedURLException, JsonProcessingException, URISyntaxException {

		ValidationService service = ValidationService.getInstance();
		System.out.println("Age: " + httpRequest.getAge());
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
		if (warnings.size() != 0) {
			request.setWarnings(warnings);
		}

		Request savedRequest = requestDao.save(request);
		String token = Long.toString(savedRequest.getRequestId());

		return "http://" + settings.getServerIp() + ":" + settings.getServerPort() + "/cdss4nsar/result/" + token;
	}

	private Request parseRequest(Cdss4NsarRequest req) {
		Request request = new Request();
		Set<Drug> drugs = new HashSet<Drug>();
		for (Cdss4NsarDrug d : req.getDrugs()) {
			drugs.add(new Drug(d.getName(), d.isNsar(), d.isStereoidal(), d.isPPI(), request));
		}

		Set<LabResult> labs = new HashSet<LabResult>();
		for (Cdss4NsarLabor l : req.getLabResults()) {
			labs.add(new LabResult(request, l.getType(), l.getValue(), l.getMeasuringSize()));
		}

		request.setAge(req.getAge());
		request.setSex(req.getSex());

		return request;
	}

	// @RequestMapping(value="cdss/drugs", method = RequestMethod.GET)
	// public String test() throws MalformedURLException {
	// ValidationService s = ValidationService.getInstance();
	//
	// String response = "<ul>";
	// for(Cdss4NsarDrug drug : s.getDrugList()) {
	// response += "<li>" + drug.getName() + "</li>";
	// }
	// response += "</ul>";
	// return response;
	// }
}
