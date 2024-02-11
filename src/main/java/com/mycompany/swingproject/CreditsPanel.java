/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;


public class CreditsPanel extends JPanel{  
    
    // method: CreditsPanel constructor
    // purpose: This method controls the specifications of the CredisPanel
    public CreditsPanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        HomeButton back = new HomeButton("Back",30,325);
        back.setToolTipText("Click this button to go back to the home screen.");
        this.add(back);
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
        
    } //end CreditsPanel Constructor
        
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end Dimension
    
    //method: paintComponent
    //purpose: This method draws the text of names to the screen 
    public void paintComponent(Graphics x) {
        super.paintComponent(x);
        Font font1 = new Font("Serif", Font.BOLD, 30);
        Font font2 = new Font("Serif", Font.BOLD, 25);
        
        Graphics2D credits = (Graphics2D) x;
        credits.setFont(font1);
        credits.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        credits.setColor(Color.BLACK);
        credits.drawString("Credits",250,110);
        
        Graphics2D name = (Graphics2D) x;
        name.setFont(font2);
        name.setColor(Color.RED);
        name.drawString("Thomas Tejedor, ID# 015193945", 120, 170);
        name.setColor(Color.BLUE);
        name.drawString("Alexander Sanna, ID#: 015193607", 120, 200);
        name.setColor(Color.BLACK);
        name.drawString("Kelvin Quizon, ID#: 015364167", 120, 230);
        name.setColor(Color.RED);
        name.drawString("Xavier Cisneros, ID#: 015393599", 120, 260);
        name.setColor(Color.BLUE);
        name.drawString("Caden Minniefield, ID#: 015570061" , 120, 290);
        
    } //end paintComponent
} //end CreditsPanel
