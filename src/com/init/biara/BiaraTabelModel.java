/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.init.biara;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class BiaraTabelModel extends AbstractTableModel {

    private final List<Biara> lists;

    public BiaraTabelModel(List<Biara> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Nama";
            case 2:
                return "Alamat";
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
                return lists.get(rowIndex).getNamaBiara();
            case 2:
                return lists.get(rowIndex).getAlamatbiara();
            default:
                return null;
        }
    }

}
