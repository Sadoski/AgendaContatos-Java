/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JEFFERSON
 */

public class LongsModel extends AbstractTableModel{
    
    private List<Logs> longs;
    
    
    public LongsModel(List<Logs> longs) {
        this.longs = new ArrayList<Logs>(longs);
    }
    @Override
    public int getRowCount() {
        return longs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    
      @Override
    public String getColumnName(int numCol){
        switch(numCol){
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Perfil";
            case 3:
                return "Data Hora";
            case 4:
                return "Status";
            default:
                return null;
        }
        
    }
     
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Logs longss = longs.get(rowIndex); 
        switch(columnIndex){ 
            case 0: 
                return longss.getId(); 
            case 1: 
                return longss.getNome();
            case 2:
                return longss.getPerfil();
            case 3: 
                return longss.getDatas(); 
            case 4: 
                return longss.getStatus(); 
            default: 
                return null; }
        }
    
}
