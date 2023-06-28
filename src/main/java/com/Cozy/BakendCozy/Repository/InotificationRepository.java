package com.Cozy.BakendCozy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Notification;

import java.io.Serializable;
import java.util.List;


public interface InotificationRepository extends JpaRepository<Notification, Serializable>  {
	
	List<Notification> findById(Integer id);

}
