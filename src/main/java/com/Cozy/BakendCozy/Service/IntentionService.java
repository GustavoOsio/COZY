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

import com.Cozy.BakendCozy.Entity.Intention;
import com.Cozy.BakendCozy.Repository.IintentionRepository;

@RestController
@RequestMapping("/api/intention")
@CrossOrigin
public class IntentionService {
	
	@Autowired
	IintentionRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Intention> findByIntentionId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public Intention saveByIntention(@RequestBody Intention data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public Intention updateByIntention(@RequestBody Intention data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteIntentionById(@PathVariable("id") Integer id) {
		  List<Intention> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		    	Intention state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}

}
