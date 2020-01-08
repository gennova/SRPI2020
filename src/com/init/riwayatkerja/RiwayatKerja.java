/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayatkerja;

import com.init.bidangkerja.BidangKerja;
import com.init.cabang.Cabang;
import com.init.unit.Unit;
import com.ypii.suster.Suster;

/**
 *
 * @author laravel
 */
public class RiwayatKerja {

    private int ID;
    private BidangKerja bidangKerja;
    private Cabang cabang;
    private Unit unit;
    private Suster suster;
    private String keterangan;
    private String tgl_awal;
    private String tgl_akhir;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BidangKerja getBidangKerja() {
        return bidangKerja;
    }

    public void setBidangKerja(BidangKerja bidangKerja) {
        this.bidangKerja = bidangKerja;
    }

    public Cabang getCabang() {
        return cabang;
    }

    public void setCabang(Cabang cabang) {
        this.cabang = cabang;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Suster getSuster() {
        return suster;
    }

    public void setSuster(Suster suster) {
        this.suster = suster;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTgl_awal() {
        return tgl_awal;
    }

    public void setTgl_awal(String tgl_awal) {
        this.tgl_awal = tgl_awal;
    }

    public String getTgl_akhir() {
        return tgl_akhir;
    }

    public void setTgl_akhir(String tgl_akhir) {
        this.tgl_akhir = tgl_akhir;
    }

}
