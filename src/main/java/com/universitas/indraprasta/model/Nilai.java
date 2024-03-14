package com.universitas.indraprasta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "getnilai", schema = "public")
public class Nilai {
    @Id
    @Column(name = "nim")
    private String nim;

    @Column(name = "nama", length = 20)
    private String nama;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "pelajaran", length = 20)
    private String pelajaran;

    @Column(name = "kehadiran")
    private BigDecimal kehadiran;

    @Column(name = "nilai")
    private BigDecimal nilai;

    @Column(name = "nilai_semester")
    private BigDecimal nilaiSemester;

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

    public BigDecimal getNilaiSemester() {
        return nilaiSemester;
    }

    public void setNilaiSemester(BigDecimal nilaiSemester) {
        this.nilaiSemester = nilaiSemester;
    }
}
