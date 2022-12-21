package inst.mk.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inst.mk.IContactDAO;
import inst.mk.dto.ContactDTO;
import inst.mk.entity.Contact;
import inst.mk.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private IContactDAO contactDAO;

	@Override
	public String save(ContactDTO contactDto) {
		Contact contact = new Contact();
		contact.setName(contactDto.getName());
		contact.setEmail(contactDto.getEmail());
		contact.setPhno(contactDto.getPhno());
		contactDAO.save(contact);

		return null;
	}

	@Override
	public List<ContactDTO> list() {
		ModelMapper modelMapper = new ModelMapper();
		List<Contact> contList = contactDAO.list();
		List<ContactDTO> array = new ArrayList<>();
		for (Contact contact : contList) {
			ContactDTO dto = modelMapper.map(contact, ContactDTO.class);
			array.add(dto);
		}
		return array;
	}

	@Override
	public ContactDTO findRecordById(long id) {
		
		ModelMapper modelMapper = new ModelMapper();
		Optional<Contact> contact = contactDAO.findRecordById(id);
		if(contact.isPresent()) {
			ContactDTO dto = modelMapper.map(contact, ContactDTO.class);
			return dto;
		}
		return null;
	}

	@Override
	public String update(ContactDTO c) {
		Contact contact = new Contact();
		contact.setName(c.getName());
		contact.setEmail(c.getEmail());
		contact.setPhno(c.getPhno());
		return contactDAO.update(contact);
		

	}

	@Override
	public String deleteContactRecord(long id) {
		return contactDAO.deleteContactRecord(id);
	}

}
