package pl.krzysztofskul.contactsapp.subject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubjectDemoGeneratorTest {

	@Autowired
	private SubjectDemoGenerator<Subject> subjectDemoGenerator;
	
	@Test
	void testInitDataAndReturn() {
		List<Subject> subjectList = subjectDemoGenerator.initDataAndReturn();
		assertTrue(subjectList != null);
	}

}
