/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.pformal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class PendidikanFormalTabelModel extends AbstractTableModel {

    private final List<PendidikanFormal> lists;

    public PendidikanFormalTabelModel(List<PendidikanFormal> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Tingkat";
            case 2:
                return "Nama Satuan Pendidikan";
            case 3:
                return "Th. Masuk";
            case 4:
                return "Th.Keluar";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lists.get(rowIndex).getIDPendidikan();
            case 1:
                return lists.get(rowIndex).getPendidikanTerakhir().getNamapendidikanterakhir();
            case 2:
                return lists.get(rowIndex).getNamaSP();
            case 3:
                return lists.get(rowIndex).getTglMasuk();
            case 4:
                return lists.get(rowIndex).getTglLulus();
            default:
                return null;
        }
    }

}
