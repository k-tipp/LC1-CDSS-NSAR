package ch.bfh.btx8201.cdss4nsar.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Message;

@RestController
public class DemoRestController {

	@RequestMapping("/hello/{user}")
	public Message message(@PathVariable String user) {

		Message msg = new Message(user, "Hello " + user);
		return msg;
	}

}
