/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomeButton extends JButton {
    
    // method: HomeButton constructor
    // purpose: This method controls the specification and function of the home buttons
    public HomeButton(String title, int x, int y) {
        super(title);
        
        if(title.equals("Play Pong Again")) {
            this.setText("Play Again");
        }
        
        this.setBounds(x,y,200,50);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (title) {
                    case "Credits":
                        SwingProject.startPanel("cp");
                        break;
                    case "High Scores":
                        SwingProject.startPanel("hsp");
                        break;
                    case "Play Again":
                    case "Play":
                        SwingProject.startPanel("pp");
                        break;
                    case "Play Pong Again":
                        SwingProject.startPanel("ppp");
                        break;
                    case "End":
                    case "Back":
                        SwingProject.startPanel("hp");
                        break;
                    case "Skip":
                        HangmanGame.setPoints(0);
                    case "Finish":
                        SwingProject.startPanel("fp");
                        break;
                    case "Play Pong":
                        SwingProject.startPanel("ppp");
                        break;
                    default:
                        break;
                } //end switch
            } //end actionPerformed
        }); //end ActionListener & this.addActionListener
    } //end HomeButton constructor
} //end HomeButton
