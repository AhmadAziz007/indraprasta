package com.universitas.indraprasta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mstmahasiswa", schema = "public")
public class MstMahasiswa {
    @Id
    @SequenceGenerator(name = "mstmahasiswa_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mstmahasiswa_seq")
    @Column(name = "mhsid")
    private Long mhsId;

    @Column(name = "nama", length = 20)
    private String nama;

    @Column(name = "nim")
    private String nim;

    @Column(name = "alamat")
    private String alamat;

    public Long getMhsId() {
        return mhsId;
    }

    public void setMhsId(Long mhsId) {
        this.mhsId = mhsId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
