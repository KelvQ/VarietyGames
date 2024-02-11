/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayKeyListener {
    
    // method: DisplayKeyListener constructor
    // purpose: This class controls the specifications for the display key listener
    public DisplayKeyListener(JPanel panel) {
        
        Action displayInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.showInfoPanel();
            }
        };
        
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),"displayInfo");
        panel.getActionMap().put("displayInfo", displayInfo);
        
    }
    
    
    
}

