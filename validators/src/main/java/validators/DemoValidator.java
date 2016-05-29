package validators;

import java.util.SortedMap;
import java.util.TreeMap;

import ch.bfh.btx8201.cdss4nsar.validation.spi.Cdss4NsarValidator;

public class DemoValidator implements Cdss4NsarValidator {

	private SortedMap<String, String> map;

	public DemoValidator() {
		System.out.println("get demo validator instance");
		map = new TreeMap<String, String>();
		map.put("book", "a set of written or printed pages, usually bound with " + "a protective cover");
		map.put("editor", "a person who edits");
	}

	public String getDefinition(String word) {
		System.out.println("get book");
		return map.get(word);
	}

}
