package com.universitas.indraprasta.controller;

import com.universitas.indraprasta.dto.MstMatkulDto;
import com.universitas.indraprasta.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matkul")
public class MatkulController {
    @Autowired
    MatkulService matkulService;

    @PostMapping("/save")
    public ResponseEntity<?> createMatkul(@RequestBody MstMatkulDto request){
        return matkulService.createMatkul(request);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMatkul(@RequestBody MstMatkulDto request){
        return matkulService.updateMatkul(request);
    }

    @GetMapping("/get/{nameSemester}")
    public ResponseEntity<?> getSemester(@PathVariable Integer semester){
        return matkulService.getSemester(semester);
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAll(){
        return matkulService.getAllMatkul();
    }
}
