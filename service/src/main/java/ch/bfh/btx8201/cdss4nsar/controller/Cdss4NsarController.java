package ch.bfh.btx8201.cdss4nsar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.bfh.btx8201.cdss4nsar.data.Request;
import ch.bfh.btx8201.cdss4nsar.data.RequestDao;
 
@Controller
@RequestMapping("/")
public class Cdss4NsarController {
 
	@Autowired
	RequestDao requestDao;
	
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World");
        return "welcome";
    }
	
	@RequestMapping(value = "/result/{token}", method = RequestMethod.GET)
	public String getCdssResult(@PathVariable String token, ModelMap model) {
		Request request = requestDao.findOne(Long.parseLong(token));
		if(request != null) {
			model.addAttribute("warnings", request.getWarnings());
		} else {
			model.addAttribute("warnings", null);
		}
		return "result";
	}
 
}