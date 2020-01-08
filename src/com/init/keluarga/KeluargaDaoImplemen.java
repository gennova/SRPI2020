/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.keluarga;

import com.init.tools.DaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author laravel
 */
public class KeluargaDaoImplemen implements KeluargaDao {

    private final Connection connection;
    private final String sqlInsertKeluarga = "insert into keluarga(jeniskeluarga,nama,keterangan,agama,alamat,telpon,tgllahir,idsuster) values (?,?,?,?,?,?,?,?)";
    private final String sqlGetAllKeluargaByIDSuster = "select * from keluarga where idsuster=?";
    private final String sqlGetKeluargaByID = "select * from keluarga where id=?";
    private final String sqlDeleteKeluargaByID = "delete from keluarga where id=?";

    public KeluargaDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertKeluarga(Keluarga keluarga) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sqlInsertKeluarga);
            ps.setString(1, keluarga.getJenis());
            ps.setString(2, keluarga.getNama());
            ps.setString(3, keluarga.getKeterangan());
            ps.setString(4, keluarga.getAgama());
            ps.setString(5, keluarga.getAlamat());
            ps.setString(6, keluarga.getTelpon());
            ps.setString(7, keluarga.getTglLahir());
            ps.setInt(8, keluarga.getSuster().getID());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data keluarga berhasil ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateKeluarga(Keluarga keluarga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteKeluarga(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDeleteKeluargaByID);
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if (status==1) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Keluarga> getAllKeluargaByIDSuster(int id) {
        PreparedStatement ps;
        ResultSet rs;
        List<Keluarga> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllKeluargaByIDSuster);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Keluarga k = new Keluarga();
                k.setId(rs.getInt("id"));
                k.setJenis(rs.getString("jeniskeluarga"));
                k.setNama(rs.getString("nama"));
                k.setKeterangan(rs.getString("keterangan"));
                k.setAgama(rs.getString("agama"));
                k.setAlamat(rs.getString("alamat"));
                k.setTelpon(rs.getString("telpon"));
                k.setTglLahir(rs.getString("tgllahir"));
                k.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Keluarga getKeluargaByID(int id) {
        PreparedStatement ps;
        ResultSet rs;
        Keluarga keluarga = null;
        try {
            ps = connection.prepareStatement(sqlGetKeluargaByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                keluarga = new Keluarga();
                keluarga.setId(rs.getInt("id"));
                keluarga.setJenis(rs.getString("jeniskeluarga"));
                keluarga.setNama(rs.getString("nama"));
                keluarga.setKeterangan(rs.getString("keterangan"));
                keluarga.setAgama(rs.getString("agama"));
                keluarga.setAlamat(rs.getString("alamat"));
                keluarga.setTelpon(rs.getString("telpon"));
                keluarga.setTglLahir(rs.getString("tgllahir"));
                keluarga.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KeluargaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return keluarga;
    }

}
