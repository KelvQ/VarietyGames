/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class PongPlayPanel extends JPanel{
    private JLabel p1Score;
    private JLabel p2Score;
    private PongPaddle p1;
    private PongPaddle p2;
    private PongBall ball;
    private JLabel startDisplay;
  
    // method: PongPlayPanel constructor
    // purpose: This method controls the specifications for the pong play panel
    public PongPlayPanel() {
        super(null);
        
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        JLabel time = new JLabel();
        time.setBounds(390,0,202,30);
        
        Timer tmr = new Timer(1000, new ClockListener(time));
        tmr.setInitialDelay(0);
        tmr.start();
        this.add(time);
        
        JButton back = new JButton("Quit");
        back.setBounds(10,340,75,50);
        back.setVisible(true);
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setToolTipText("This button brings you back to the home screen");
        this.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.startPanel("hp");
                ball.getTimer().stop();
                PongGame.resetP1Score();
                PongGame.resetP2Score();
            }
        });
        
        setPlayerLabels();
        setPlayerScores();
        
        
        p1 = new PongPaddle(110,175);
        p2 = new PongPaddle(480,175);
        ball = new PongBall(300,200,10, p1, p2);
        
        Action moveBall = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Random ran = new Random();
                int x = 0;
                int y = 0;
                y *= -1;
                while(x==0)
                    x = ran.nextInt(3)-1;
                while(y==0)
                    y = ran.nextInt(3)-1;
                ball.changeMovement(x,y);
                start();
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"),"moveBall");
        this.getActionMap().put("moveBall", moveBall);
        
        
        
        Font font1 = new Font("Serif", Font.BOLD, 20);
        startDisplay = new JLabel("Press Space to Start");
        startDisplay.setFont(font1);
        startDisplay.setForeground(Color.MAGENTA);
        startDisplay.setBounds(200,30,200,25);
        startDisplay.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(startDisplay);
        
        Action displayInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.showInfoPanel(ball.getTimer());
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),"displayInfo");
        this.getActionMap().put("displayInfo", displayInfo);
        
        
    }
    
    // method: paintComponent
    // purpose: This method draws the paddles, ball, and background
    public void paintComponent(Graphics g) {
        g.fillRect(100, 75, 400, 250);
        p1.draw(g);
        p2.draw(g);
        ball.draw(g);
    }
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
    // method: setPlayerLabels
    // purpose: This method displays the player labels
    public void setPlayerLabels() {
        JLabel p1Label, p2Label, p1Label2, p2Label2;
        Font font = new Font("Serif", Font.BOLD, 18);
        
        p1Label = new JLabel("Player 1");
        p1Label.setBounds(0,100,100,20);
        p1Label.setHorizontalAlignment(JLabel.CENTER);
        p1Label.setFont(font);
        p1Label.setForeground(Color.RED);
        p1Label.setBackground(null);
        this.add(p1Label);
        
        p1Label2 = new JLabel("Score:");
        p1Label2.setBounds(0,120,100,20);
        p1Label2.setHorizontalAlignment(JLabel.CENTER);
        p1Label2.setFont(font);
        p1Label2.setForeground(Color.RED);
        p1Label2.setBackground(null);
        this.add(p1Label2);
        
        
        p2Label = new JLabel("Player 2");
        p2Label.setBounds(500,100,100,20);
        p2Label.setHorizontalAlignment(JLabel.CENTER);
        p2Label.setFont(font);
        p2Label.setForeground(Color.BLUE);
        p2Label.setBackground(null);
        this.add(p2Label);
        
        p2Label2 = new JLabel("Score:");
        p2Label2.setBounds(500,120,100,20);
        p2Label2.setHorizontalAlignment(JLabel.CENTER);
        p2Label2.setFont(font);
        p2Label2.setForeground(Color.BLUE);
        p2Label2.setBackground(null);
        this.add(p2Label2);
    }
    
    // method: setPlayerScores
    // purpose: This method displays the player scores
    public void setPlayerScores() {
        Font font = new Font("Serif", Font.BOLD, 24);
   
        p1Score = new JLabel(PongGame.getP1Score());
        p1Score.setBounds(0,150,100,30);
        p1Score.setHorizontalAlignment(JLabel.CENTER);
        p1Score.setFont(font);
        p1Score.setBackground(null);
        this.add(p1Score);
        
        
        p2Score = new JLabel(PongGame.getP2Score());
        p2Score.setBounds(500,150,100,30);
        p2Score.setHorizontalAlignment(JLabel.CENTER);
        p2Score.setFont(font);
        p2Score.setBackground(null);
        this.add(p2Score);
        
    }
    
    // method: start
    // purpose: This method starts to pong game
    public void start() {
        this.getActionMap().remove("moveBall");
        this.remove(startDisplay);
        
        Action moveP1Up = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                p1.changeYMovement(-10);
            }
        };
        
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"),"moveP1Up");
        this.getActionMap().put("moveP1Up", moveP1Up);
        
        Action moveP1Down = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                p1.changeYMovement(10);
            }
        };
        
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"),"moveP1Down");
        this.getActionMap().put("moveP1Down", moveP1Down);
        
        Action moveP2Up = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                p2.changeYMovement(-10);
            }
        };
        
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),"moveP2Up");
        this.getActionMap().put("moveP2Up", moveP2Up);
        
        Action moveP2Down = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                p2.changeYMovement(10);
            }
        };
        
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),"moveP2Down");
        this.getActionMap().put("moveP2Down", moveP2Down);
    }
   
}
