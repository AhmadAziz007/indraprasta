package com.universitas.indraprasta.service.implement;

import com.universitas.indraprasta.common.ResponseDTO;
import com.universitas.indraprasta.dto.DtoMahasiswaView;
import com.universitas.indraprasta.dto.MstMahasiswaDto;
import com.universitas.indraprasta.model.MstMahasiswa;
import com.universitas.indraprasta.repository.MahasiswaRepository;
import com.universitas.indraprasta.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.universitas.indraprasta.common.Checker.isNullStr;
import static java.util.Objects.isNull;

@Service(value = "mahasiswaService")
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    MahasiswaRepository mahasiswaRepo;

    @Override
    public ResponseEntity<?> createMahasiswa(MstMahasiswaDto requestDTO) {
        ResponseDTO response = new ResponseDTO();

        MstMahasiswa mhsEntity = new MstMahasiswa();
        MstMahasiswa existingMhs = mahasiswaRepo.findByMhs(requestDTO.getNim());
        if (existingMhs != null) {
            response.setCode("409");
            response.setMessage("NIM " + requestDTO.getNim() + " already exists");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        if (isNullStr(requestDTO.getNim()) && isNullStr(requestDTO.getNama()) && isNullStr(requestDTO.getAlamat())) {
            response.setCode("204");
            response.setMessage("Field mandatory tidak boleh kosong");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        mhsEntity.setNim(requestDTO.getNim());
        mhsEntity.setNama(requestDTO.getNama());
        mhsEntity.setAlamat(requestDTO.getAlamat());

        mahasiswaRepo.save(mhsEntity);
        response.setCode("200");
        response.setData(mhsEntity);
        response.setMessage("Master Mahasiswa has been saved successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateMahasiswa(MstMahasiswaDto requestDTO) {
        ResponseDTO response = new ResponseDTO();
        MstMahasiswa mhs = mahasiswaRepo.findByMhs(requestDTO.getNim());
        if (mhs == null) {
            response.setCode("204");
            response.setMessage("Nim " + requestDTO.getNim() + " not found");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (isNullStr(requestDTO.getNim()) || isNullStr(requestDTO.getNama()) || isNullStr(requestDTO.getAlamat())) {
            response.setCode("204");
            response.setMessage("Field mandatory tidak boleh kosong");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (mhs != null){
            if (requestDTO.getMhsId() == null){
                mhs.setMhsId(mhs.getMhsId());
            }
            mhs.setNim(requestDTO.getNim());
            mhs.setNama(requestDTO.getNama());
            mhs.setAlamat(requestDTO.getAlamat());

            mahasiswaRepo.save(mhs);
        }

        response.setCode("200");
        response.setData(mhs);
        response.setMessage("Master Mahasiswa has been saved successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> getMahasiswa(String nim) {
        ResponseDTO response = new ResponseDTO();
        MstMahasiswa mhs = mahasiswaRepo.findByMhs(nim);
        if (mhs == null) {
            response.setCode("204");
            response.setMessage("Nim " + mhs + " not found");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        DtoMahasiswaView dtoView = new DtoMahasiswaView();
        dtoView.setNim(mhs.getNim());
        dtoView.setNama(mhs.getNama());
        dtoView.setAlamat(mhs.getAlamat());

        response.setCode("200");
        response.setData(dtoView);
        response.setMessage("Get Data By Master food successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        ResponseDTO response = new ResponseDTO();
        List<MstMahasiswa> mhsList = mahasiswaRepo.findAll();

        List<DtoMahasiswaView> dtoView = new ArrayList<>();
        mhsList.forEach(data ->{
            DtoMahasiswaView view = new DtoMahasiswaView();
            view.setNim(data.getNim());
            view.setNama(data.getNama());
            view.setAlamat(data.getAlamat());
            dtoView.add(view);
        });

        response.setCode("200");
        response.setData(dtoView);
        response.setMessage("Get All Data successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> deleteMahasiswa(String nim) {
        ResponseDTO response = new ResponseDTO();
        MstMahasiswa mhs = mahasiswaRepo.findByMhs(nim);
        if (mhs == null) {
            response.setCode("204");
            response.setMessage("Nim " + mhs + " not found");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        mahasiswaRepo.delete(mhs);
        response.setCode("200");
        response.setData(mhs);
        response.setMessage("Delete Data By Master Mahasiswa successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
