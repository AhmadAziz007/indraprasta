package com.universitas.indraprasta.service;

import com.universitas.indraprasta.dto.MstMatkulDto;
import org.springframework.http.ResponseEntity;

public interface MatkulService {
    public ResponseEntity<?> createMatkul(MstMatkulDto requestDTO);

    public ResponseEntity<?> updateMatkul(MstMatkulDto requestDTO);

    public ResponseEntity<?> getAllMatkul();

    public ResponseEntity<?> getSemester(Integer semester);

}
