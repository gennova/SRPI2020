/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.keluarga;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class KeluargaTabelModel extends AbstractTableModel {

    private final List<Keluarga> lists;

    public KeluargaTabelModel(List<Keluarga> lists) {
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
                return "Status";
            case 2:
                return "Nama";
            case 3:
                return "Agama";
            case 4:
                return "Tanggal Lahir";
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
                return lists.get(rowIndex).getJenis();
            case 2:
                return lists.get(rowIndex).getNama();
            case 3:
                return lists.get(rowIndex).getAgama();
            case 4:
                return lists.get(rowIndex).getTglLahir();
            default:
                return null;
        }
    }

}
