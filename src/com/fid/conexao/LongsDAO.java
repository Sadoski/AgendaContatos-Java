/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.conexao;

import com.fid.classes.Logs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author JEFFERSON
 */
public class LongsDAO {
    private Connection conn = Conexao.conector();
    private PreparedStatement pst = null;
    ResultSet rs = null;
    
    
     public void longs(Logs logs){
         int idusu = IdUsuDAO.usuId;
            String sql ="insert into longs(usu_id, lon_data, lon_status) values (?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, idusu);             
                pst.setString(2, logs.getDataHora());
                pst.setString(3, logs.getStatus());
               
                pst.executeUpdate();
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao incluir contato. Mensagem: "+e.getMessage());
            } finally{
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro ao fechar operações de inserção de longs. Mensagem: "+e.getMessage());
                }
            }
    }
    
    public List<Logs> pesquisar(String nome) throws Exception{
        List<Logs> longss = new ArrayList<>();

        String sql = "select l.lon_id, u.usu_nome, u.usu_perfil, l.lon_data, l.lon_status from longs l left outer join usuario u on u.usu_id = l.usu_id where u.usu_nome like ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            while(rs.next()){
                Logs longs = new Logs();
                
                longs.setId(rs.getInt(1));
                longs.setNome(rs.getString(2));
                longs.setPerfil(rs.getString(3));
                longs.setDatas(rs.getString(4));
                longs.setStatus(rs.getString(5));

                longss.add(longs);
                
                }
                return longss;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar contatos "+e);
            }
            finally{
                try{
                    pst.close();
                    conn.close();
                    rs.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Erro ao fechar operações de pesquisa. Mensagem: "+e.getMessage());
                }
            }
                return longss;
            }
    
   
    
    
    
}
