/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.nonformal;

import com.ypii.suster.Suster;

/**
 *
 * @author laravel
 */
public class PendidikanNonFormal {

    private int id;
    private String NamaLP;
    private String AlamatLP;
    private String MateriLP;
    private String TglMulai;
    private String TglSelesai;
    private Suster suster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLP() {
        return NamaLP;
    }

    public void setNamaLP(String NamaLP) {
        this.NamaLP = NamaLP;
    }

    public String getAlamatLP() {
        return AlamatLP;
    }

    public void setAlamatLP(String AlamatLP) {
        this.AlamatLP = AlamatLP;
    }

    public String getMateriLP() {
        return MateriLP;
    }

    public void setMateriLP(String MateriLP) {
        this.MateriLP = MateriLP;
    }

    public String getTglMulai() {
        return TglMulai;
    }

    public void setTglMulai(String TglMulai) {
        this.TglMulai = TglMulai;
    }

    public String getTglSelesai() {
        return TglSelesai;
    }

    public void setTglSelesai(String TglSelesai) {
        this.TglSelesai = TglSelesai;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

}
