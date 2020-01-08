/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.nonformal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class PendidikanNonFormalTabelModel extends AbstractTableModel {

    private final List<PendidikanNonFormal> lists;

    public PendidikanNonFormalTabelModel(List<PendidikanNonFormal> lists) {
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
                return "Materi/Keahlian";
            case 2:
                return "Nama Lembaga";
            case 3:
                return "Tgl. Mulai";
            case 4:
                return "Tgl. Selesai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lists.get(rowIndex).getId();
            case 1:
                return lists.get(rowIndex).getMateriLP();
            case 2:
                return lists.get(rowIndex).getNamaLP();
            case 3:
                return lists.get(rowIndex).getTglMulai();
            case 4:
                return lists.get(rowIndex).getTglSelesai();
            default:
                return null;
        }
    }

}
