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

import com.Cozy.BakendCozy.Entity.RealEstateInterestProspect;
import com.Cozy.BakendCozy.Repository.IrealEstateProspectInteresRepository;

@RestController
@RequestMapping("/api/interestProspects")
@CrossOrigin
public class RealStateInteresProspectService {
	
	@Autowired
	IrealEstateProspectInteresRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<RealEstateInterestProspect> findByRealEstateInterestProspect(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public RealEstateInterestProspect saveByRealEstateInterestProspect(@RequestBody RealEstateInterestProspect data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public RealEstateInterestProspect updateByRealEstateInterestProspect(@RequestBody RealEstateInterestProspect data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteRealEstateInterestProspectById(@PathVariable("id") Integer id) {
		  List<RealEstateInterestProspect> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		    	RealEstateInterestProspect state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}
	

}
