package pl.krzysztofskul.contactsapp.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	private ContactRepo contactRepo;
	
	@Autowired
	public ContactService(ContactRepo contactRepo) {
		this.contactRepo = contactRepo;
	}

	public Contact save(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public List<Contact> loadAll() {
		return contactRepo.findAll();
	}
	
	public Contact loadById(Long id) {
		return contactRepo.findById(id).get();
	}

}
