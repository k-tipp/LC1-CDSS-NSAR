package ch.bfh.btx8201.cdss4nsar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ch.bfh.btx8201.cdss4nsar.domain.CdssRequest;
import ch.bfh.btx8201.cdss4nsar.domain.CdssResult;

@RestController
public class Cdss4NsarRestController {
	
	@RequestMapping(value="/cdss", method = RequestMethod.POST)
	public CdssResult workCdssRequest(CdssRequest req, UriComponentsBuilder ucBuilder) {
		System.out.println(req.getId());
		CdssResult cr = new CdssResult(req.getId(), Integer.toString(req.getBloodPressure()) + " " + Integer.toString(req.getHeartRate()));
		return cr;
	}
}
