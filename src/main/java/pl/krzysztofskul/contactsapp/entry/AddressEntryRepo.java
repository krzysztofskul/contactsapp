package pl.krzysztofskul.contactsapp.entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntryRepo extends JpaRepository<AddressEntry, Long>{

}
