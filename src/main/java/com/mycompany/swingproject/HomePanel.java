/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;


public class HomePanel extends JPanel {
    
    private BufferedImage pic = null;
    
    // method: HomePanel constructor
    // purpose: This method controls the specifications for HomePanel
    public HomePanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        HomeButton playPong = new HomeButton("Play Pong",350,140);
        playPong.setToolTipText("Click this button to play pong.");
        HomeButton play = new HomeButton("Play",350,200);
        play.setToolTipText("Click this button to start the game.");
        HomeButton highscores = new HomeButton("High Scores", 350, 260);
        highscores.setToolTipText("Click this button to see highscores.");
        HomeButton credits = new HomeButton("Credits", 350, 320);
        credits.setToolTipText("Click this button to see credits.");
       
        this.add(playPong);
        this.add(play);
        this.add(highscores);
        this.add(credits);
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
        
    } //end HomePanel constructor
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method draws the team logo in the home screen
    public void paintComponent(Graphics x) {
        super.paintComponent(x);
        
        try{
            pic = ImageIO.read(new File("images/EzDubsLogo.jpg"));
        }catch(IOException e){};
        x.drawImage(pic,70,10,200,200,this);
    } //end paintComponent
} //end HomePanel
