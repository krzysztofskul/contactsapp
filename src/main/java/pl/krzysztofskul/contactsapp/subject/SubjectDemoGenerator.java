package pl.krzysztofskul.contactsapp.subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.contactsapp.init.InitDataGenerator;

@Service
public class SubjectDemoGenerator<Subject> implements InitDataGenerator<Subject> {

	private final LoremIpsum loremIpsum = LoremIpsum.getInstance();
	private final Random random = new Random();
	
	private Set<Subject> subjectSet = new HashSet<Subject>();
	
	@Override
	public List<Subject> initDataAndReturn() {
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList.add((Subject) new Company(loremIpsum.getTitle(1)));
		subjectList.add((Subject) new Person(null, loremIpsum.getFirstName(), loremIpsum.getLastName(), null));
		//subjectSet = Set.copyOf(subjectList);
		for (Subject subject : subjectList) {
			subjectSet.add(subject);
		}
		return subjectList;
	}

	public Subject getDemoSubject() {
		return subjectSet.iterator().next();
	}
	
}
