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

import com.Cozy.BakendCozy.Entity.BasicData;
import com.Cozy.BakendCozy.Repository.IbasicDataRepository;

@RestController
@RequestMapping("/api/basicData")
@CrossOrigin
public class BasicDataService {

	@Autowired
	IbasicDataRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<BasicData> findByBasicDataId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public BasicData saveByBasicData(@RequestBody BasicData data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public BasicData updateByParameters(@RequestBody BasicData data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteBasicDataById(@PathVariable("id") Integer id) {
		  List<BasicData> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		        BasicData state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}
	

	public String generateNextCode() {
        // Obtener el último código creado en la tabla BasicData
        Optional<BasicData> lastBasicData =  Irepository.findFirstByOrderByCozyCodeDesc();

        // Generar el nuevo código incrementando el último código existente
        String newCode;
        if (lastBasicData.isPresent()) {
            String lastCode = lastBasicData.get().getCozyCode();
            int lastNumber = Integer.parseInt(lastCode);
            int nextNumber = lastNumber + 1;
            newCode = String.format("%04d", nextNumber);
        } else {
            // Si no hay registros en la tabla BasicData, generar el primer código
            newCode = "0001";
        }

        // Verificar si el nuevo código ya existe en la tabla BasicData
        Optional<BasicData> existingBasicData =  Irepository.findByCozyCode(newCode);
        if (existingBasicData.isPresent()) {
            // Si el código ya existe, generar el siguiente código recursivamente
            return generateNextCode();
        }

        return newCode;
    }
	
}
