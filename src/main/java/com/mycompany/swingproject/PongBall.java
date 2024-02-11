/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PongBall {
    private int x;
    private int y; 
    private int diameter;
    private Timer ballMovement;
    private boolean changeXDirection;
    private boolean changeYDirection;
    private PongPaddle p1;
    private PongPaddle p2;
    private int num;
    
    // method: PongBall constructor
    // purpose: This method controls the specifications for the pong ball
    public PongBall(int x, int y, int diameter, PongPaddle p1, PongPaddle p2) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.p1 = p1;
        this.p2 = p2;
        
        ballMovement = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        ballMovement.start();
        changeXDirection = false;
        changeYDirection = false;
        num = 0;
    }
    
    // method: draw
    // purpose: This method draws the ball
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x,y,diameter,diameter);
    }
    
    // method: draw
    // purpose: This method draws the ball
    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.fillOval(x,y,diameter,diameter);
    }
    
    // method: getXCoordinate
    // purpose: This method returns the x coordinate
    public int getXCoordinate() {
        return x;
    }
    
    // method: getYCoordinate
    // purpose: This method returns the y coordinate
    public int getYCoordinate() {
        return y; 
    }
    
    // method: changeMovement
    // purpose: This method controls the movement of the ball and scoring
    public void changeMovement(int changeInX, int changeInY) {
        if(changeInX > 0 && changeInY > 0)
            num = 1;
        else if(changeInX < 0 && changeInY > 0)
            num = 2;
        else if(changeInX > 0 && changeInY < 0)
            num = 3;
        else
            num = 4;
        ballMovement.stop();
        ballMovement = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(num) {
                    case 1 :
                        if(changeXDirection) {
                            x -= changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y < 75)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y > 315)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x < 120 && (y >= p1.getYCoordinate()-10 && y <= (p1.getYCoordinate()+50)))
                                changeXDirection = false;
                            if(x < 110) {
                                ballMovement.stop();
                                PongGame.increaseP2Score();
                                if(PongGame.getP2Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }
                        }
                        else{
                            x += changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y < 75)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y > 315)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x > 470 && (y >= p2.getYCoordinate()-10 && y <= (p2.getYCoordinate()+50)))
                                changeXDirection = true;
                            if(x > 480) {
                                ballMovement.stop();
                                PongGame.increaseP1Score();
                                if(PongGame.getP1Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }

                        }
                    break;
                    case 2:
                        if(changeXDirection) {
                            x -= changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y < 75)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y > 315)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x > 470 && (y >= p2.getYCoordinate()-10 && y <= (p2.getYCoordinate()+50)))
                                changeXDirection = false;
                            if(x > 480) {
                                ballMovement.stop();
                                PongGame.increaseP1Score();
                                if(PongGame.getP1Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }
                        }
                        else{
                            x += changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y < 75)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y > 315)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x < 120 && (y >= p1.getYCoordinate()-10 && y <= (p1.getYCoordinate()+50)))
                                changeXDirection = true;
                            if(x < 110) {
                                ballMovement.stop();
                                PongGame.increaseP2Score();
                                if(PongGame.getP2Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }

                        }

                    break;
                    case 3:
                        if(changeXDirection) {
                            x -= changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y > 315)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y < 75)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x < 120 && (y >= p1.getYCoordinate()-10 && y <= (p1.getYCoordinate()+50)))
                                changeXDirection = false;
                            if(x < 110) {
                                ballMovement.stop();
                                PongGame.increaseP2Score();
                                if(PongGame.getP2Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }
                        }
                        else{
                            x += changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y > 315)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y < 75)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x > 470 && (y >= p2.getYCoordinate()-10 && y <= (p2.getYCoordinate()+50)))
                                changeXDirection = true;
                            if(x > 480) {
                                ballMovement.stop();
                                PongGame.increaseP1Score();
                                if(PongGame.getP1Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }

                        }

                    break;
                    case 4:
                        if(changeXDirection) {
                            x -= changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y > 315)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y < 75)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x > 470 && (y >= p2.getYCoordinate()-10 && y <= (p2.getYCoordinate()+50)))
                                changeXDirection = false;
                            if(x > 480) {
                                ballMovement.stop();
                                PongGame.increaseP1Score();
                                if(PongGame.getP1Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }
                        }
                        else{
                            x += changeInX;
                            if(changeYDirection) {
                                y -= changeInY;
                                if(y > 315)
                                    changeYDirection = false;
                            }
                            else{
                                y += changeInY;
                                if(y < 75)
                                    changeYDirection = true;
                            }
                            SwingProject.redraw();
                            if(x < 120 && (y >= p1.getYCoordinate()-10 && y <= (p1.getYCoordinate()+50)))
                                changeXDirection = true;
                            if(x < 110) {
                                ballMovement.stop();
                                PongGame.increaseP2Score();
                                if(PongGame.getP2Score().equals("100"))
                                    SwingProject.startPanel("pep");
                                else
                                    SwingProject.startPanel("ppp");
                            }

                        }

                    break;
                }
            }
        });
        ballMovement.setInitialDelay(0);
        ballMovement.start();
            
    }
    
    // method: getTimer
    // purpose: This method returns the timer
    public Timer getTimer(){
        return ballMovement;
    }
    
}
