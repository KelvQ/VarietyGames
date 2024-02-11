/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

public class PongGame {
    private static int p1Score;
    private static int p2Score;
    private PongBall ball; 
    
    // method: PongGame constructor
    // purpose: This method sets the default values
    public PongGame(PongBall ball) {
        this.ball = ball;
        p1Score = 0;
        p2Score = 0;
  
    }
    
    // method: resetP1Score
    // purpose: This method resets player 1 score
    public static void resetP1Score() {
        p1Score = 0;
    }
    
    // method: resetP2Score
    // purpose: This method resets player 2 score
    public static void resetP2Score() {
        p2Score = 0;
    }
    
    // method: increaseP1Score
    // purpose: This method increases player 1 score
    public static void increaseP1Score() {
        p1Score+= 10;
    }
    
    // method: increaseP2Score
    // purpose: This method increases player 2 score
    public static void increaseP2Score() {
        p2Score+= 10;
    }
    
    // method: getP1Score
    // purpose: This method returns player 1 score
    public static String getP1Score() {
        return String.valueOf(p1Score);
    }
    
    // method: getP2Score
    // purpose: This method returns player 2 score
    public static String getP2Score() {
        return String.valueOf(p2Score);
    }
}
