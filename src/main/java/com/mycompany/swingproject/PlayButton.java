/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayButton extends JToggleButton {
    
    String title;
    ToggleListener t1;
    
    // method: PlayButton constructor
    // purpose: This method controls the specifications for each button
    public PlayButton(String title,int x,int y) {
        
        super(title);
        this.title = title; 
        this.setBounds(x,y,50,30);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setToolTipText("Click this button to select a letter.");
        
        t1 = new ToggleListener(this);
        this.addActionListener(t1);
        
        Action clickButton = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                t1.actionPerformed(e);
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(title),"clickButton");
        this.getActionMap().put("clickButton", clickButton);
         
    } //end PlayButton constructor
    
    // method: getTitle
    // purpose: This method returns the title
    public String getTitle() {
        return title;
    } //end getTitle 
} //end PlayButton
