package com.best.projectB.dao;

import com.best.projectB.entity.FPV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FPVRepository extends JpaRepository<FPV, Long>, JpaSpecificationExecutor<FPV> {
}
