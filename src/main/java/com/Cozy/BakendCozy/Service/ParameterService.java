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

import com.Cozy.BakendCozy.Entity.Parameters;
import com.Cozy.BakendCozy.Repository.IparameterRepository;



@RestController
@RequestMapping("/api/parameter")
@CrossOrigin
public class ParameterService {
	
	@Autowired
	IparameterRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Parameters> findByParameterstId(@PathVariable("id") Integer id) {
		return Irepository.findByparametertId(id);
	}
	


	@PostMapping(path = "/save")
	public Parameters saveByParameters(@RequestBody Parameters param) {
		return Irepository.save(param);
	}

	@PutMapping(path = "/update")
	public Parameters updateByParameters(@RequestBody Parameters param) {
		return Irepository.save(param);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteParametersById(@PathVariable("id") Integer id) {
		Optional<Parameters> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}

}
