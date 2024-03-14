package com.universitas.indraprasta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MstMahasiswaDto {
    private Long mhsId;
    private String nim;
    private String nama;
    private String alamat;

    public Long getMhsId() {
        return mhsId;
    }

    public void setMhsId(Long mhsId) {
        this.mhsId = mhsId;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
