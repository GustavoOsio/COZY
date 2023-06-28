package com.Cozy.BakendCozy.Service;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Cozy.BakendCozy.Entity.Archive;
import com.Cozy.BakendCozy.Entity.Archive_real_estate;
import com.Cozy.BakendCozy.Entity.CreateRealEstateVo;
import com.Cozy.BakendCozy.Entity.Real_estate;
import com.Cozy.BakendCozy.Entity.Real_estate_amenities;
import com.Cozy.BakendCozy.Props.MediaUploader;
import com.Cozy.BakendCozy.Repository.IarchiveRealEstateRepository;
import com.Cozy.BakendCozy.Repository.IarchiveRepository;
import com.Cozy.BakendCozy.Repository.Ireal_estateRepository;
import com.Cozy.BakendCozy.Repository.Ireal_estate_amenites;
import com.alibaba.fastjson.JSONObject;




@RestController
@RequestMapping("/api/real_estates")
@CrossOrigin
public class Real_estateService {
	
	@Autowired
	Ireal_estateRepository Irepository;
	
	@Autowired
	Ireal_estate_amenites iRealAmenites;
	
	@Autowired
	IarchiveRealEstateRepository iarchiveRealEstateRepository;
	
	@Autowired
	IarchiveRepository iArchiveRepository;
	
	
	@PostMapping(path = "/createRealEstate")
	public JSONObject saveCreateRealEstate(@RequestBody CreateRealEstateVo data) throws java.io.IOException {
		//se crea la instancia para llamar la funcion de subir los archivos
		MediaUploader mediaUploader =new MediaUploader();
		JSONObject jsonResponse = new JSONObject();
		
		jsonResponse.put("status", "error");
		jsonResponse.put("message"," Se han enviado datos incompletos. Asegúrate de completar todos los campos requeridos antes de enviar el JSON." );
	   return jsonResponse ;
	}
	
	 
	 @GetMapping("/findByFilter/{filter}")
	    public List<Real_estate> searchRealEstate(@PathVariable("filter") String filter  ) {
	        List<Real_estate> realEstateByFilterEstates= Irepository.findByTitleContaining(filter);
	        
	    return realEstateByFilterEstates;
	}
	    
	  
	    
	    @GetMapping("/findByFilterId/{id}")
	    public ResponseEntity<Map<String, List<?>>> getData(@PathVariable("id") Integer id) {
	    	List<Real_estate> realEstates = Irepository.findByRealEstateId(id);
	        List<Real_estate_amenities> amenities = iRealAmenites.findByRealEstateId(realEstates.get(0).getRealEstateId());
	       List<Archive_real_estate>archiveByRelation=iarchiveRealEstateRepository.findByRealEstateId(realEstates.get(0).getRealEstateId());
	        Map<String, List<?>> dataMap = new HashMap<>();
	       
	        //asignacion de todo los archivos para esta real_estate
	        List<Archive>archiveByRealEstArchives=new ArrayList<>();
	        for(int i=0; i<archiveByRelation.size(); i++) {
	        	 List<Archive> archives = iArchiveRepository.findByArchiveId(archiveByRelation.get(i).getArchiveId());
	        	    archiveByRealEstArchives.addAll(archives);
	        }
	        
	        dataMap.put("realEstate", realEstates);
	        dataMap.put("amenities", amenities);
	        dataMap.put("media", archiveByRealEstArchives);
	        
	        return ResponseEntity.ok(dataMap);
	    }
	    	

	@GetMapping(path = "/find/{id}")
	public List<Real_estate> findByReal_estateId(@PathVariable("id") Integer id) {
		return Irepository.findByrealEstateId(id);
	}

	@PostMapping(path = "/save")
	public Real_estate saveByReal_estate(@RequestBody Real_estate real) {
		return Irepository.save(real);
	}

	@PutMapping(path = "/update")
	public Real_estate updateByReal_estate(@RequestBody Real_estate real) {
		return Irepository.save(real);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteReal_estateById(@PathVariable("id") Integer id) {
		Optional<Real_estate> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}


}
