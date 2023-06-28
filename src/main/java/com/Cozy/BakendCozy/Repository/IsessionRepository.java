package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Session;


public interface IsessionRepository extends JpaRepository<Session, Serializable> {

	public List<Session> findBysessionId(Integer sessionId);
}
