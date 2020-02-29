package com.airtel.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.airtel.mdm.entity.Policy;

public interface PolicyRepository extends RevisionRepository<Policy,Long,Long>,JpaRepository<Policy, Long>{

	


}
