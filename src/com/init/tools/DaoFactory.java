/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.tools;

import com.init.biara.BiaraDao;
import com.init.biara.BiaraDaoImplemen;
import com.init.bidangkerja.BidangKerjaDao;
import com.init.bidangkerja.BidangKerjaDaoImplemen;
import com.init.cabang.CabangDao;
import com.init.cabang.CabangDaoImplemen;
import com.init.keluarga.KeluargaDao;
import com.init.keluarga.KeluargaDaoImplemen;
import com.init.nonformal.PendidikanNonFormalDao;
import com.init.nonformal.PendidikanNonFormalDaoImplemen;
import com.init.pendidikanterakhir.PendidikanTerakhirDao;
import com.init.pendidikanterakhir.PendidikanTerakhirDaoImplemen;
import com.init.pformal.PendidikanFormalDao;
import com.init.pformal.PendidikanFormalDaoImplemen;
import com.init.riwayatkerja.RiwayatKerja;
import com.init.riwayatkerja.RiwayatKerjaDao;
import com.init.riwayatkerja.RiwayatKerjaDaoImplemen;
import com.init.unit.UnitDao;
import com.init.unit.UnitDaoImplemen;
import com.ypii.suster.SusterDao;
import com.ypii.suster.SusterDaoImplemen;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tendy Developer
 */
public class DaoFactory {

    private static Connection connection = null;
    private static final String url = "jdbc:mysql://";
    static String user = "";
    static String password = "";
    private static Statement st = null;
    private static SusterDao susterDao;
    private static PendidikanTerakhirDao pendidikanTerakhirDao;
    private static PendidikanFormalDao formalDao;
    private static PendidikanNonFormalDao nonFormalDao;
    private static KeluargaDao keluargaDao;
    private static BidangKerjaDao bidangKerjaDao;
    private static UnitDao unitDao;
    private static CabangDao cabangDao;
    private static RiwayatKerjaDao kerjaDao;
    private static BiaraDao biaraDao;

    public static BiaraDao getBiaraDao() {
        if (biaraDao == null) {
            biaraDao = new BiaraDaoImplemen(getConnectionFix());
        }
        return biaraDao;
    }

    public static RiwayatKerjaDao getKerjaDao() {
        if (kerjaDao == null) {
            kerjaDao = new RiwayatKerjaDaoImplemen(getConnectionFix());
        }
        return kerjaDao;
    }

    public static CabangDao getCabangDao() {
        if (cabangDao == null) {
            cabangDao = new CabangDaoImplemen(getConnectionFix());
        }
        return cabangDao;
    }

    public static UnitDao getUnitDao() {
        if (unitDao == null) {
            unitDao = new UnitDaoImplemen(getConnectionFix());
        }
        return unitDao;
    }

    public static BidangKerjaDao getBidangKerjaDao() {
        if (bidangKerjaDao == null) {
            bidangKerjaDao = new BidangKerjaDaoImplemen(getConnectionFix());
        }
        return bidangKerjaDao;
    }

    public static KeluargaDao getKeluargaDao() {
        if (keluargaDao == null) {
            keluargaDao = new KeluargaDaoImplemen(getConnectionFix());
        }
        return keluargaDao;
    }

    public static PendidikanNonFormalDao getNonFormalDao() {
        if (nonFormalDao == null) {
            nonFormalDao = new PendidikanNonFormalDaoImplemen(getConnectionFix());
        }
        return nonFormalDao;
    }

    public static PendidikanFormalDao getFormalDao() {
        if (formalDao == null) {
            formalDao = new PendidikanFormalDaoImplemen(getConnectionFix());
        }
        return formalDao;
    }

    public static PendidikanTerakhirDao getPendidikanTerakhirDao() {
        if (pendidikanTerakhirDao == null) {
            pendidikanTerakhirDao = new PendidikanTerakhirDaoImplemen(getConnectionFix());
        }
        return pendidikanTerakhirDao;
    }

    public static SusterDao getSusterDao() {
        if (susterDao == null) {
            susterDao = new SusterDaoImplemen(getConnectionFix());
        }
        return susterDao;
    }

    public static Connection getConnectionFix() {
        if (connection == null) {
            Koneksi k = new Koneksi();
            connection = k.getKoneksi();
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage());
            }
            FileInputStream in = null;
            try {
                String urlFile = "";
                String urlCOmplete = "";
                in = new FileInputStream("resource.xml");
                Properties p = new Properties();
                p.loadFromXML(in);
                urlFile = p.getProperty("host") + ":" + p.getProperty("PORT") + "/" + p.getProperty("DBNAME");
                urlCOmplete = url + urlFile;
                System.out.println(urlCOmplete);
                user = p.getProperty("USERNAME");
                password = p.getProperty("PASSWORD");
                connection = DriverManager.getConnection(urlCOmplete, user, password);
//                System.out.println("Koneksi OK");
                st = connection.createStatement();
//                System.out.println(urlCOmplete);
            } catch (IOException ex) {
                Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage() + "\n" + ex.getSQLState());
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Terdapat Kesalahan Kesalahan : \n" + ex.getMessage());
                }
            }
        }
        return connection;
    }

    public static String FormatTanggalIndonesia(String formatsql) {
        String tanggal = formatsql;
        String removestrip = tanggal.replace("-", "");
        String tahun = removestrip.substring(0, 4);
        String bulan = removestrip.substring(4, 6);
        String bulanindo = "";
        String hari = removestrip.substring(6, 8);
        if (bulan.equalsIgnoreCase("01")) {
            bulanindo = "Januari";
        } else if (bulan.equalsIgnoreCase("02")) {
            bulanindo = "Februari";
        } else if (bulan.equalsIgnoreCase("03")) {
            bulanindo = "Maret";
        } else if (bulan.equalsIgnoreCase("04")) {
            bulanindo = "April";
        } else if (bulan.equalsIgnoreCase("05")) {
            bulanindo = "Mei";
        } else if (bulan.equalsIgnoreCase("06")) {
            bulanindo = "Juni";
        } else if (bulan.equalsIgnoreCase("07")) {
            bulanindo = "Juli";
        } else if (bulan.equalsIgnoreCase("08")) {
            bulanindo = "Agustus";
        } else if (bulan.equalsIgnoreCase("09")) {
            bulanindo = "September";
        } else if (bulan.equalsIgnoreCase("10")) {
            bulanindo = "Oktober";
        } else if (bulan.equalsIgnoreCase("11")) {
            bulanindo = "November";
        } else if (bulan.equalsIgnoreCase("12")) {
            bulanindo = "Desember";
        }
        String formatindofix = hari + " " + bulanindo + " " + tahun;
        return formatindofix;
    }

    public static String getFormatRupiahIndonesiaInt(int harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        kursIndonesia.applyPattern("#,#00");
        return kursIndonesia.format(harga);
    }

    public static String getFormatRupiahIndonesiaDouble(double harga) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(harga);
    }

    public static int ConvertDoubleToInt(Double value) {
        double a = value;
        int data = (int) a;
        return data;
    }

    public static String[] getUlangTahunByDateMonth(String date) {
        String data[] = new String[3];
        String tanggal = date.substring(8);
        String bulan = date.substring(5, 7);
        String tahun = date.substring(0, 4);
        data[0] = tanggal;
        data[1] = bulan;
        data[2] = tahun;
        return data;
    }

    public static boolean statusUlangTahunByDate(String tanggallahir, String tanggalsekarang) {
        boolean status = false;
        String tgl_lahir[] = DaoFactory.getUlangTahunByDateMonth(tanggallahir);
        String tgl_sekarang[] = DaoFactory.getUlangTahunByDateMonth(tanggalsekarang);
        if (tgl_lahir[0].equalsIgnoreCase(tgl_sekarang[0]) && tgl_lahir[1].equalsIgnoreCase(tgl_sekarang[1])) {
            status = true;
        }
        return status;
    }
}
