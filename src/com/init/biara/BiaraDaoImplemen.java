/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.biara;

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
public class BiaraDaoImplemen implements BiaraDao {

    private final Connection connection;
    private final String getAllBiara = "select * from biara";
    private final String sqlGetBiaraByID = "select * from biara where id=?";
    private final String sqlGetBiaraByNama = "select * from biara where namabiara=?";
    private final String sqlInsertBiara = "insert into biara(namabiara,alamatbiara,kotacabang) values (?,?,?)";
    private final String sqlUpdateBiara = "update biara set namabiara=?,alamatbiara=?,kotacabang=? where id=?";

    public BiaraDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Biara> getAllBiara() {
        PreparedStatement ps;
        ResultSet rs;
        List<Biara> biaras = null;
        try {
            ps = connection.prepareStatement(getAllBiara);
            rs = ps.executeQuery();
            biaras = new ArrayList<>();
            while (rs.next()) {
                Biara biara = new Biara();
                biara.setID(rs.getInt("id"));
                biara.setNamaBiara(rs.getString("namabiara"));
                biara.setAlamatbiara(rs.getString("alamatbiara"));
                biara.setKotacabang(rs.getString("kotacabang"));
                biaras.add(biara);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biaras;
    }

    @Override
    public Biara getBiaraByID(int id) {
        PreparedStatement ps;
        ResultSet rs;
        Biara biara = null;
        try {
            ps = connection.prepareCall(sqlGetBiaraByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                biara = new Biara();
                biara.setID(rs.getInt("id"));
                biara.setNamaBiara(rs.getString("namabiara"));
                biara.setAlamatbiara(rs.getString("alamatbiara"));
                biara.setKotacabang(rs.getString("kotacabang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biara;
    }

    @Override
    public Biara getBiaraByKode(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Biara getBiaraByNama(String nama) {
        PreparedStatement ps;
        ResultSet rs;
        Biara biara = null;
        try {
            ps = connection.prepareCall(sqlGetBiaraByNama);
            ps.setString(1, nama);
            rs = ps.executeQuery();
            while (rs.next()) {
                biara = new Biara();
                biara.setID(rs.getInt("id"));
                biara.setNamaBiara(rs.getString("namabiara"));
                biara.setAlamatbiara(rs.getString("alamatbiara"));
                biara.setKotacabang(rs.getString("kotacabang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biara;
    }

    @Override
    public void InsertBiara(Biara biara) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sqlInsertBiara);
            ps.setString(1, biara.getNamaBiara());
            ps.setString(2, biara.getAlamatbiara());
            ps.setString(3, biara.getKotacabang());
            int status = ps.executeUpdate();
            if (status==0) {
                JOptionPane.showMessageDialog(null, "Data biara berhasil ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateBiaraByID(Biara biara) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sqlUpdateBiara);
            ps.setString(1, biara.getNamaBiara());
            ps.setString(2, biara.getAlamatbiara());
            ps.setString(3, biara.getKotacabang());
            ps.setInt(4, biara.getID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data biara berhasil diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteBiaraByID(Biara biara) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from biara where id=?");
            ps.setInt(1, biara.getID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Biara berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(BiaraDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
