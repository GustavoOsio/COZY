package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Rol_entity;



public interface IroleRepository extends JpaRepository<Rol_entity, Serializable> {

	public List<Rol_entity> findByIdRol(Integer idRol);
	

	
}
