package ch.bfh.btx8201.cdss4nsar.controller;

import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ch.bfh.btx8201.cdss4nsar.domain.CdssRequest;
import ch.bfh.btx8201.cdss4nsar.domain.CdssResult;
import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;

@RestController
public class Cdss4NsarRestController {
	
	@RequestMapping(value="/cdss", method = RequestMethod.POST)
	public CdssResult workCdssRequest(CdssRequest req, UriComponentsBuilder ucBuilder) throws MalformedURLException {
		ValidationService s = ValidationService.getInstance();
		CdssResult cr = new CdssResult(req.getId(), s.getDefinition("book") + Integer.toString(req.getBloodPressure()) + " " + Integer.toString(req.getHeartRate()));
		return cr;
	}
}
