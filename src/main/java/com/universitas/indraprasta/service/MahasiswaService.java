package com.universitas.indraprasta.service;

import com.universitas.indraprasta.dto.MstMahasiswaDto;
import org.springframework.http.ResponseEntity;

public interface MahasiswaService{
    public ResponseEntity<?> createMahasiswa(MstMahasiswaDto requestDTO);

    public ResponseEntity<?> updateMahasiswa(MstMahasiswaDto requestDTO);

    public ResponseEntity<?> getMahasiswa(String nim);

    public ResponseEntity<?> getAll();

    public ResponseEntity<?> deleteMahasiswa(String nim);

}
