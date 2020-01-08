/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.biara;

/**
 *
 * @author amnesia
 */
public class Biara {

    private int id;
    private String kodebiara;
    private String namabiara;
    private String alamatbiara;
    private String kotacabang;

    public Biara() {
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setKodeBiara(String kode) {
        this.kodebiara = kode;
    }

    public String getKodeBiara() {
        return this.kodebiara;
    }

    public void setNamaBiara(String nama) {
        this.namabiara = nama;
    }

    public String getNamaBiara() {
        return this.namabiara;
    }

    public String getAlamatbiara() {
        return alamatbiara;
    }

    public void setAlamatbiara(String alamatbiara) {
        this.alamatbiara = alamatbiara;
    }

    public String getKotacabang() {
        return kotacabang;
    }

    public void setKotacabang(String kotacabang) {
        this.kotacabang = kotacabang;
    }

}
