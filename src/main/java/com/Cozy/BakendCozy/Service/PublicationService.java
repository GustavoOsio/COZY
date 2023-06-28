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

import com.Cozy.BakendCozy.Entity.Publication;
import com.Cozy.BakendCozy.Repository.IpublicationRepository;

@RestController
@RequestMapping("/api/publications")
@CrossOrigin
public class PublicationService {
	
	@Autowired
	IpublicationRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Publication> findByContactId(@PathVariable("id") Integer id) {
		return Irepository.findBypublicationId(id);
	}

	@PostMapping(path = "/save")
	public Publication saveByPublication(@RequestBody Publication publication) {
		return Irepository.save(publication);
	}

	@PutMapping(path = "/update")
	public Publication updateByPublication(@RequestBody Publication publication) {
		return Irepository.save(publication);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deletePublicationById(@PathVariable("id") Integer id) {
		Optional<Publication> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
