package pl.krzysztofskul.contactsapp.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

	private SubjectRepo subjectRepo;


	@Autowired
	public SubjectService(SubjectRepo subjectRepo) {
		this.subjectRepo = subjectRepo;
	}
	
	public Subject loadById(Long id) {
		return subjectRepo.findById(id).get();
	}
	
	
}
