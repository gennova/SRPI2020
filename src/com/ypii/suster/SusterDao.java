/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ypii.suster;

import java.util.List;

/**
 *
 * @author laravel
 */
public interface SusterDao {

    public void InsertSuster(Suster suster);

    public void UpdateSuster(Suster suster);

    public void DeleteSuster(Suster suster);

    public List<Suster> getAllSuster();

    public List<Suster> getAllSusterByMasaKarya(int lama);

    public List<Suster> getAllSusterAllMasaKarya();

    public List<Suster> getAllSusterKaryaByBiara(int id);

    public Suster getSusterByID(int ID);

    public Suster getSusterByInduk(String noInduk);

    public List<Suster> getAllSusterByUsia(int usia);
    
    public List<Suster> getAllSusterAllUsia();
    
    public List<Suster> getSusterUltahToday();
}
