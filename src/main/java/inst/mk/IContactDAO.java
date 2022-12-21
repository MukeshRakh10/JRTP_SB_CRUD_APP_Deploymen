package inst.mk;

import java.util.List;
import java.util.Optional;

import inst.mk.entity.Contact;

public interface IContactDAO {
	String save(Contact contact);
	List<Contact> list();
	Optional<Contact> findRecordById(long id);
	String update(Contact contact);
	String deleteContactRecord(long id);
}
