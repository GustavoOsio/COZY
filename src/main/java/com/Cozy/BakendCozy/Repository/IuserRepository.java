package com.Cozy.BakendCozy.Repository;
import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.User;



public interface IuserRepository extends JpaRepository<User, Serializable> {
	
	public List<User> findByuserId(Integer userId);
	public List<User> findByuser(String user);
	public User findByuserAndPassword(String user, String password);
	
	public User findByUser(String userName);
	
	

}
