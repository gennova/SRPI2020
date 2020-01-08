/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.keluarga;

import com.ypii.suster.Suster;

/**
 *
 * @author laravel
 */
public class Keluarga {

    private int id;
    private String Jenis;
    private String Nama;
    private String Keterangan;
    private String Agama;
    private String Alamat;
    private String Telpon;
    private String TglLahir;
    private Suster suster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }

    public String getAgama() {
        return Agama;
    }

    public void setAgama(String Agama) {
        this.Agama = Agama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getTelpon() {
        return Telpon;
    }

    public void setTelpon(String Telpon) {
        this.Telpon = Telpon;
    }

    public String getTglLahir() {
        return TglLahir;
    }

    public void setTglLahir(String TglLahir) {
        this.TglLahir = TglLahir;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }
    
    
}
