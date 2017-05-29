/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

import com.fid.Tela.Splashscreen;
import com.fid.Tela.TelaLogin;



/**
 *
 * @author JEFFERSON
 */
public class Screensplash {
    
    public static void main(String[] args) {
        Splashscreen splash = new Splashscreen();
        splash.setVisible(true);
        TelaLogin login = new TelaLogin();
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(40);
                splash.lblPorcentagem.setText(Integer.toString(i)+"%");
                splash.brCarregamento.setValue(i);
                if(i==100){
                     splash.setVisible(false);
                     login.setVisible(true);
                    
                }
                
            }
        } catch (Exception e) {
        }
        
    }

    
    
}
