/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

/**
 *
 * @author JEFFERSON
 */
import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
public class SeparatorPanel extends JPanel {
  
    private final Color corEsquerda;
    private final Color corDireita;

    public SeparatorPanel(Color leftColor, Color rightColor) {
        this.corEsquerda = leftColor;
        this.corDireita = rightColor;
        setOpaque(false);
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(corEsquerda);
        g.drawLine(0, 0, 0, getHeight());
        g.setColor(corDireita);
        g.drawLine(1, 0, 1, getHeight());
    }
 
}