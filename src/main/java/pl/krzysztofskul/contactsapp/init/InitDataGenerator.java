package pl.krzysztofskul.contactsapp.init;

import java.util.List;

public interface InitDataGenerator<T> {
	
	List<T> initDataAndReturn();

}
