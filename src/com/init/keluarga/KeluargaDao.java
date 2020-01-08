/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.keluarga;

import java.util.List;

/**
 *
 * @author laravel
 */
public interface KeluargaDao {

    public void InsertKeluarga(Keluarga keluarga);

    public void UpdateKeluarga(Keluarga keluarga);

    public void DeleteKeluarga(int id);

    public List<Keluarga> getAllKeluargaByIDSuster(int id);
    
    public Keluarga getKeluargaByID(int id);
}
