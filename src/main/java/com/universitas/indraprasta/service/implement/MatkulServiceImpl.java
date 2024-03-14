package com.universitas.indraprasta.service.implement;

import com.universitas.indraprasta.common.ResponseDTO;
import com.universitas.indraprasta.dto.DtoMatkulView;
import com.universitas.indraprasta.dto.MstMatkulDto;
import com.universitas.indraprasta.model.MstMatkul;
import com.universitas.indraprasta.repository.MatkulRepository;
import com.universitas.indraprasta.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.universitas.indraprasta.common.Checker.isNullStr;
import static java.util.Objects.isNull;

@Service(value = "matkulService")
public class MatkulServiceImpl implements MatkulService {
    @Autowired
    MatkulRepository matkulRepo;

    @Override
    public ResponseEntity<?> createMatkul(MstMatkulDto requestDTO) {
        ResponseDTO response = new ResponseDTO();

        if (isNull(requestDTO.getSemester()) && isNullStr(requestDTO.getPelajaran())) {
            response.setCode("204");
            response.setMessage("Field mandatory tidak boleh kosong");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MstMatkul matkul = new MstMatkul();
        matkul.setPelajaran(requestDTO.getPelajaran());
        matkul.setSemester(requestDTO.getSemester());

        matkulRepo.save(matkul);
        response.setCode("200");
        response.setData(matkul);
        response.setMessage("Master Matkul has been saved successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> updateMatkul(MstMatkulDto requestDTO) {
        ResponseDTO response = new ResponseDTO();
        MstMatkul matkul = matkulRepo.findBySemester(requestDTO.getSemester());

        if (isNull(requestDTO.getSemester()) && isNullStr(requestDTO.getPelajaran())) {
            response.setCode("204");
            response.setMessage("Field mandatory tidak boleh kosong");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (matkul != null){
            if (requestDTO.getMatkulId() == null) {
                matkul.setMatkulId(matkul.getMatkulId());
            }
            matkul.setPelajaran(requestDTO.getPelajaran());
            matkul.setSemester(requestDTO.getSemester());

            matkulRepo.save(matkul);
        }

        response.setCode("200");
        response.setData(matkul);
        response.setMessage("Master Matkul has been saved successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllMatkul() {
        ResponseDTO response = new ResponseDTO();
        List<MstMatkul> matkulList = matkulRepo.findAll();

        List<DtoMatkulView> dtoView = new ArrayList<>();
        matkulList.forEach(data ->{
            DtoMatkulView view = new DtoMatkulView();
            view.setSemester(data.getSemester());
            view.setPelajaran(data.getPelajaran());
            dtoView.add(view);
        });

        response.setCode("200");
        response.setData(dtoView);
        response.setMessage("Get All Data successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getSemester(Integer semester) {
        ResponseDTO response = new ResponseDTO();
        MstMatkul matkul = matkulRepo.findBySemester(semester);
        if (matkul == null){
            response.setCode("204");
            response.setMessage("Semsster " + matkul + " not found");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        DtoMatkulView dtoMatkulView = new DtoMatkulView();
        dtoMatkulView.setSemester(matkul.getSemester());
        dtoMatkulView.setPelajaran(matkul.getPelajaran());

        response.setCode("200");
        response.setData(dtoMatkulView);
        response.setMessage("Get Data By Master food successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
