/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HangmanFinishPanel extends JPanel{
  
    // method: FinishPanel constructor
    // purpose: This method controls the specifications of the FinishPanel
    // and adds the playAgain and back buttons
    public HangmanFinishPanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        JLabel time = new JLabel();
        time.setBounds(390,0,202,30);
        
        
        Timer clockTmr = new Timer(1000, new ClockListener(time));
        
        clockTmr.setInitialDelay(0);
        clockTmr.start();
        
        this.add(time);
        
        Timer endTmr = new Timer(2000,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ColorGame.setRound(0);
                SwingProject.startPanel("cpp");
            }
        });
        
        endTmr.setInitialDelay(2000);
        endTmr.setRepeats(false);
        endTmr.start();
        
        Action displayInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.showInfoPanel(endTmr);
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),"displayInfo");
        this.getActionMap().put("displayInfo", displayInfo);
        
    } //end FinishPanel
    
    // method: getPreferredSize
    // purpose: This method sets the dinmensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method paints the win/loss announcements
    public void paintComponent(Graphics g) { 
         
        for(int i = 0; i < HangmanGame.getLength(); i++) {
            g.fillRect((35 + i*60), 240, 50, 5);
        } //end for
        
        if(HangmanGame.getIsWon()) {
            String theWord = HangmanGame.getTheWord();
            
            SwingProject.drawStickMan(g, 6, false);
           
            Graphics2D x2 = (Graphics2D) g;
            
            for(int i = 0; i < theWord.length(); i++) {
                char letter = theWord.charAt(i);
                
                Font font1 = new Font("Monospaced", Font.BOLD, 50);
                
                
                x2.setFont(font1);
                x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                x2.setColor(Color.green);
                x2.drawString(letter + "",45 + i*60,235);
                
            } //end for
            
            Font font2 = new Font("Serif", Font.BOLD, 60);
            
            x2.setFont(font2);
            x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            x2.setColor(Color.green);
            x2.drawString("You Won!",300,100);
            
            Font font3 = new Font("Serif", Font.PLAIN, 30);
            
            x2.setFont(font3);
            x2.setColor(Color.BLACK);
            String points = "" + HangmanGame.getPoints();
            x2.drawString("Points: " + points,365,130);
        } //end if
        else {
            String theWord = HangmanGame.getTheWord();
            
            SwingProject.drawStickMan(g, 6, true);
            
            Graphics2D x2 = (Graphics2D) g;
            
            for(int i = 0; i < theWord.length(); i++) {
                char letter = theWord.charAt(i);
                
                Font font1 = new Font("Monospaced", Font.BOLD, 50);
                
                
                x2.setFont(font1);
                x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                x2.setColor(Color.RED);
                x2.drawString(letter + "",45 + i*60,235);
                
            } //end for
            
            Font font2 = new Font("Serif", Font.BOLD, 60);
            
            x2.setFont(font2);
            x2.setColor(Color.RED);
            x2.drawString("You Lost!",300,100);
            
            Font font3 = new Font("Serif", Font.PLAIN, 30);
            
            x2.setFont(font3);
            x2.setColor(Color.BLACK);
            String points = "" + HangmanGame.getPoints();
            x2.drawString("Points: " + points,365,130);
        } //end else
    } //end paintComponent
   
} //end FinishPanel
