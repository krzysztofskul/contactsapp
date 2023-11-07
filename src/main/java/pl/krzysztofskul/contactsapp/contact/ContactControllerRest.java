package pl.krzysztofskul.contactsapp.contact;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi/contacts")
public class ContactControllerRest {
	
	private ContactService contactService;
	
	
	
    /**
	 * @param contactService
	 */
	@Autowired
	public ContactControllerRest(ContactService contactService) {
		this.contactService = contactService;
	}

	@PostMapping
    @RequestMapping("{id}")
    public Contact saveFoo(
            @RequestBody Contact contact
    ) {
    	System.out.println(contact);
        return contactService.save(contact);
    }

	
}
