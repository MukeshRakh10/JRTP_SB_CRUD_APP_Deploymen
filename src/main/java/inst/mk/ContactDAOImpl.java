package inst.mk;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inst.mk.entity.Contact;
import inst.mk.repository.ContactRepository;

@Repository
public class ContactDAOImpl implements IContactDAO{

	@Autowired
	ContactRepository contactRepository;
	
	@Override
	@Transactional
	public String save(Contact contact) {
		contactRepository.save(contact);
		return "Reconrd Save Successfully !!!";
	}

	@Override
	@Transactional
	public List<Contact> list() {
		List<Contact> contact =  (List<Contact>) contactRepository.findAll();
		return contact;
	}

	@Override
	@Transactional
	public Optional<Contact> findRecordById(long id) {
		return contactRepository.findById(id);
	}

	@Override
	@Transactional
	public String update(Contact contact) {
		contactRepository.save(contact);
		return "Record Update Successfully !!!";
	}

	@Override
	@Transactional
	public String deleteContactRecord(long id) {
		contactRepository.deleteById(id);
		return "Record Deleted Successfully !!!";
	}

}
