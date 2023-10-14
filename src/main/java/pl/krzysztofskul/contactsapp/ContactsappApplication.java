package pl.krzysztofskul.contactsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsappApplication.class, args);
		initTestData();
	}

	private static void initTestData() {
		System.out.println("init test data..");
	}
	
}
