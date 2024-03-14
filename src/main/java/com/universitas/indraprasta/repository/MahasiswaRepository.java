package com.universitas.indraprasta.repository;

import com.universitas.indraprasta.model.MstMahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<MstMahasiswa, Long> {
    @Query(value = "select distinct a.nim from mstmahasiswa as a where a.nim = :nim", nativeQuery = true)
    MstMahasiswa findByNIM(@Param("nim") String nim);

    @Query(value = "select a.* from mstmahasiswa a where a.nim = :nim", nativeQuery = true)
    MstMahasiswa findByMhs(@Param("nim") String nim);

    @Query(value = "select a.* from mstmahasiswa as a order by a.nama asc", nativeQuery = true)
    List<MstMahasiswa> findAll();
}
