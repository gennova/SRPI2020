/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ypii.suster;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laravel
 */
public class SusterTabelModelUltah extends AbstractTableModel {

    private final List<Suster> lists;

    public SusterTabelModelUltah(List<Suster> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama";
            case 1:
                return "Tgl. Lahir";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lists.get(rowIndex).getNamaSuster();
            case 1:
                return lists.get(rowIndex).getTglLahir();
            default:
                return null;
        }
    }

}
