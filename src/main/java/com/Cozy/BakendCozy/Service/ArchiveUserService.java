package com.Cozy.BakendCozy.Service;

import java.util.List;
import java.util.Optional;

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

import com.Cozy.BakendCozy.Entity.ArchiveUser;
import com.Cozy.BakendCozy.Repository.IarchiveUser;

@RestController
@RequestMapping("/api/archiveUser")
@CrossOrigin
public class ArchiveUserService {
	
	@Autowired
	IarchiveUser Irepository;

	@GetMapping(path = "/find/{id}")
	public List<ArchiveUser> findByArchiveUserId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public ArchiveUser saveByArchiveUser(@RequestBody ArchiveUser archive) {
		return Irepository.save(archive);
	}

	@PutMapping(path = "/update")
	public ArchiveUser updateByArchiveUser(@RequestBody ArchiveUser archive) {
		return Irepository.save(archive);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteArchiveUserById(@PathVariable("id") Integer id) {
	
	}
	

}
