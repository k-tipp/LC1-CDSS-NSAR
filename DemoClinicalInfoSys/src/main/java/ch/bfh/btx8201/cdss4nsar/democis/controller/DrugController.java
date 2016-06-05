package ch.bfh.btx8201.cdss4nsar.democis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.bfh.btx8201.cdss4nsar.democis.data.Drug;
import ch.bfh.btx8201.cdss4nsar.democis.data.DrugDao;
import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarDrug;

@RestController
public class DrugController {

	@Autowired
	DrugDao drugDao;
	
	@RequestMapping(value="druglist", method = RequestMethod.GET)
	@ResponseBody
	public String getDrugList(ModelMap modal) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Iterable<Drug> drugIterable = drugDao.findAll();
		List<Cdss4NsarDrug> drugList = new ArrayList<Cdss4NsarDrug>();
		drugIterable.forEach(drug -> drugList.add(drug));
        return mapper.writeValueAsString(drugList);
	}
	
}
