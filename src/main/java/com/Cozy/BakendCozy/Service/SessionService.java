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

import com.Cozy.BakendCozy.Entity.Session;
import com.Cozy.BakendCozy.Repository.IsessionRepository;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin
public class SessionService {
	
	@Autowired
	IsessionRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Session> findByContactId(@PathVariable("id") Integer id) {
		return Irepository.findBysessionId(id);
	}

	@PostMapping(path = "/save")
	public Session saveBySession(@RequestBody Session session) {
		return Irepository.save(session);
	}

	@PutMapping(path = "/update")
	public Session updateBySession(@RequestBody Session session) {
		return Irepository.save(session);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteSessionById(@PathVariable("id") Integer id) {
		Optional<Session> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}


}
