/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JEFFERSON
 */
public class UsuarioModel extends AbstractTableModel{
    private List<Usuario> usuarios;
    
    public UsuarioModel(List<Usuario> contatos) {
        this.usuarios = contatos;
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
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
                return "Usuario";
            case 3:
                return "Senha";
            case 4:
                return "Perfil";
            default: 
                return null; 
        }
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = usuarios.get(rowIndex); 
        switch(columnIndex){ 
            case 0: 
                return usuario.getId(); 
            case 1: 
                return usuario.getNome(); 
            case 2: 
                return usuario.getLogin(); 
            case 3: 
                return usuario.getSenha(); 
            case 4: 
                return usuario.getPerfil(); 
            default: 
                return null; }
        }

   

    
    
    
}
