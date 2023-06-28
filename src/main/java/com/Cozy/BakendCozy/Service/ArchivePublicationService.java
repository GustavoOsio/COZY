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

import com.Cozy.BakendCozy.Entity.Archive_publication;
import com.Cozy.BakendCozy.Repository.IarchivePublicRepository;


@RestController
@RequestMapping("/api/archivePublication")
@CrossOrigin
public class ArchivePublicationService {
	

	@Autowired
	IarchivePublicRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Archive_publication> findByArchivePublicationId(@PathVariable("id") Integer id) {
		return Irepository.findByid(id);
	}
	


	@PostMapping(path = "/save")
	public Archive_publication saveByArchivePublic(@RequestBody Archive_publication archive) {
		return Irepository.save(archive);
	}

	@PutMapping(path = "/update")
	public Archive_publication updateByArchivePubl(@RequestBody Archive_publication archive) {
		return Irepository.save(archive);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteArchivePublicById(@PathVariable("id") Integer id) {
		Optional<Archive_publication> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
