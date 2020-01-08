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
public class SusterTabelModelKarya extends AbstractTableModel {

    private List<Suster> lists;

    public SusterTabelModelKarya(List<Suster> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            case 1:
                return "No. Induk";
            case 2:
                return "Nama Suster";
            case 3:
                return "Masa Karya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return lists.get(rowIndex).getNoInduk();
            case 2:
                return lists.get(rowIndex).getNamaSuster();
            case 3:
                return lists.get(rowIndex).getTahunlamakarya()+" tahun "+lists.get(rowIndex).getBulanlamakarya()+" bulan";
            default:
                return null;
        }
    }

}
