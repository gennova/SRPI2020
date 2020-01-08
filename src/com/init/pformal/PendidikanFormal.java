/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pformal;

import com.init.pendidikanterakhir.PendidikanTerakhir;
import com.ypii.suster.Suster;

/**
 *
 * @author laravel
 */
public class PendidikanFormal {

    private int IDPendidikan;
    private PendidikanTerakhir pendidikanTerakhir;
    private Suster suster;
    private String NamaSP;
    private String AlamatSP;
    private String TglMasuk;
    private String TglLulus;

    public int getIDPendidikan() {
        return IDPendidikan;
    }

    public void setIDPendidikan(int IDPendidikan) {
        this.IDPendidikan = IDPendidikan;
    }

    public PendidikanTerakhir getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(PendidikanTerakhir pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getNamaSP() {
        return NamaSP;
    }

    public void setNamaSP(String NamaSP) {
        this.NamaSP = NamaSP;
    }

    public String getAlamatSP() {
        return AlamatSP;
    }

    public void setAlamatSP(String AlamatSP) {
        this.AlamatSP = AlamatSP;
    }

    public String getTglMasuk() {
        return TglMasuk;
    }

    public void setTglMasuk(String TglMasuk) {
        this.TglMasuk = TglMasuk;
    }

    public String getTglLulus() {
        return TglLulus;
    }

    public void setTglLulus(String TglLulus) {
        this.TglLulus = TglLulus;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

}
