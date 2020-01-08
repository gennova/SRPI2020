/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.biara;

import com.init.biara.*;
import java.util.List;

/**
 *
 * @author amnesia
 */
public interface BiaraDao {

    public List<Biara> getAllBiara();

    public Biara getBiaraByID(int id);

    public Biara getBiaraByKode(String kode);

    public Biara getBiaraByNama(String nama);

    public void InsertBiara(Biara biara);

    public void UpdateBiaraByID(Biara biara);

    public void DeleteBiaraByID(Biara biara);
}
