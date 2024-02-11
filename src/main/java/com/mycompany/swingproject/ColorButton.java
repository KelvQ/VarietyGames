/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColorButton extends JButton{
     
    private String title;
    private ColorButton cb; 
    
    // method: ColorButton constructor
    // purpose: This method controls the specifications of the color buttons
    public ColorButton(String title, int x, int y) {
        
        super();
        this.setBounds(x,y,100,100);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setToolTipText("Click this to select a color.");
        this.title = title;
        
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        
        Icon icon = new ImageIcon("images/" + title + ".png");
        Icon rolloverIcon = new ImageIcon("images/Rollover" + title + ".png");
        Icon pressedIcon = new ImageIcon("images/Pressed" + title + ".png");
        this.setIcon(icon);
        this.setRolloverIcon(rolloverIcon);
        this.setPressedIcon(pressedIcon);
        this.setDisabledIcon(icon);
        cb = this;
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ColorGame.isCorrect(title);
            }
        });
        
    }
}
