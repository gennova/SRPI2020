/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayatkerja;

import java.util.List;

/**
 *
 * @author laravel
 */
public interface RiwayatKerjaDao {

    public void InsertRiwayatKerja(RiwayatKerja kerja);

    public void UpdateRiwayatKerja(RiwayatKerja kerja);

    public void DeleteRiwayatKerja(int id);

    public List<RiwayatKerja> getAllRiwayatKerjaByIDSuster(int idsuster);

    public RiwayatKerja getRiwayatKerjaByID(int id);
}
