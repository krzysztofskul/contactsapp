package pl.krzysztofskul.contactsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.krzysztofskul.contactsapp.contact.ContactService;

@Controller
@RequestMapping("contacts")
public class ContactsappController {

	private ContactService contactService;
	
	@Autowired
	public ContactsappController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/startpage")
	public ModelAndView startPage() {
		return new ModelAndView("contacts/start");
	}
	
	@GetMapping("/")
	public ModelAndView getRootPage() {
		return new ModelAndView("redirect:/contacts/startpage");
	}	

}
