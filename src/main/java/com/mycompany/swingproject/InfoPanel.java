/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoPanel extends JPanel{
    // method: InfoPanel constructor
    // purpose: This method controls the specifications of the CredisPanel
    public InfoPanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        JButton back = new JButton("Back");
        back.setToolTipText("Click this button to go back to the previous screen.");
        back.setBounds(250,325,100,50);
        back.setVisible(true);
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        this.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.leaveInfoPanel();
            }
        });
        
        Action removeInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.leaveInfoPanel();
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"removeInfo");
        this.getActionMap().put("removeInfo", removeInfo);
        
        
    } //end InfoPanel Constructor
        
    
    // method: InfoPanel constructor
    // purpose: This method controls the specifications of the CredisPanel
    public InfoPanel(Timer tempTimer) {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        JButton back = new JButton("Back");
        back.setToolTipText("Click this button to go back to the previous screen.");
        back.setBounds(250,325,100,50);
        back.setVisible(true);
        
        this.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.leaveInfoPanel();
                tempTimer.start();
            }
        });
        
        Action removeInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.leaveInfoPanel();
                tempTimer.start();
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"removeInfo");
        this.getActionMap().put("removeInfo", removeInfo);
        
        
    } //end InfoPanel Constructor
    
    
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
        
        Graphics2D projName = (Graphics2D) x;
        projName.setFont(font1);
        projName.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        projName.setColor(Color.BLACK);
        projName.drawString("Swing Project v1.3",185,90);
        
        Graphics2D term = (Graphics2D) x;
        term.setFont(font1);
        term.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        term.setColor(Color.BLACK);
        term.drawString("Fall 2022",250,50);
        
        Graphics2D name = (Graphics2D) x;
        name.setFont(font2);
        name.setColor(Color.RED);
        name.drawString("Thomas Tejedor, ID# 015193945", 120, 155);
        name.setColor(Color.BLUE);
        name.drawString("Alexander Sanna, ID#: 015193607", 120, 185);
        name.setColor(Color.BLACK);
        name.drawString("Kelvin Quizon, ID#: 015364167", 120, 215);
        name.setColor(Color.RED);
        name.drawString("Xavier Cisneros, ID#: 015393599", 120, 245);
        name.setColor(Color.BLUE);
        name.drawString("Caden Minniefield, ID#: 015570061" , 120, 275);
        
    } //end paintComponent
} //end CreditsPanel
