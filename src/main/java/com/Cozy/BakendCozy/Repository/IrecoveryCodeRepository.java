package com.Cozy.BakendCozy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.RecoveryCode;

import java.io.Serializable;
import java.util.List;


public interface IrecoveryCodeRepository extends JpaRepository<RecoveryCode, Serializable>{
	
	 List<RecoveryCode> findById(Integer id);

	RecoveryCode findByCode(String recoveryCode);

}
