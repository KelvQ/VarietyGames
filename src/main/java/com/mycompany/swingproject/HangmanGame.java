/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.util.Random;


public class HangmanGame
{
    private static String theWord;
    private static int length; 
    private static char[] wordChars;
    private static int points;
    private static int correctCount;
    private static int wrongCount;
    private static boolean isWon;
            
    // method: HangmanGame constructor
    // purpose: This method sets the default values for each variable
    public HangmanGame() {
        
        theWord = theNewWord();
        length = theWord.length();
        setChars(); 
        points = 100;
        correctCount = 0;
        wrongCount = 0;
        isWon = false;
        
    } //end HangmanGame constructor
        
    // method: theNewWord
    // purpose: This method chooses a random word
    public String theNewWord() //randomly selects the word
    {
     String validWord;
	 
     Random ran = new Random();
     int num = ran.nextInt(5);
        switch (num) {
            case 0:
                validWord = "abstract";
                break;
            case 1:
                validWord = "cemetary";
                break;
            case 2:
                validWord = "nurse";
                break;
            case 3:
                validWord = "pharmacy";
                break;
            default:
                validWord = "climbing";
                break;
        } //end switch
        
        return validWord;
        
    } //end theNewWord
    
    // method: getTheWord
    // purpose: This method returns the word
    public static String getTheWord() {
        return theWord;
    } //end getTheWord
    
    // method: setChars
    // purpose: This method splits the word into an array of chars
    public static void setChars() {
        
        String s = theWord;
        wordChars = new char[length];
        for(int i = 0; i < length; i++)
        {
           wordChars[i] = s.charAt(i);
        } //end for
        
    } //end setChars
    
    // method: getLength
    // purpose: This method returns the length of the word
    public static int getLength() {
        return length; 
    } //end getLength
    
    // method: getChars
    // purpose: This method returns the array of chars
    public static char[] getChars() {
        return wordChars;
    } //end getChars
    
    // method: getPoints
    // purpose: This method returns the amount of points
    public static int getPoints() {
        return points;
    } //end getPoints
    
    // method: getWord
    // purpose: This method returns the selected word
    public static String getWord() {
        return theWord;
    } //end getWord
    
    // method: getIsWon
    // purpose: This method returns if game is won or not
    public static boolean getIsWon() {
        return isWon;
    } //end getIsWon
    
    // method: setPoints
    // purpose: This method sets user's points
    public static void setPoints(int newPoints) {
        points = newPoints;
    } //end setPoints
   
    // method: isValid
    // purpose: This method determines if letter selected is valid
    public static boolean isValid(char letter) {
        boolean valid = false;
        
        for(int i = 0; i < length; i++) {
            char character = wordChars[i];
            if(letter == character) {
               valid = true;
               correctCount++;
               SwingProject.getPlayPanel().addChar(letter, i);
               SwingProject.redraw();
            } //end if
        } //end for
        
        if(!valid) {
            points -= 10;
            wrongCount++;
            SwingProject.getPlayPanel().wrongChar();
            SwingProject.redraw();
        } //end if
        
        if(correctCount == length || wrongCount == 6 ) {
            gameEnd();
        } //end if
        
        return valid;
    } //end isValid
    
    // method: gameEnd
    // purpose:  This method determines if game will end or not
    public static void gameEnd() {
        if(correctCount == length) {
            isWon = true;
        } //end if
        else {
            isWon = false;
        } //end else
        SwingProject.startPanel("fp");
    } //end gameEnd
} //end HangmanGame
