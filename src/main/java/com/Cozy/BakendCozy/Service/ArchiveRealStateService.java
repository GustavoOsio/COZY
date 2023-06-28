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

import com.Cozy.BakendCozy.Entity.Archive_real_estate;
import com.Cozy.BakendCozy.Repository.IarchiveRealEstateRepository;


@RestController
@RequestMapping("/api/mediaManager")
@CrossOrigin
public class ArchiveRealStateService {
	
	@Autowired
	IarchiveRealEstateRepository  Irepository;
	
	@GetMapping(path = "/find/{id}")
	public List<Archive_real_estate> findByMediManager(@PathVariable("id") Integer id) {
		return  Irepository.findById(id);
	}

	@PostMapping(path = "/save")
	public Archive_real_estate saveByMediArchive_real_estate (@RequestBody Archive_real_estate real) {
		return Irepository.save(real);
	}

	@PutMapping(path = "/update")
	public Archive_real_estate updateByMediaManager(@RequestBody Archive_real_estate real) {
		return Irepository.save(real);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteMediaManagerById(@PathVariable("id") Integer id) {
		Optional<Archive_real_estate> state;
		state = Optional.empty();
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
