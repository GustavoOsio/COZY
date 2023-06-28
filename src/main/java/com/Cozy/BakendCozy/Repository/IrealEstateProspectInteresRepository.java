package com.Cozy.BakendCozy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.RealEstateInterestProspect;

import java.io.Serializable;
import java.util.List;

public interface IrealEstateProspectInteresRepository extends JpaRepository<RealEstateInterestProspect, Serializable> {

	List<RealEstateInterestProspect> findById(Integer realEstateId);
	
}
