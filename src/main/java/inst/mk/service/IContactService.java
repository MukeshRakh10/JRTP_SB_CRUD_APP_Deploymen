package inst.mk.service;

import java.util.List;

import inst.mk.dto.ContactDTO;

public interface IContactService {
	String save(ContactDTO contactDto);
	List<ContactDTO> list();
	ContactDTO findRecordById(long id);
	String update(ContactDTO c);
	String deleteContactRecord(long id);
	
}
