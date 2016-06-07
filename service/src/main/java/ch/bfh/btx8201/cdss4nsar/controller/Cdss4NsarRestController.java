package ch.bfh.btx8201.cdss4nsar.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.bfh.btx8201.cdss4nsar.data.Request;
import ch.bfh.btx8201.cdss4nsar.data.RequestDao;
import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarResponse;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarWarning;

@RestController
public class Cdss4NsarRestController {
	
	@Autowired
	RequestDao requestDao;
	
	@RequestMapping(value="/cdss", method = RequestMethod.POST, headers="Accept=application/json")
	public String doCdssRequest(@RequestBody Cdss4NsarRequest req) throws MalformedURLException, JsonProcessingException {
		Request request = parseRequest(req);
		requestDao.save(arg0)
		
		ValidationService s = ValidationService.getInstance();
		System.out.println("Age: " + req.getAge());
		System.out.println(req.getAge() + "|" + req.getSex() + "|" + req.getLabResults().size() + "|" + req.getAllergies().size() + "|" + req.getDrugs().size());
		
		
		Cdss4NsarResponse response = new Cdss4NsarResponse(s.validateRequest(req));
		System.out.println("-------Send response--------");
		ObjectMapper mapper = new ObjectMapper();
		for(Cdss4NsarWarning w : response.getWarnings()) {
			System.out.println(w.getName() + "|" + w.getDescription() + "|" + w.getConflictObjOne() + "|" + w.getConflictObjTwo() + "|" + w.getAlertLevel());
		}
		return mapper.writeValueAsString(response);
	}

	private Request parseRequest(Cdss4NsarRequest req) {
		Set<Drug> drugs = new HashSet<Drugs>
		
		
		Request request = new Request();
	
		return null;
	}
	
//	@RequestMapping(value="cdss/drugs", method = RequestMethod.GET)
//	public String test() throws MalformedURLException {
//		ValidationService s = ValidationService.getInstance();
//		
//		String response = "<ul>";
//		for(Cdss4NsarDrug drug : s.getDrugList()) {
//			response += "<li>" + drug.getName() + "</li>";
//		}
//		response += "</ul>";
//		return response;
//	}
}
