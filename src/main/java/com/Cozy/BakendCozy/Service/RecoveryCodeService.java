package com.Cozy.BakendCozy.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.Cozy.BakendCozy.Entity.RecoveryCode;
import com.Cozy.BakendCozy.Entity.User;
import com.Cozy.BakendCozy.Repository.IrecoveryCodeRepository;
import com.Cozy.BakendCozy.Repository.IuserRepository;

@RestController
@RequestMapping("/api/recoveryCode")
@CrossOrigin
public class RecoveryCodeService {
	
	@Autowired
	IrecoveryCodeRepository Irepository;
	
	@Autowired
	IuserRepository userRepository;
	
	@PostMapping("/generateRecoveryCode")
	public ResponseEntity<RecoveryCode> generateRecoveryCode(@RequestBody User userRequest) {
	    Integer userId = userRequest.getUserId();
	    
	    // Generar un código de 4 dígitos
	    String code = generateCode(4);
	    
	    // Calcular la fecha de expiración (por ejemplo, 1 hora a partir de ahora)
	    LocalDateTime expirationDate = LocalDateTime.now().plusHours(1);
	    Date currentDate = new Date();
	    // Crear el objeto RecoveryCode
	    RecoveryCode recoveryCode = new RecoveryCode();
	    recoveryCode.setUserId(userId);
	    recoveryCode.setCode(code);
	    recoveryCode.setExpirationDate(currentDate);
	    Irepository.save(recoveryCode);
	    
	    // Guardar el código de recuperación en la base de datos u otra operación necesaria
	    
	    return ResponseEntity.ok(recoveryCode);
	}

	// Método para generar un código de n dígitos
	private String generateCode(int digits) {
	    Random random = new Random();
	    StringBuilder codeBuilder = new StringBuilder();
	    
	    for (int i = 0; i < digits; i++) {
	        int digit = random.nextInt(10);  // Generar un número aleatorio del 0 al 9
	        codeBuilder.append(digit);
	    }
	    
	    return codeBuilder.toString();
	}
	

	@GetMapping(path = "/find/{id}")
	public List<RecoveryCode> findByRecoveryCodeId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public RecoveryCode saveByRecoveryCode(@RequestBody RecoveryCode data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public RecoveryCode updateByRecoveryCode(@RequestBody RecoveryCode data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteRecoveryCodeById(@PathVariable("id") Integer id) {
		  List<RecoveryCode> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		    	RecoveryCode state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}
	

}
