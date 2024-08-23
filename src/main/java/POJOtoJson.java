import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import POJOs.Address;
import POJOs.Contacts;
import POJOs.NestedJson;

public class POJOtoJson {
	public Address adres;
	@Test
	public void m1() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		NestedJson json = new NestedJson();
		json.setName("Sunil Kumar Alahari");
		json.setAge("38");
		adres = new Address();
		adres.setCity("Ongole");
		adres.setStreet("Maruthi Nagar, 3rd Line...");
		adres.setZip("523001");
		json.setAddress(adres);
		Contacts contacts = new Contacts();
		Contacts contacts1 = new Contacts();
		contacts.setType("Phone");
		contacts1.setValue("9963657896");
		contacts1.setType("Email");
		contacts.setValue("salahari@deloitte.com");
		List<Contacts> lContacts= new ArrayList<Contacts>();
		lContacts.add(contacts);
		lContacts.add(contacts1);
		json.setContacts(lContacts);
		
		//FileOutputStream fis = new FileOutputStream(new File("\\sample.json"));
		//mapper.writeValue(fis, json);
		
		String str= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		
		System.out.println(str);
		

	}

}
