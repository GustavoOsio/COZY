package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Archive;


public interface IarchiveRepository extends JpaRepository<Archive, Serializable> {
	
	public List<Archive> findByarchiveId(Integer archiveId);
    
	public List<Archive>findByArchiveId(Integer id);
}
