package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Parameters;

public interface IparameterRepository extends JpaRepository<Parameters, Serializable> {
	
	public List<Parameters> findByparametertId(Integer parametertId);

}
