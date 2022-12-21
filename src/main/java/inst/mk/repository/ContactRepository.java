package inst.mk.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import inst.mk.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	  Optional<Contact> findById(Long id);

}
