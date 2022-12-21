package inst.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import inst.mk.dto.ContactDTO;
import inst.mk.service.IContactService;

@RestController
@CrossOrigin
public class ContactRestController {
	@Autowired
	private IContactService service;
	
	@GetMapping("list")
	public List<ContactDTO> list(){
		List<ContactDTO> data = service.list();
		return data;
		
	}

	@PostMapping("save")
	public String createContact(@RequestBody ContactDTO c) {
		System.out.println("In createContact "+c);
		String s = service.save(c);
		return s;
	}
	@PutMapping("update")
	public String updateContact(@RequestBody ContactDTO c) {
		System.out.println("In update "+c);
	    service.deleteContactRecord(c.getId());
		String s = service.update(c);
		
		return s;
	}
	@DeleteMapping("delete/{id}")
	public String deleteContactRecord(@PathVariable("id") long id){
		System.out.println("delete is "+id);
		String data = service.deleteContactRecord(id);
		return data;
	}

	
	@GetMapping("findById/{id}")
	public ContactDTO findRecordById(@PathVariable("id") long id){
		System.out.println("findById is "+id);
		ContactDTO data = service.findRecordById(id);
		return data;
	}

	
	
	
}
