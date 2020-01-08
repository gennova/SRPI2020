/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ypii.suster;

import com.init.biara.Biara;

/**
 *
 * @author laravel
 */
public class Suster {

    private int ID; //1
    private String noInduk; //2
    private String namaSuster; //3
    private String namaAsli; //4
    private String namaBaru; //5
    private String tempatLahir; //6
    private String tglLahir; //7
    private String namaBaptis; //8
    private String tempatBaptis; //9
    private String tglBaptis; //10
    private String noSuratBaptis; //11
    private String tempatKrisma; //12
    private String tglKrisma; //13
    private String noSuratKrisma; //14
    private String ttsSuratKelahiran; //15
    private String ttsSuratWNI; //16
    private String ttsGantiNama; //17
    private String tglMasukBiara; //18
    private String tglMasukNovisiat; //19
    private String tglMasukPostulat; //20
    private String tglKaulSementara; //21
    private String tglKaulKekal; //22
    private String tglKeluar; //23
    private String tglMasukKembali; //24
    private String tglWafat; //25
    private String riwayatSebelumMembiara; //26
    private String lainLain; //27
    private String foto; //28
    private Biara biara; //29
    private String kotamasukbiara;//30
    private String kotanovisiat;//31
    private String kotapostulat;//32
    private String kotasementara;//33
    private String kotakaulkekal;//34

    private int tahunlamakarya;
    private int bulanlamakarya;
    private String status_keaktivan;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(String noInduk) {
        this.noInduk = noInduk;
    }

    public String getNamaSuster() {
        return namaSuster;
    }

    public void setNamaSuster(String namaSuster) {
        this.namaSuster = namaSuster;
    }

    public String getNamaAsli() {
        return namaAsli;
    }

    public void setNamaAsli(String namaAsli) {
        this.namaAsli = namaAsli;
    }

    public String getNamaBaru() {
        return namaBaru;
    }

    public void setNamaBaru(String namaBaru) {
        this.namaBaru = namaBaru;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNamaBaptis() {
        return namaBaptis;
    }

    public void setNamaBaptis(String namaBaptis) {
        this.namaBaptis = namaBaptis;
    }

    public String getTempatBaptis() {
        return tempatBaptis;
    }

    public void setTempatBaptis(String tempatBaptis) {
        this.tempatBaptis = tempatBaptis;
    }

    public String getTglBaptis() {
        return tglBaptis;
    }

    public void setTglBaptis(String tglBaptis) {
        this.tglBaptis = tglBaptis;
    }

    public String getNoSuratBaptis() {
        return noSuratBaptis;
    }

    public void setNoSuratBaptis(String noSuratBaptis) {
        this.noSuratBaptis = noSuratBaptis;
    }

    public String getTempatKrisma() {
        return tempatKrisma;
    }

    public void setTempatKrisma(String tempatKrisma) {
        this.tempatKrisma = tempatKrisma;
    }

    public String getTglKrisma() {
        return tglKrisma;
    }

    public void setTglKrisma(String tglKrisma) {
        this.tglKrisma = tglKrisma;
    }

    public String getNoSuratKrisma() {
        return noSuratKrisma;
    }

    public void setNoSuratKrisma(String noSuratKrisma) {
        this.noSuratKrisma = noSuratKrisma;
    }

    public String getTtsSuratKelahiran() {
        return ttsSuratKelahiran;
    }

    public void setTtsSuratKelahiran(String ttsSuratKelahiran) {
        this.ttsSuratKelahiran = ttsSuratKelahiran;
    }

    public String getTtsSuratWNI() {
        return ttsSuratWNI;
    }

    public void setTtsSuratWNI(String ttsSuratWNI) {
        this.ttsSuratWNI = ttsSuratWNI;
    }

    public String getTtsGantiNama() {
        return ttsGantiNama;
    }

    public void setTtsGantiNama(String ttsGantiNama) {
        this.ttsGantiNama = ttsGantiNama;
    }

    public String getTglMasukBiara() {
        return tglMasukBiara;
    }

    public void setTglMasukBiara(String tglMasukBiara) {
        this.tglMasukBiara = tglMasukBiara;
    }

    public String getTglMasukPostulat() {
        return tglMasukPostulat;
    }

    public void setTglMasukPostulat(String tglMasukPostulat) {
        this.tglMasukPostulat = tglMasukPostulat;
    }

    public String getTglKaulSementara() {
        return tglKaulSementara;
    }

    public void setTglKaulSementara(String tglKaulSementara) {
        this.tglKaulSementara = tglKaulSementara;
    }

    public String getTglKaulKekal() {
        return tglKaulKekal;
    }

    public void setTglKaulKekal(String tglKaulKekal) {
        this.tglKaulKekal = tglKaulKekal;
    }

    public String getTglKeluar() {
        return tglKeluar;
    }

    public void setTglKeluar(String tglKeluar) {
        this.tglKeluar = tglKeluar;
    }

    public String getTglMasukKembali() {
        return tglMasukKembali;
    }

    public void setTglMasukKembali(String tglMasukKembali) {
        this.tglMasukKembali = tglMasukKembali;
    }

    public String getTglWafat() {
        return tglWafat;
    }

    public void setTglWafat(String tglWafat) {
        this.tglWafat = tglWafat;
    }

    public String getRiwayatSebelumMembiara() {
        return riwayatSebelumMembiara;
    }

    public void setRiwayatSebelumMembiara(String riwayatSebelumMembiara) {
        this.riwayatSebelumMembiara = riwayatSebelumMembiara;
    }

    public String getLainLain() {
        return lainLain;
    }

    public void setLainLain(String lainLain) {
        this.lainLain = lainLain;
    }

    public String getTglMasukNovisiat() {
        return tglMasukNovisiat;
    }

    public void setTglMasukNovisiat(String tglMasukNovisiat) {
        this.tglMasukNovisiat = tglMasukNovisiat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTahunlamakarya() {
        return tahunlamakarya;
    }

    public void setTahunlamakarya(int tahunlamakarya) {
        this.tahunlamakarya = tahunlamakarya;
    }

    public int getBulanlamakarya() {
        return bulanlamakarya;
    }

    public void setBulanlamakarya(int bulanlamakarya) {
        this.bulanlamakarya = bulanlamakarya;
    }

    public Biara getBiara() {
        return biara;
    }

    public void setBiara(Biara biara) {
        this.biara = biara;
    }

    public String getKotamasukbiara() {
        return kotamasukbiara;
    }

    public void setKotamasukbiara(String kotamasukbiara) {
        this.kotamasukbiara = kotamasukbiara;
    }

    public String getKotanovisiat() {
        return kotanovisiat;
    }

    public void setKotanovisiat(String kotanovisiat) {
        this.kotanovisiat = kotanovisiat;
    }

    public String getKotapostulat() {
        return kotapostulat;
    }

    public void setKotapostulat(String kotapostulat) {
        this.kotapostulat = kotapostulat;
    }

    public String getKotasementara() {
        return kotasementara;
    }

    public void setKotasementara(String kotasementara) {
        this.kotasementara = kotasementara;
    }

    public String getKotakaulkekal() {
        return kotakaulkekal;
    }

    public void setKotakaulkekal(String kotakaulkekal) {
        this.kotakaulkekal = kotakaulkekal;
    }

    public void setStatus_keaktivan(String status_keaktivan) {
        this.status_keaktivan = status_keaktivan;
    }

    public String getStatus_keaktivan() {
        return status_keaktivan;
    }

}
