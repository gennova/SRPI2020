/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pformal;

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
public class PendidikanFormalDaoImplemen implements PendidikanFormalDao {

    private final Connection connection;
    private final String sqlInsertPendidikanFormal = "insert into pendidikanformal(idpendidikan,namasp,alamatsp,tglmasuk,tgllulus,idsuster) values (?,?,?,?,?,?)";
    private final String sqlUpdatePendidikanFormal = "update pendidikanformal set idpendidikan=?,namasp=?,alamatsp=?,tglmasuk=?,tgllulus=?,idsuster=? where id=?";
    private final String sqlGetPendidikanFormalByIDSuster = "select * from pendidikanformal where idsuster=?";
    private final String sqlGetPendidikanFormalByID = "select * from pendidikanformal where id=?";
    private final String sqlDeletePendidikanFormalByID = "delete from pendidikanformal where id=?";

    public PendidikanFormalDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertFormal(PendidikanFormal formal) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsertPendidikanFormal);
            statement.setInt(1, formal.getPendidikanTerakhir().getId());
            statement.setString(2, formal.getNamaSP());
            statement.setString(3, formal.getAlamatSP());
            statement.setString(4, formal.getTglMasuk());
            statement.setString(5, formal.getTglLulus());
            statement.setInt(6, formal.getSuster().getID());
            int id = statement.executeUpdate();
            if (id == 1) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DITAMBAHKAN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateFormal(PendidikanFormal formal) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdatePendidikanFormal);
            statement.setInt(1, formal.getPendidikanTerakhir().getId());
            statement.setString(2, formal.getNamaSP());
            statement.setString(3, formal.getAlamatSP());
            statement.setString(4, formal.getTglMasuk());
            statement.setString(5, formal.getTglLulus());
            statement.setInt(6, formal.getSuster().getID());
            statement.setInt(7, formal.getIDPendidikan());
            int id = statement.executeUpdate();
            if (id == 1) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIUPDATE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PendidikanFormal> getAllPendidikanFormalByIDSuster(int id) {
        PreparedStatement ps;
        ResultSet rs;
        List<PendidikanFormal> list = null;
        try {
            ps = connection.prepareStatement(sqlGetPendidikanFormalByIDSuster);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                PendidikanFormal formal = new PendidikanFormal();
                formal.setIDPendidikan(rs.getInt("id"));
                formal.setPendidikanTerakhir(DaoFactory.getPendidikanTerakhirDao().getPendidikanByID(rs.getInt("idpendidikan")));
                formal.setNamaSP(rs.getString("namasp"));
                formal.setAlamatSP(rs.getString("alamatsp"));
                formal.setTglMasuk(rs.getString("tglmasuk"));
                formal.setTglLulus(rs.getString("tgllulus"));
                formal.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
                list.add(formal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void DeleteFormal(PendidikanFormal formal) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDeletePendidikanFormalByID);
            ps.setInt(1, formal.getIDPendidikan());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PendidikanFormal> getAllPendidikanFormal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PendidikanFormal getAllPendidikanFormalByID(int id) {
        PreparedStatement ps;
        ResultSet rs;
        PendidikanFormal formal = null;
        try {
            ps = connection.prepareStatement(sqlGetPendidikanFormalByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                formal = new PendidikanFormal();
                formal.setIDPendidikan(rs.getInt("id"));
                formal.setPendidikanTerakhir(DaoFactory.getPendidikanTerakhirDao().getPendidikanByID(rs.getInt("idpendidikan")));
                formal.setNamaSP(rs.getString("namasp"));
                formal.setAlamatSP(rs.getString("alamatsp"));
                formal.setTglMasuk(rs.getString("tglmasuk"));
                formal.setTglLulus(rs.getString("tgllulus"));
                formal.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formal;
    }

}
