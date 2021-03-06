/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ypii.suster;

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
public class SusterDaoImplemen implements SusterDao {

    private final Connection connection;
    private final String sqlInsertSuster = "call spInsertSuster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlUpdateSuster = "call spUpdateSuster(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String sqlGetAllSuster = "select * from suster";
    private final String sqlGetAllSusterUltahToday = "select * from suster where MONTH(tgllahir)=MONTH(CURDATE()) and DAY(tgllahir)=DAY(CURDATE())";
    private final String sqlGetAllSusterByMasakarya = "SELECT *,TIMESTAMPDIFF(YEAR,tglkaulkekal,CURDATE()) AS tahunlama, IF(MONTH(CURDATE()) - MONTH(tglkaulkekal)<0,12+ (MONTH(CURDATE()) - MONTH(tglkaulkekal)),MONTH(CURDATE()) - MONTH(tglkaulkekal)) AS bulanlama from suster WHERE YEAR(NOW())-YEAR(tglkaulkekal)=?;  ";
    private final String sqlGetAllSusterAllMasakarya = "SELECT *, TIMESTAMPDIFF(YEAR,tglkaulkekal,CURDATE()) AS tahunlama, IF(MONTH(CURDATE()) - MONTH(tglkaulkekal)<0,12+ (MONTH(CURDATE()) - MONTH(tglkaulkekal)),MONTH(CURDATE()) - MONTH(tglkaulkekal)) AS bulanlama FROM suster;  ";
    private final String sqlGetAllSusterKaryaByIDBiara = "SELECT *,TIMESTAMPDIFF(YEAR,tglkaulkekal,CURDATE()) AS tahunlama, IF(MONTH(CURDATE()) - MONTH(tglkaulkekal)<0,12+ (MONTH(CURDATE()) - MONTH(tglkaulkekal)),MONTH(CURDATE()) - MONTH(tglkaulkekal)) AS bulanlama from suster WHERE biara=?;  ";
    private final String sqlGetAllSusterByID = "select * from suster where id=?";
    private final String sqlGetAllSusterByInduk = "select * from suster where noinduk=?;";
    private final String sqlGetAllSusterAllUsia = "SELECT *, TIMESTAMPDIFF(YEAR,tgllahir,CURDATE()) AS tahunlama, IF(MONTH(CURDATE()) - MONTH(tgllahir)<0,12+ (MONTH(CURDATE()) - MONTH(tgllahir)),MONTH(CURDATE()) - MONTH(tgllahir)) AS bulanlama FROM suster;  ";
    private final String sqlGetAllSusterByUsia = "SELECT *, TIMESTAMPDIFF(YEAR,tgllahir,CURDATE()) AS tahunlama, IF(MONTH(CURDATE()) - MONTH(tgllahir)<0,12+ (MONTH(CURDATE()) - MONTH(tgllahir)),MONTH(CURDATE()) - MONTH(tgllahir)) AS bulanlama FROM suster where TIMESTAMPDIFF(YEAR,tgllahir,CURDATE())=?;  ";

    public SusterDaoImplemen(Connection c) {
        this.connection = c;
    }

    @Override
    public void InsertSuster(Suster suster) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlInsertSuster);
            statement.setString(1, suster.getNoInduk());
            statement.setString(2, suster.getNamaSuster());
            statement.setString(3, suster.getNamaAsli());
            statement.setString(4, suster.getNamaBaru());
            statement.setString(5, suster.getTempatLahir());
            statement.setString(6, suster.getTglLahir());
            statement.setString(7, suster.getNamaBaptis());
            statement.setString(8, suster.getTempatBaptis());
            statement.setString(9, suster.getTglBaptis());
            statement.setString(10, suster.getNoSuratBaptis());
            statement.setString(11, suster.getTempatKrisma());
            statement.setString(12, suster.getTglKrisma());
            statement.setString(13, suster.getNoSuratKrisma());
            statement.setString(14, suster.getTtsSuratKelahiran());
            statement.setString(15, suster.getTtsSuratWNI());
            statement.setString(16, suster.getTtsGantiNama());
            statement.setString(17, suster.getTglMasukBiara());
            statement.setString(18, suster.getTglMasukPostulat());
            statement.setString(19, suster.getTglMasukNovisiat());
            statement.setString(20, suster.getTglKaulSementara());
            statement.setString(21, suster.getTglKaulKekal());
            statement.setString(22, suster.getTglKeluar());
            statement.setString(23, suster.getTglMasukKembali());
            statement.setString(24, suster.getTglWafat());
            statement.setString(25, suster.getRiwayatSebelumMembiara());
            statement.setString(26, suster.getLainLain());
            statement.setString(27, suster.getFoto());
            statement.setInt(28, suster.getBiara().getID());
            statement.setString(29, suster.getKotamasukbiara());
            statement.setString(30, suster.getKotapostulat());
            statement.setString(31, suster.getKotanovisiat());
            statement.setString(32, suster.getKotasementara());
            statement.setString(33, suster.getKotakaulkekal());
            statement.setString(34, suster.getStatus_keaktivan());
            int status = statement.executeUpdate();
            if (status == 0) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DITAMBAHKAN");
            } else {
                JOptionPane.showMessageDialog(null, "DATA GAGAL DITAMBAHKAN");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateSuster(Suster suster) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sqlUpdateSuster);
            statement.setString(1, suster.getNoInduk());
            statement.setString(2, suster.getNamaSuster());
            statement.setString(3, suster.getNamaAsli());
            statement.setString(4, suster.getNamaBaru());
            statement.setString(5, suster.getTempatLahir());
            statement.setString(6, suster.getTglLahir());
            statement.setString(7, suster.getNamaBaptis());
            statement.setString(8, suster.getTempatBaptis());
            statement.setString(9, suster.getTglBaptis());
            statement.setString(10, suster.getNoSuratBaptis());
            statement.setString(11, suster.getTempatKrisma());
            statement.setString(12, suster.getTglKrisma());
            statement.setString(13, suster.getNoSuratKrisma());
            statement.setString(14, suster.getTtsSuratKelahiran());
            statement.setString(15, suster.getTtsSuratWNI());
            statement.setString(16, suster.getTtsGantiNama());
            statement.setString(17, suster.getTglMasukBiara());
            statement.setString(18, suster.getTglMasukPostulat());
            statement.setString(19, suster.getTglMasukNovisiat());
            statement.setString(20, suster.getTglKaulSementara());
            statement.setString(21, suster.getTglKaulKekal());
            statement.setString(22, suster.getTglKeluar());
            statement.setString(23, suster.getTglMasukKembali());
            statement.setString(24, suster.getTglWafat());
            statement.setString(25, suster.getRiwayatSebelumMembiara());
            statement.setString(26, suster.getLainLain());
            statement.setString(27, suster.getFoto());
            statement.setInt(28, suster.getBiara().getID());
            statement.setString(29, suster.getKotamasukbiara());
            statement.setString(30, suster.getKotapostulat());
            statement.setString(31, suster.getKotanovisiat());
            statement.setString(32, suster.getKotasementara());
            statement.setString(33, suster.getKotakaulkekal());
            statement.setString(34, suster.getStatus_keaktivan()); 
            statement.setInt(35, suster.getID());
            int status = statement.executeUpdate();
            if (status == 0) {
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DIUPDATE");
            } else {
                JOptionPane.showMessageDialog(null, "DATA GAGAL DIUPDATE");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void DeleteSuster(Suster suster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Suster> getAllSuster() {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSuster);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Suster getSusterByID(int ID) {
        PreparedStatement ps;
        ResultSet rs;
        Suster s = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterByID);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public Suster getSusterByInduk(String noInduk) {
        PreparedStatement ps;
        ResultSet rs;
        Suster s = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterByInduk);
            ps.setString(1, noInduk);
            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println("adaaaaaaa");
                s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public List<Suster> getAllSusterByMasaKarya(int lama) {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterByMasakarya);
            ps.setInt(1, lama);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setTahunlamakarya(rs.getInt("tahunlama"));
                s.setBulanlamakarya(rs.getInt("bulanlama"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Suster> getAllSusterAllMasaKarya() {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterAllMasakarya);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setTahunlamakarya(rs.getInt("tahunlama"));
                s.setBulanlamakarya(rs.getInt("bulanlama"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Suster> getAllSusterKaryaByBiara(int id) {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterKaryaByIDBiara);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setTahunlamakarya(rs.getInt("tahunlama"));
                s.setBulanlamakarya(rs.getInt("bulanlama"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Suster> getAllSusterByUsia(int usia) {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterByUsia);
            ps.setInt(1, usia);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setTahunlamakarya(rs.getInt("tahunlama"));
                s.setBulanlamakarya(rs.getInt("bulanlama"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Suster> getAllSusterAllUsia() {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterAllUsia);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setTahunlamakarya(rs.getInt("tahunlama"));
                s.setBulanlamakarya(rs.getInt("bulanlama"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Suster> getSusterUltahToday() {
        PreparedStatement ps;
        ResultSet rs;
        List<Suster> list = null;
        try {
            ps = connection.prepareStatement(sqlGetAllSusterUltahToday);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Suster s = new Suster();
                s.setID(rs.getInt("id"));
                s.setNoInduk(rs.getString("noinduk"));
                s.setNamaSuster(rs.getString("namasuster"));
                s.setNamaAsli(rs.getString("namaasli"));
                s.setNamaBaru(rs.getString("namabaru"));
                s.setTempatLahir(rs.getString("tempatlahir"));
                s.setTglLahir(rs.getString("tgllahir"));
                s.setNamaBaptis(rs.getString("namabaptis"));
                s.setTempatBaptis(rs.getString("tempatbaptis"));
                s.setTglBaptis(rs.getString("tglbaptis"));
                s.setNoSuratBaptis(rs.getString("nosuratbaptis"));
                s.setTempatKrisma(rs.getString("tempatkrisma"));
                s.setTglKrisma(rs.getString("tglkrisma"));
                s.setNoSuratKrisma(rs.getString("nosuratkrisma"));
                s.setTtsSuratKelahiran(rs.getString("suratkelahiran"));
                s.setTtsSuratWNI(rs.getString("suratwni"));
                s.setTtsGantiNama(rs.getString("gantinama"));
                s.setTglMasukBiara(rs.getString("tglmasukbiara"));
                s.setTglMasukPostulat(rs.getString("tglmasukpostulat"));
                s.setTglMasukNovisiat(rs.getString("tglmasuknovisiat"));
                s.setTglKaulSementara(rs.getString("tglkaulsementara"));
                s.setTglKaulKekal(rs.getString("tglkaulkekal"));
                s.setTglKeluar(rs.getString("tglkeluar"));
                s.setTglMasukKembali(rs.getString("tglmasuklagi"));
                s.setTglWafat(rs.getString("tglwafat"));
                s.setRiwayatSebelumMembiara(rs.getString("riwayatsebelumbiara"));
                s.setLainLain(rs.getString("lainlain"));
                s.setFoto(rs.getString("foto"));
                s.setBiara(DaoFactory.getBiaraDao().getBiaraByID(rs.getInt("biara")));
                s.setKotamasukbiara(rs.getString("kmb"));
                s.setKotapostulat(rs.getString("kmp"));
                s.setKotanovisiat(rs.getString("kmp"));
                s.setKotasementara(rs.getString("kks"));
                s.setKotakaulkekal(rs.getString("kkk"));
                s.setStatus_keaktivan(rs.getString("keaktivan"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SusterDaoImplemen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
