package com.universitas.indraprasta.dto;

import java.math.BigDecimal;

public class MstMatkulDto {
    private Long matkulId;
    private Long mhsId;
    private Integer semester;
    private String pelajaran;
    private BigDecimal kehadiran;
    private String nim;
    private BigDecimal nilai;

    public Long getMatkulId() {
        return matkulId;
    }

    public void setMatkulId(Long matkulId) {
        this.matkulId = matkulId;
    }

    public Long getMhsId() {
        return mhsId;
    }

    public void setMhsId(Long mhsId) {
        this.mhsId = mhsId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public BigDecimal getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(BigDecimal kehadiran) {
        this.kehadiran = kehadiran;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}
