package com.Cozy.BakendCozy.Repository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.Real_estate;


public interface Ireal_estateRepository extends JpaRepository<Real_estate, Serializable> {
	public List<Real_estate> findByrealEstateId(Integer realEstateId);
	
	public List<Real_estate> 
	findByTitleContainingOrPriceContainingOrLocationContainingOrAddressContaining(
			String filter, String filter2, String filter3, String filter4 );

	public List<Real_estate>findByTitle(String title);

	public List<Real_estate> findByTitleContaining(String filter);
	
	public List<Real_estate>findByRealEstateId(Integer id);
	


}
