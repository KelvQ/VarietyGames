/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.util.Random;

public class ColorGame {
    private static int points = 0;
    private static int round = 0;
    private static String textColor;
    private String text;
    private int[] positions;
    private static int previousPosition = -1;
    
    // method: ColorGame constructor
    // purpose: This method controls the specifications of the ColorGame
    public ColorGame() {
        round++;
        textColor = newTextColor();
        text = newText();
        positions = getRotation();
    }
    
    // method: getRotation
    // purpose: This method selects a random rotaion of button positions
    private int[] getRotation() {
        int num;
        
        int[] result = new int[10];
        Random ran = new Random();
        do {
           num = ran.nextInt(4);
        }while(num == previousPosition);
        
        switch(num) {
            case 0:
                result[0] = 50;
                result[1] = 50;
                result[2] = 60;
                result[3] = 280;
                result[4] = 190;
                result[5] = 230;
                result[6] = 360;
                result[7] = 80;
                result[8] = 434;
                result[9] = 270;
                break;
            case 1:
                result[0] = 100;
                result[1] = 80;
                result[2] = 70;
                result[3] = 290;
                result[4] = 490;
                result[5] = 50;
                result[6] = 440;
                result[7] = 230;
                result[8] = 330;
                result[9] = 110;
                break;
            case 2:
                result[0] = 250;
                result[1] = 100;
                result[2] = 60;
                result[3] = 230;
                result[4] = 260;
                result[5] = 270;
                result[6] = 450;
                result[7] = 40;
                result[8] = 380;
                result[9] = 200;
                break;
            case 3:
                result[0] = 30;
                result[1] = 200;
                result[2] = 170;
                result[3] = 80;
                result[4] = 300;
                result[5] = 300;
                result[6] = 340;
                result[7] = 80;
                result[8] = 450;
                result[9] = 200;
                break;
        }
        
        previousPosition = num;
        return result; 
    }
    
    // method: newTextColor
    // purpose: This method selects a random text color
    public String newTextColor() {
        String result;
        Random ran = new Random();
        int num = ran.nextInt(5);
        
        switch (num) {
            case 0:
                result = "Red";
                break;
            case 1:
                result = "Blue";
                break;
            case 2:
                result = "Green";
                break;
            case 3:
                result = "Pink";
                break;
            default:
                result = "Yellow";
                break;
        } //end switch
        return result;
    }
    
    // method: newText
    // purpose: This method selects a random color to be displayed
    public String newText() {
        String result;
        
        Random ran = new Random();
        int num = ran.nextInt(5);
        
        switch (num) {
            case 0:
                result = "Red";
                break;
            case 1:
                result = "Blue";
                break;
            case 2:
                result = "Green";
                break;
            case 3:
                result = "Pink";
                break;
            default:
                result = "Yellow";
                break;
        } //end switch
        
        return result;
    }
    
    // method: getTextColor
    // purpose: This method return textColor
    public String getTextColor() {
        return textColor;
    }
    
    // method: getText
    // purpose: This method returns the text
    public String getText() {
        return text;
    }
    
    // method: getPositions
    // purpose: This method returns the positions
    public int[] getPositions() {
        return positions;
    }
    
    // method: getRound
    // purpose: This method returns what round it is
    public static int getRound() {
        return round; 
    }
    
    // method: getPoints
    // purpose: This method returns the amount of points
    public static int getPoints() {
        return points;
    }
    
    //method: setRound
    // purpose: This method updates the current amount of rounds
    public static void setRound(int rounds) {
        round = rounds;
    }
    
    //method: setPoints
    // purpose: This method updates the amount of points
    public static void setPoints(int newPoints) {
        points = newPoints; 
    }
    
    // method: isCorrect
    //purpose: This method checks if the buttton clicked is correct
    public static void isCorrect(String buttonPressed) {
        if(buttonPressed.equals(textColor)) {
            points += 100;
            SwingProject.getColorPlayPanel().correctButton();
        }
        else{
            SwingProject.getColorPlayPanel().wrongButton();
        }
    }
}
