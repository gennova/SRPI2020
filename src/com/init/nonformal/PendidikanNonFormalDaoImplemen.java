/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.nonformal;

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
public class PendidikanNonFormalDaoImplemen implements PendidikanNonFormalDao {

    private final Connection connection;
    private final String sqlInsertNonFormal = "insert into pendidikannonformal (namalp,alamatlp,materilp,tglmulai,tglselesai,idsuster) values (?,?,?,?,?,?)";
    private final String sqlGetAllPendidikanNonFormalByIDSuster = "select * from pendidikannonformal where idsuster=?";
    private final String sqlGetAllPendidikanNonFormalByID = "select * from pendidikannonformal where id=?";
    private final String sqlUpdateNonFormal = "update pendidikannonformal set namalp=?,alamatlp=?,materilp=?,tglmulai=?,tglselesai=?, idsuster=? where id=?";

    public PendidikanNonFormalDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertNonFormal(PendidikanNonFormal nonFormal) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sqlInsertNonFormal);
            ps.setString(1, nonFormal.getNamaLP());
            ps.setString(2, nonFormal.getAlamatLP());
            ps.setString(3, nonFormal.getMateriLP());
            ps.setString(4, nonFormal.getTglMulai());
            ps.setString(5, nonFormal.getTglSelesai());
            ps.setInt(6, nonFormal.getSuster().getID());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DITAMBAHKAN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanNonFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateNonFormal(PendidikanNonFormal nonFormal) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sqlUpdateNonFormal);
            ps.setString(1, nonFormal.getNamaLP());
            ps.setString(2, nonFormal.getAlamatLP());
            ps.setString(3, nonFormal.getMateriLP());
            ps.setString(4, nonFormal.getTglMulai());
            ps.setString(5, nonFormal.getTglSelesai());
            ps.setInt(6, nonFormal.getSuster().getID());
            ps.setInt(7, nonFormal.getId());
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIUPDATE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanNonFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteNonFormal(PendidikanNonFormal nonFormal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PendidikanNonFormal> getAllPendidikanNonFormal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PendidikanNonFormal> getAllPendidikanNonFormalByIDSuster(int id) {
        List<PendidikanNonFormal> lists = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(sqlGetAllPendidikanNonFormalByIDSuster);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            lists = new ArrayList<>();
            while (rs.next()) {
                PendidikanNonFormal nonFormal = new PendidikanNonFormal();
                nonFormal.setId(rs.getInt("id"));
                nonFormal.setNamaLP(rs.getString("namalp"));
                nonFormal.setAlamatLP(rs.getString("alamatlp"));
                nonFormal.setMateriLP(rs.getString("materilp"));
                nonFormal.setTglMulai(rs.getString("tglmulai"));
                nonFormal.setTglSelesai(rs.getString("tglselesai"));
                nonFormal.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
                lists.add(nonFormal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanNonFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lists;
    }

    @Override
    public PendidikanNonFormal getPendidikanNonFormalByID(int id) {
        PendidikanNonFormal nonFormal = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(sqlGetAllPendidikanNonFormalByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                nonFormal = new PendidikanNonFormal();
                nonFormal.setId(rs.getInt("id"));
                nonFormal.setNamaLP(rs.getString("namalp"));
                nonFormal.setAlamatLP(rs.getString("alamatlp"));
                nonFormal.setMateriLP(rs.getString("materilp"));
                nonFormal.setTglMulai(rs.getString("tglmulai"));
                nonFormal.setTglSelesai(rs.getString("tglselesai"));
                nonFormal.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanNonFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nonFormal;
    }

    @Override
    public PendidikanNonFormal getPendidikanNonFormalByIDSuster(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteNonFormalByID(String id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from pendidikannonformal where id=?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PendidikanNonFormalDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
