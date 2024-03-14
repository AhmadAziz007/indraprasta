package com.universitas.indraprasta.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "mstmatkul", schema = "public")
public class MstMatkul {
    @Id
    @SequenceGenerator(name = "mstmatkul_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mstmatkul_seq")
    @Column(name = "matkulid")
    private Long matkulId;

    @Column(name = "mhsid")
    private Long mhsId;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "pelajaran", length = 20)
    private String pelajaran;

    @Column(name = "kehadiran")
    private BigDecimal kehadiran;

    @Column(name = "nilai")
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

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}
