package com.universitas.indraprasta.repository;

import com.universitas.indraprasta.model.MstMatkul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatkulRepository extends JpaRepository<MstMatkul, Long> {
    @Query(value = "select distinct a.* from mstmatkul a where a.semester = :semester", nativeQuery = true)
    MstMatkul findBySemester(@Param("semester") Integer semester);

    @Query(value = "select distinct a.* from mstmatkul as a order by a.semester asc", nativeQuery = true)
    List<MstMatkul> findAll();
}
