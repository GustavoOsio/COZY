package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Archive_publication;


public interface IarchivePublicRepository extends JpaRepository<Archive_publication, Serializable> {
	
	public List<Archive_publication>findByid(Integer id);

}
