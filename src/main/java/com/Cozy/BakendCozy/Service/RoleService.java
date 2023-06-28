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

import com.Cozy.BakendCozy.Entity.Rol_entity;
import com.Cozy.BakendCozy.Repository.IroleRepository;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin
public class RoleService {
	
	@Autowired
	IroleRepository irolRepository;

	@GetMapping(path = "/find/{id}")
	public List<Rol_entity> findByRolId(@PathVariable("id") Integer id) {
		return irolRepository.findByIdRol(id);
	}

	@PostMapping(path = "/save")
	public Rol_entity saveByRol(@RequestBody Rol_entity rol) {
		return irolRepository.save(rol);
	}

	@PutMapping(path = "/update")
	public Rol_entity updateByRol(@RequestBody Rol_entity rol) {

		return irolRepository.save(rol);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteRolById(@PathVariable("id") Integer id) {
		Optional<Rol_entity> state;
		state = irolRepository.findById(id);
		if (state.isPresent()) {
			irolRepository.delete(state.get());
		}
	}

}
