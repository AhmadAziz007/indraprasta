package com.universitas.indraprasta.controller;

import com.universitas.indraprasta.dto.MstMahasiswaDto;
import com.universitas.indraprasta.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {
    @Autowired
    MahasiswaService mhsService;

    @PostMapping("/save")
    public ResponseEntity<?> createMhs(@RequestBody MstMahasiswaDto request){
        return mhsService.createMahasiswa(request);
    }

    @PostMapping("/update/")
    public ResponseEntity<?> updateMhs(@RequestBody MstMahasiswaDto request){
        return mhsService.updateMahasiswa(request);
    }

    @GetMapping("/get/{nim}")
    public ResponseEntity<?> getMhsByNim(@PathVariable String nim){
        return mhsService.getMahasiswa(nim);
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAll(){
        return mhsService.getAll();
    }

    @DeleteMapping("/delete/{nim}")
    public ResponseEntity<?> getdeleteMhs(@PathVariable String nim){
        return mhsService.deleteMahasiswa(nim);
    }
}
