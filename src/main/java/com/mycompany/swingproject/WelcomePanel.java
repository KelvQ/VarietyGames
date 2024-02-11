/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel{
    
    // method: WelcomePanel constructor
    // purpose: This method sets the specifications for the WelcomePanel
    public WelcomePanel() {
        setBorder(BorderFactory.createLineBorder(Color.red));
        setBackground(Color.black);
        
    } //end WelcomePanel constructor
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method creates the welcome screen title 
    public void paintComponent(Graphics x) {
        super.paintComponent(x);
        Font font1 = new Font("Serif", Font.BOLD, 60);
        Graphics2D x2 = (Graphics2D) x;
        
        x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.white);
        x2.drawString("Variety Games",115,220);
        
        
    } //end paintComponent
} //end WelcomePanel
