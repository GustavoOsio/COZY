package com.Cozy.BakendCozy.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Cozy.BakendCozy.Entity.BasicData;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IbasicDataRepository extends JpaRepository<BasicData, Serializable>{

	 List<BasicData> findById(Integer id);

	Optional<BasicData> findFirstByOrderByCozyCodeDesc();

	Optional<BasicData> findByCozyCode(String newCode);

}
