/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Rental;

/**
 *
 * @author Lucas Manuel SB
 */
public class TableSewaFilm extends AbstractTableModel{
    private List<Rental> list;

    public TableSewaFilm(List<Rental> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_rental();
            case 1:
                return list.get(rowIndex).getId_staff();
            case 2:
                return list.get(rowIndex).getTanggal_rental();
            case 3:
                return list.get(rowIndex).getTanggal_selesai();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Rental";
            case 1:
                return "ID Staff";
            case 2:
                return "Tanggal Rental";
            case 3:
                return "Tanggal Selesai";
            default:
                return null;
        }
    }
}
