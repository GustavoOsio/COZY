package com.Cozy.BakendCozy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cozy.BakendCozy.Entity.ContactUser;
import com.Cozy.BakendCozy.Repository.IcontactUserRepository;



@RestController
@RequestMapping("/api/contactUser")
@CrossOrigin
public class ContactUserService {
	
	@Autowired
	IcontactUserRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<ContactUser> findByContactUserId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public ContactUser saveByContactUser(@RequestBody ContactUser data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public ContactUser updateByContactUser(@RequestBody ContactUser data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteContactUserById(@PathVariable("id") Integer id) {
		  List<ContactUser> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		    	ContactUser state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}

}
