/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.conexao;

import com.fid.classes.Logs;
import com.fid.classes.Usuario;
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
public class UsuarioDAO {
    
    private Connection conn = Conexao.conector();
    private PreparedStatement pst = null;
    private ResultSet rs;
    
    public void adicionar(Usuario usuario){
            String sql ="insert into usuario(usu_nome, usu_login, usu_senha, usu_perfil) values (?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getLogin());
                pst.setString(3, usuario.getSenha());
                pst.setString(4, usuario.getPerfil());
               
               
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Cadastrou um novo usuario");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Usuario salvos com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao incluir usuario. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    public void atualizar(Usuario usuario){
            
            String sql ="update usuario set usu_nome = ?, usu_login = ?, usu_senha = ?, usu_perfil = ? where con_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getLogin());
                pst.setString(3, usuario.getSenha());
                pst.setString(4, usuario.getPerfil());
               
               
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Atualizou dado de um usuario");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Usuario atualizado com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao atualizar dados de usuario. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    public void deletar(Usuario usuarios){
            String sql ="delete from usuario where usu_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, usuarios.getId());
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Exclusão de um usuario");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Usuario excluidos com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao excluir usuarios. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    
     public List<Usuario> pesquisar(String nome) throws Exception{
        List<Usuario> usuario = new ArrayList<>();
        String sql = "select * from usuario where usu_nome like ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            while(rs.next()){
                Usuario usuarios = new Usuario();
                usuarios.setId(rs.getInt(1));
                usuarios.setNome(rs.getString(2));
                usuarios.setLogin(rs.getString(3));
                usuarios.setSenha(rs.getString(4));
                usuarios.setPerfil(rs.getString(5));
                usuario.add(usuarios);
                }
                return usuario;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar usuario "+e);
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
                return usuario;
            }
    
    
    
    
}
