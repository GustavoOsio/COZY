package com.Cozy.BakendCozy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.ContactUser;

import java.io.Serializable;
import java.util.List;

public interface IcontactUserRepository extends JpaRepository<ContactUser, Serializable> {
	 List<ContactUser> findById(Integer id);
	
}
