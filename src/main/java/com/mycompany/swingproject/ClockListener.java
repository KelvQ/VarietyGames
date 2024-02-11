/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swingproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockListener implements ActionListener {
    
    private JLabel time;
    private Boolean isMiddle; 
    
    //method: ClockListener constructor
    //purpose: initializes the Jlabel time
    public ClockListener(JLabel time) {
        this.time = time;
        isMiddle = false;
    } //end ClockListener constructor
    
    //method: ClockListener constructor
    //purpose: initializes the Jlabel time
    public ClockListener(JLabel time, Boolean isMiddle) {
        this.time = time;
        this.isMiddle = isMiddle;
    }
    
    //method: actionPerformed
    //purpose: finds the current time in a certain format 
    //and repaints the JLabel with this time
    public void actionPerformed(ActionEvent e) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat hours = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        Date d = cal.getTime();
        String timeHours = hours.format(d);
        time.setText(timeHours);
        if(!isMiddle)
            time.setHorizontalAlignment(JLabel.RIGHT);
        else
            time.setHorizontalAlignment(JLabel.CENTER);
        SwingProject.redraw();
    } //end actionPerformed
} //end ClockListener
