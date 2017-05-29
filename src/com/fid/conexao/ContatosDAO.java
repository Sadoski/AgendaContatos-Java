/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.conexao;

import com.fid.classes.Contatos;
import com.fid.classes.Logs;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JEFFERSON
 */
public class ContatosDAO {
    
    private Connection conn = Conexao.conector();
    private PreparedStatement pst = null;
    private ResultSet rs;
    
   
   
    public void adicionar(Contatos contatos){
            String sql ="insert into contato(con_nome, con_telefone, con_celular, con_email, con_skype, con_endereco, con_bairro, con_cidade, con_estado, con_cep, con_foto) values (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, contatos.getNome());
                pst.setString(2, contatos.getTelefone());
                pst.setString(3, contatos.getCelular());
                pst.setString(4, contatos.getEmail());
                pst.setString(5, contatos.getSkype());
                pst.setString(6, contatos.getEndereco()); 
                pst.setString(7, contatos.getBairro());
                pst.setString(8, contatos.getCidade());
                pst.setString(9, contatos.getEstado());
                pst.setString(10, contatos.getCep());
                pst.setBytes(11, contatos.getFoto());
               
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Cadastrou um novo contato");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Contato salvos com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao incluir contato. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    public void atualizar(Contatos contatos){
            
            String sql ="update contato set con_nome = ?, con_telefone = ?, con_celular = ?, con_email = ?, con_skype = ?, con_endereco = ?, con_bairro = ?, con_cidade = ?, con_estado = ?, con_cep = ?, con_foto = ? where con_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, contatos.getNome());
                pst.setString(2, contatos.getTelefone());
                pst.setString(3, contatos.getCelular());
                pst.setString(4, contatos.getEmail());
                pst.setString(5, contatos.getSkype());
                pst.setString(6, contatos.getEndereco()); 
                pst.setString(7, contatos.getBairro());
                pst.setString(8, contatos.getCidade());
                pst.setString(9, contatos.getEstado());
                pst.setString(10, contatos.getCep());
                pst.setBytes(11, contatos.getFoto());
                pst.setInt(12, contatos.getId());
               
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Atualizou dados de um contato");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Contato atualizado com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao incluir contato. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    public void deletar(Contatos contatos){
            String sql ="delete from contato where con_id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, contatos.getId());
                pst.executeUpdate();
                Logs logs = new Logs();
                LongsDAO longdao = new LongsDAO();
                logs.setStatus("Exclusão de um contato");
                longdao.longs(logs);
                JOptionPane.showMessageDialog(null,"Contato excluidos com sucesso!");
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao incluir contato. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
    }
    
    
    
    public byte[]  carregarImagem(String idContato) throws Exception{
        byte [] img = null;
        String sql = "select con_foto from contato where con_id = ?";
        
        try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, idContato);
                rs = pst.executeQuery();   
                img = rs.getBytes("con_foto");
 
                
                return img;
            }catch (Exception e){
               JOptionPane.showMessageDialog(null, "Erro ao carregar imagem de contato. Mensagem: "+e.getMessage());
            }finally {
                try{
                    pst.close();
                    conn.close();
                    rs.close();
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
                
                }
            }
        return img;
     
    }
 
     public List<Contatos> pesquisar(String nome) throws Exception{
        List<Contatos> contatos = new ArrayList<>();
        String sql = "select * from contato where con_nome like ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            while(rs.next()){
                Contatos contato = new Contatos();
                contato.setId(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString(3));
                contato.setCelular(rs.getString(4));
                contato.setEmail(rs.getString(5));
                contato.setSkype(rs.getString(6));
                contato.setEndereco(rs.getString(7));
                contato.setBairro(rs.getString(8));
                contato.setCidade(rs.getString(9));
                contato.setEstado(rs.getString(10));
                contato.setCep(rs.getString(11));
                contatos.add(contato);
                }
                return contatos;
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
                return contatos;
            }
    
    

}
        

        
