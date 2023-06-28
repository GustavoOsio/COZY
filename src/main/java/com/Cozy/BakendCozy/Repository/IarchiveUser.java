package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.ArchiveUser;



public interface IarchiveUser extends JpaRepository<ArchiveUser, Serializable> {
	 //Optional<ArchiveUser> findById(Integer userId);
	List<ArchiveUser> findById(Integer userId);

}
