package com.Cozy.BakendCozy.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Real_estate_amenities;



public interface Ireal_estate_amenites extends JpaRepository<Real_estate_amenities, Serializable> {

	public List<Real_estate_amenities> findByamenityId(Integer amenityId);
	
	public List<Real_estate_amenities>findByRealEstateId(Integer id);
	

}
