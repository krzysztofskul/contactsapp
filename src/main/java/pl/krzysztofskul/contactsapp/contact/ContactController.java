package pl.krzysztofskul.contactsapp.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/new")
	public ModelAndView getNew(
				@RequestParam(name = "backToPage", required = false) String backToPage
			) {
		Contact contact = new Contact();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(backToPage);
		modelAndView.addObject(contact);
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView getEdit(
				@PathVariable Long id,
				@RequestParam(name = "backToPage", required = false) String backToPage
			) {
		Contact contact = contactService.loadById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contacts/id");
		modelAndView.addObject(contact);
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView postNew(
			@RequestParam(name = "backToPage", required = true) String backToPage,
			@ModelAttribute("contact") @Validated Contact contact, BindingResult result
			) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(backToPage);
		if (result.hasErrors()) {
			return modelAndView;
		}
		contactService.save(contact);
		return modelAndView;
	}
	
	@GetMapping("/all")
	public ModelAndView getAll(
				@RequestParam(name = "backToPage", required = false) String backToPage
			) {
		ModelAndView modelAndView = new ModelAndView();
		List<Contact> contactList = contactService.loadAll();
		modelAndView.addObject(contactList);
		modelAndView.setViewName("contacts/all");
		return modelAndView;
	}
	
}
