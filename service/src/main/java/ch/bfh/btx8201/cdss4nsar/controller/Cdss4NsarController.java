package ch.bfh.btx8201.cdss4nsar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/")
public class Cdss4NsarController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World");
        model.addAttribute("cdss", "cdss");
        return "welcome";
    }
 
    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again");
        model.addAttribute("cdss", "cdss");
        return "welcome";
    }
    
	@RequestMapping(value = "/cdss", method = RequestMethod.GET)
	public String getCdssPage(ModelMap model) {
		
		return "cdss";
	}
 
}