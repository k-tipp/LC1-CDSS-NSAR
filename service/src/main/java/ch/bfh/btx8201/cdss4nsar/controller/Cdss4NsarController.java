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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.bfh.btx8201.cdss4nsar.data.Request;
import ch.bfh.btx8201.cdss4nsar.data.RequestDao;
 
// TODO: Auto-generated Javadoc
/**
 * The Class Cdss4NsarController.
 */
@Controller
@RequestMapping("/")
public class Cdss4NsarController {
 
	/** The request dao. */
	@Autowired
	RequestDao requestDao;
	
    /**
     * Say hello.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World");
        return "welcome";
    }
	
	/**
	 * Gets the cdss result.
	 *
	 * @param token the token
	 * @param model the model
	 * @return the cdss result
	 */
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