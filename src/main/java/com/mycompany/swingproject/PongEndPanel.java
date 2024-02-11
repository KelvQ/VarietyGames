/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.swingproject;

import java.awt.*;
import javax.swing.*;

public class PongEndPanel extends JPanel{
    private String message;
    private boolean player1Win;
    
    // method: PongEndPanel constructor
    // purpose: This method controls the specifications of PongEndPanel
    public PongEndPanel() {
        super(null);
        
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        HomeButton end = new HomeButton("End",75,200);
        end.setToolTipText("Go back to the home screen");
        HomeButton playAgain = new HomeButton("Play Pong Again",325,200);
        playAgain.setToolTipText("Play Pong again");
        this.add(end);
        this.add(playAgain);
        
        DisplayKeyListener display = new DisplayKeyListener(this);
        
        if(PongGame.getP1Score().equals("100")) {
            message = "Player 1 Wins!";
            player1Win = true;
        }
        else {
            message = "Player 2 Wins!";
            player1Win = false;
        }
        PongGame.resetP1Score();
        PongGame.resetP2Score();
    }
    
    //method: getPreferredSize
    //purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method paints the winner message
    public void paintComponent(Graphics x) {
        super.paintComponent(x);
        Font font1 = new Font("Serif", Font.BOLD, 30);
        
        Graphics2D display = (Graphics2D) x;
        display.setFont(font1);
        if(player1Win)
            display.setColor(Color.RED);
        else
            display.setColor(Color.BLUE);
        display.drawString(message, 210, 150);
        
    }
}
