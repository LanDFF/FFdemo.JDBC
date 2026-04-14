package com.best.projectB.dao;

import com.best.projectB.entity.FPV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FPVRepository extends JpaRepository<FPV, Long>, JpaSpecificationExecutor<FPV> {


    @Query(value = "select * from fpv_01 where existed = 0",nativeQuery = true)
    public List<FPV> selectAll();

    @Query(value = "select * from fpv_01 where existed = 0 and id = ?",nativeQuery = true)
    public FPV selectExistedById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update fpv_01 SET existed = ? where id = ?2")
    public int updateNameById(String name,Long id);

}
