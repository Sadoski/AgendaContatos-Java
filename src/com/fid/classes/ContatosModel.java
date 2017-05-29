/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JEFFERSON
 */


public class ContatosModel extends AbstractTableModel{
    private List<Contatos> contatos;
    
    
    public ContatosModel(List<Contatos> contatos) {
        this.contatos = new ArrayList<Contatos>(contatos);
    }


    @Override
    public int getRowCount() {
        return contatos.size();
    }
  
    @Override
    public int getColumnCount() {
        return 11;
    
    }
    
    @Override
    public String getColumnName(int numCol){
        switch(numCol){
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Telefone";
            case 3:
                return "Celualar";
            case 4:
                return "Email";
            case 5:
                return "Skyper";
            case 6:
                return "Endereco";
            case 7:
                return "Bairro";
            case 8:
                return "Cidade";
            case 9:
                return "Estado";
            case 10:
                return "Cep";
            default:
                return null;
        }
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contatos contato = contatos.get(rowIndex); 
        switch(columnIndex){ 
            case 0: 
                return contato.getId(); 
            case 1: 
                return contato.getNome(); 
            case 2: 
                return contato.getTelefone(); 
            case 3: 
                return contato.getCelular(); 
            case 4: 
                return contato.getEmail(); 
            case 5: 
                return contato.getSkype();
            case 6: 
                return contato.getEndereco();
            case 7: 
                return contato.getBairro();
            case 8: 
                return contato.getCidade();
            case 9: 
                return contato.getEstado();
            case 10: 
                return contato.getCep();
            default: 
                return null; }
        }

    
 
}





