/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.riwayatkerja;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class RiwayatKerjaTabelModel extends AbstractTableModel {

    private final List<RiwayatKerja> lists;

    public RiwayatKerjaTabelModel(List<RiwayatKerja> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Bidang Kerja";
            case 2:
                return "Cabang";
            case 3:
                return "Unit";
            case 4:
                return "Tgl. Awal";
            case 5:
                return "Tgl. Akhir";
            case 6:
                return "Keterangan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lists.get(rowIndex).getID();
            case 1:
                return lists.get(rowIndex).getBidangKerja().getNamabidangkerja();
            case 2:
                return lists.get(rowIndex).getCabang().getNamacabang();
            case 3:
                return lists.get(rowIndex).getUnit().getNamaUnit();
                //return "sss";
            case 4:
                return lists.get(rowIndex).getTgl_awal();
            case 5:
                return lists.get(rowIndex).getTgl_akhir();
            case 6:
                return lists.get(rowIndex).getKeterangan();
            default:
                return null;
        }
    }

}
