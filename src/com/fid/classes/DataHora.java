/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fid.classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author JEFFERSON
 */
 public class DataHora extends Thread {
 
        protected boolean isRunning;
 
        protected JLabel data;
        protected JLabel hora;
 
        protected SimpleDateFormat dataFormat =  new SimpleDateFormat("EEE, d MMM yyyy");
        protected SimpleDateFormat horaFormat = new SimpleDateFormat("h:mm a");
 
    public DataHora(JLabel dateLabel, JLabel timeLabel) {
            this.data = dateLabel;
            this.hora = timeLabel;
            this.isRunning = true;
        }
 
    @Override
    public void run() {
            while (isRunning) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Calendar currentCalendar = Calendar.getInstance();
                        Date currentTime = currentCalendar.getTime();
                        data.setText(dataFormat.format(currentTime));
                        hora.setText(horaFormat.format(currentTime));
                    }
                });
 
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                }
            }
        }
 
        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }
 
    }