package com.adv.amfi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adv.amfi.model.SchemeMapping;


@Repository
public interface SchemeMappingRepository extends JpaRepository<SchemeMapping, Integer> {
	
}
