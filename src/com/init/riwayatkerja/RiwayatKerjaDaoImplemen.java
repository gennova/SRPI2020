/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayatkerja;

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
public class RiwayatKerjaDaoImplemen implements RiwayatKerjaDao {

    private final Connection connection;
    private final String sqlInsertRiwayatKerja = "insert into riwayatkerja(idbidangkerja,idcabang,idunit,keterangan,tglawal,tglakhir,idsuster) values(?,?,?,?,?,?,?)";
    private final String sqlUpdateRiwayatKerja = "update riwayatkerja set idbidangkerja=?,idcabang=?,idunit=?,keterangan=?,tglawal=?,tglakhir=?,idsuster=? where id=?";
    private final String sqlGetAllRiwayatKerjaByIDSuster = "select * from riwayatkerja where idsuster=?";
    private final String sqlGetAllRiwayatKerjaByID = "select * from riwayatkerja where id=?";

    public RiwayatKerjaDaoImplemen(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertRiwayatKerja(RiwayatKerja kerja) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsertRiwayatKerja);
            statement.setInt(1, kerja.getBidangKerja().getId());
            statement.setInt(2, kerja.getCabang().getIdCabang());
            statement.setInt(3, kerja.getUnit().getID());
            statement.setString(4, kerja.getKeterangan());
            statement.setString(5, kerja.getTgl_awal());
            statement.setString(6, kerja.getTgl_akhir());
            statement.setInt(7, kerja.getSuster().getID());
            int status = statement.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateRiwayatKerja(RiwayatKerja kerja) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdateRiwayatKerja);
            statement.setInt(1, kerja.getBidangKerja().getId());
            statement.setInt(2, kerja.getCabang().getIdCabang());
            statement.setInt(3, kerja.getUnit().getID());
            statement.setString(4, kerja.getKeterangan());
            statement.setString(5, kerja.getTgl_awal());
            statement.setString(6, kerja.getTgl_akhir());
            statement.setInt(7, kerja.getSuster().getID());
            statement.setInt(8, kerja.getID());
            int status = statement.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbaharui");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteRiwayatKerja(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from riwayatkerja where id=?");
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<RiwayatKerja> getAllRiwayatKerjaByIDSuster(int idsuster) {
        PreparedStatement ps;
        ResultSet rs;
        List<RiwayatKerja> list = null;
        try {
            list = new ArrayList<>();
            ps = connection.prepareStatement(sqlGetAllRiwayatKerjaByIDSuster);
            ps.setInt(1, idsuster);
            rs = ps.executeQuery();
            while (rs.next()) {
                RiwayatKerja kerja = new RiwayatKerja();
                kerja.setID(rs.getInt("id"));
                kerja.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                kerja.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                kerja.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                kerja.setKeterangan(rs.getString("keterangan"));
                kerja.setTgl_awal(rs.getString("tglawal"));
                kerja.setTgl_akhir(rs.getString("tglakhir"));
                kerja.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
                list.add(kerja);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public RiwayatKerja getRiwayatKerjaByID(int id) {
        PreparedStatement ps;
        ResultSet rs;
        RiwayatKerja kerja = null;
        try {
            ps = connection.prepareStatement(sqlGetAllRiwayatKerjaByID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                kerja = new RiwayatKerja();
                kerja.setID(rs.getInt("id"));
                kerja.setBidangKerja(DaoFactory.getBidangKerjaDao().getBidangKerjaByID(rs.getInt("idbidangkerja")));
                kerja.setCabang(DaoFactory.getCabangDao().getCabangByID(rs.getInt("idcabang")));
                kerja.setUnit(DaoFactory.getUnitDao().getUnitByID(rs.getInt("idunit")));
                kerja.setKeterangan(rs.getString("keterangan"));
                kerja.setTgl_awal(rs.getString("tglawal"));
                kerja.setTgl_akhir(rs.getString("tglakhir"));
                kerja.setSuster(DaoFactory.getSusterDao().getSusterByID(rs.getInt("idsuster")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RiwayatKerjaDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kerja;
    }

}
