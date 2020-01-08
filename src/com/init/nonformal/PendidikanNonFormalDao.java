/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.nonformal;

import java.util.List;

/**
 *
 * @author laravel
 */
public interface PendidikanNonFormalDao {

    public void InsertNonFormal(PendidikanNonFormal nonFormal);

    public void UpdateNonFormal(PendidikanNonFormal nonFormal);

    public void DeleteNonFormal(PendidikanNonFormal nonFormal);
    
    public void DeleteNonFormalByID(String id);

    public List<PendidikanNonFormal> getAllPendidikanNonFormal();

    public List<PendidikanNonFormal> getAllPendidikanNonFormalByIDSuster(int id);

    public PendidikanNonFormal getPendidikanNonFormalByID(int id);

    public PendidikanNonFormal getPendidikanNonFormalByIDSuster(int id);
}
