/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pformal;

import java.util.List;

/**
 *
 * @author laravel
 */
public interface PendidikanFormalDao {

    public void InsertFormal(PendidikanFormal formal);

    public void UpdateFormal(PendidikanFormal formal);

    public void DeleteFormal(PendidikanFormal formal);

    public List<PendidikanFormal> getAllPendidikanFormal();
    
    public List<PendidikanFormal> getAllPendidikanFormalByIDSuster(int id);

    public PendidikanFormal getAllPendidikanFormalByID(int id);
    
    

}
