package ch.bfh.btx8201.cdss4nsar.controller;

import java.net.MalformedURLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.btx8201.cdss4nsar.validation.ValidationService;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarRequest;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarResponse;

@RestController
public class Cdss4NsarRestController {
	
	@RequestMapping(value="cdss", method = RequestMethod.POST)
	public Cdss4NsarResponse doCdssRequest(Cdss4NsarRequest req) throws MalformedURLException {
		ValidationService s = ValidationService.getInstance();
		Cdss4NsarResponse response = new Cdss4NsarResponse(req.getId(), s.validateRequest(req));
		return response;
	}
}
