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

import com.Cozy.BakendCozy.Entity.Shedulle;
import com.Cozy.BakendCozy.Repository.IshedulleRepository;


@RestController
@RequestMapping("/api/shedulles")
@CrossOrigin
public class ShedulleService {
	
	@Autowired
	IshedulleRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Shedulle> findByContactId(@PathVariable("id") Integer id) {
		return Irepository.findByshedulleId(id);
	}

	@PostMapping(path = "/save")
	public Shedulle saveByShedulle(@RequestBody Shedulle shedulle) {
		return Irepository.save(shedulle);
	}

	@PutMapping(path = "/update")
	public Shedulle updateByShedulle(@RequestBody Shedulle shedulle) {
		return Irepository.save(shedulle);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteShedulleById(@PathVariable("id") Integer id) {
		Optional<Shedulle> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
