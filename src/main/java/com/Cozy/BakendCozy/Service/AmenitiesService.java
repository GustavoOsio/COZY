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

import com.Cozy.BakendCozy.Entity.Real_estate_amenities;
import com.Cozy.BakendCozy.Repository.Ireal_estate_amenites;


@RestController
@RequestMapping("/api/amenities")
@CrossOrigin
public class AmenitiesService {
	
	@Autowired
	Ireal_estate_amenites Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Real_estate_amenities> findByReal_estate_amenitiesId(@PathVariable("id") Integer id) {
		return Irepository.findByamenityId(id);
		
	}

	@PostMapping(path = "/save")
	public Real_estate_amenities saveByReal_estate_amenities(@RequestBody Real_estate_amenities amenity) {
		return Irepository.save(amenity);
	}

	@PutMapping(path = "/update")
	public Real_estate_amenities updateByContact(@RequestBody Real_estate_amenities amenity) {
		return Irepository.save(amenity);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteReal_estate_amenitiesById(@PathVariable("id") Integer id) {
		Optional<Real_estate_amenities> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
