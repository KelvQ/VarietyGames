/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PongPaddle{
    private int x;
    private int y;
    private int width = 8;
    private int height = 50;
    private Timer tmr;
    
    // method: PongPaddle constructor
    // purpose: This method specifies the size of the paddle
    public PongPaddle(int x,int y) {
        this.x = x;
        this.y = y;
        
    }
    
    // method: draw
    // purpose: This method draws the paddle
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    
    //method: getXCoordinate
    // purpose: This method returns the x coordinate of the paddle
    public int getXCoordinate() {
        return x;
    }
    
    //method: getYCoordinate
    // purpose: This method returns the y coordinate of the paddle
    public int getYCoordinate() {
        return y; 
    }
   
    //method: changeYMovement
    // purpose: This method controls the movement of the paddle
    public void changeYMovement(int changeInY) {
        if(changeInY < 0) {
            if(y > 75) {
                this.y += changeInY;
                SwingProject.redraw();
            }
        }
        else if(changeInY > 0) {
            if(y < 275) {
                this.y += changeInY;
                SwingProject.redraw();
            }
        }
    }
}
