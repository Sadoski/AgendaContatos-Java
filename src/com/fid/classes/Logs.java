/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;




/**
 *
 * @author JEFFERSON
 */
public class Logs {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getIdCon(){
        return idCon;
    }
    
    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }
    
    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String getDataHora(){
        Date dataAtual = new Date(); 
        Locale locale = new Locale("pt","BR"); 
        GregorianCalendar calendar = new GregorianCalendar(); 
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",locale);
  
        return dataHora.format(dataAtual);   
    }
    
   
    public Date getData(){
        Locale locale = new Locale("pt","BR"); 
        GregorianCalendar calendar = new GregorianCalendar(); 
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",locale);
        String sqlg = dataHora.format(calendar.getTime());
         Date currentDate = GregorianCalendar.getInstance().getTime();
         java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        calendar.setTime(new Date());
        java.sql.Date dt = new java.sql.Date(calendar.getTimeInMillis());
        java.sql.Time sqlTime=new java.sql.Time(calendar.getTime().getTime());
        Timestamp timeStamp = new Timestamp(calendar.getTimeInMillis()); 
        return sqlDate;
    }
    
   /**
    public Date getData(){
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MMMMM/yyyy HH:mm"); 
        Date currentDateTime;
        java.sql.Date sql_currentDateTime;
        //sql_currentDateTime = new java.sql.Date(currentDateTime.getTime());
        
        return sql_currentDateTime.;
        
    }
    
    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    */
    
    private String status;
    private int idCon;
    private int id;
    private String datas;
     private String nome;
    private String senha;
    private String login;
    private String perfil;

    
    
    
    
    
    
}
