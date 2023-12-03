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

import pl.krzysztofskul.contactsapp.subject.Company;
import pl.krzysztofskul.contactsapp.subject.Person;
import pl.krzysztofskul.contactsapp.subject.Subject;
import pl.krzysztofskul.contactsapp.subject.SubjectService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private ContactService contactService;
	private SubjectService subjectService;

	@Autowired
	public ContactController(ContactService contactService, SubjectService subjectService) {
		this.contactService = contactService;
		this.subjectService = subjectService;
	}


	@GetMapping("/new")
	public ModelAndView getNew(
				@RequestParam(name = "backToPage", required = false) String backToPage,
				@RequestParam(name = "category", required = true) String companyCategory
			) {
		Contact contact = new Contact();
		contact.setId(Long.valueOf("0"));
		switch (companyCategory) {
			case "person": {
				contact.setSubject(new Person()); 
				break;
				}
			case "company": {
				contact.setSubject(new Company()); 
				break;
				}
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contacts/id");
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
	
	@PostMapping("/{id}")
	public ModelAndView postNew(
			@PathVariable(required = false) Long contactId,
			@RequestParam(name = "backToPage", required = false) String backToPage,
			@RequestParam(name = "subjectId", required = false) Long subjectId,
			@RequestParam(name = "subjectName", required = false) String subjectName,
			@RequestParam(name = "subjectNameFirst", required = false) String subjectNameFirst,
			@RequestParam(name = "subjectNameLast", required = false) String subjectNameLast,
			@ModelAttribute("contact") @Validated Contact contact, BindingResult result
			) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (result.hasErrors()) {
			return modelAndView;
		}
		
		if (subjectId != null) {
			Subject subject = subjectService.loadById(subjectId);
			if (subject.getClass().getName().contains("Company")) {
				Company company = (Company) subject;
				company.setName(subjectName);
				contact.setSubject(company);
			}
			if (subject.getClass().getName().contains("Person")) {
				Person person = (Person) subject;
				person.setNameFirst(subjectNameFirst);
				person.setNameLast(subjectNameLast);
				contact.setSubject(person);
			}
			
		}
		
		contact = contactService.save(contact);
		if (backToPage == null) {
			backToPage = "contacts/"+contact.getId();
		}
		
		modelAndView.setViewName("redirect:/"+backToPage);
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
	
	@GetMapping("/delete/{id}")
	private ModelAndView deleteById(
				@PathVariable Long id,
				@RequestParam(name = "backToPage", required = false) String backToPage
			) {
		ModelAndView modelAndView = new ModelAndView();
		contactService.deleteById(id);
		modelAndView.setViewName("redirect:"+backToPage);
		return modelAndView;
	}
	
}
