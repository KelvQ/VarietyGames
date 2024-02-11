/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;

public class SudokuGame {
    private static int[][] tip;
    private static int[][] solution;
    private static int points;
    
    // method: SudokuGame constructor
    // purpose: This method fills the tip and solution arrays
    public SudokuGame()
    {
        tip = new int [9][9];
        //put tip into array
        tip[0][0]=8; tip[0][3]=4; tip[0][5]=6; tip[0][8]=7;
        tip[1][6]=4; 
        tip[2][1]=1; tip[2][6]=6; tip[2][7]=5;
        tip[3][0]=5; tip[3][2]=9; tip[3][4]=3; tip[3][6]=7; tip[3][7]=8;
        tip[4][4]=7;
        tip[5][1]=4; tip[5][2]=8; tip[5][4]=2; tip[5][6]=1; tip[5][8]=3;
        tip[6][1]=5; tip[6][2]=2; tip[6][7]=9;
        tip[7][2]=1;
        tip[8][0]=3; tip[8][3]=9; tip[8][5]=2; tip[8][8]=5;
        
        solution = new int[9][9];
        //put solution into array
        solution[0][0]=8; solution[0][1]=3; solution[0][2]=5; solution[0][3]=4; solution[0][4]=1; solution[0][5]=6; solution[0][6]=9; solution[0][7]=2; solution[0][8]=7;
        solution[1][0]=2; solution[1][1]=9; solution[1][2]=6; solution[1][3]=8; solution[1][4]=5; solution[1][5]=7; solution[1][6]=4; solution[1][7]=3; solution[1][8]=1;
        solution[2][0]=4; solution[2][1]=1; solution[2][2]=7; solution[2][3]=2; solution[2][4]=9; solution[2][5]=3; solution[2][6]=6; solution[2][7]=5; solution[2][8]=8;
        
        solution[3][0]=5; solution[3][1]=6; solution[3][2]=9; solution[3][3]=1; solution[3][4]=3; solution[3][5]=4; solution[3][6]=7; solution[3][7]=8; solution[3][8]=2;
        solution[4][0]=1; solution[4][1]=2; solution[4][2]=3; solution[4][3]=6; solution[4][4]=7; solution[4][5]=8; solution[4][6]=5; solution[4][7]=4; solution[4][8]=9;
        solution[5][0]=7; solution[5][1]=4; solution[5][2]=8; solution[5][3]=5; solution[5][4]=2; solution[5][5]=9; solution[5][6]=1; solution[5][7]=6; solution[5][8]=3;
        
        solution[6][0]=6; solution[6][1]=5; solution[6][2]=2; solution[6][3]=7; solution[6][4]=8; solution[6][5]=1; solution[6][6]=3; solution[6][7]=9; solution[6][8]=4;
        solution[7][0]=9; solution[7][1]=8; solution[7][2]=1; solution[7][3]=3; solution[7][4]=4; solution[7][5]=5; solution[7][6]=2; solution[7][7]=7; solution[7][8]=6;
        solution[8][0]=3; solution[8][1]=7; solution[8][2]=4; solution[8][3]=9; solution[8][4]=6; solution[8][5]=2; solution[8][6]=8; solution[8][7]=1; solution[8][8]=5;
        
        points = 540;
    }
    
    //method: getPoints
    //purpose: gets points of sudoku game
    public static int getPoints() {
        return points;
    }
    
    //method: getTip
    //purpose: gets 2d array of sodoku tips
    public static int[][] getTip() {
        return tip;
    }
    
    //method: getSolution
    //purpose: gets 2d array of soduku solution
    public int[][] getSolution() {
        return null;
    }
    
    //method: setPoints
    //purpose: sets points of sudoku game
    public static void setPoints(int n) {
        points = n;
    }
    
    //method: isCorrect
    //purpose: determines if soduku is solved and if not, removes points
    public static boolean isCorrect(SudokuField[][] attempt) {
        //check if solution and attempt are equal and wrongguesses == 0
        boolean complete = true;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                if ( attempt[i][j].getText().equals("")) {
                    complete = false;
                    if(attempt[i][j].getIsCorrect())
                        points -= 10;
                    attempt[i][j].setIncorrect();
                }
                else if ( solution[i][j] != Integer.parseInt(attempt[i][j].getText())) {
                    complete = false;
                    if(attempt[i][j].getIsCorrect())
                        points -= 10;
                    attempt[i][j].setIncorrect();
                }
                else {
                    attempt[i][j].setCorrect();
                }
            }
        }
        
        if (complete)
            SwingProject.startPanel("ged");
            //Go to game end panel
        
        return complete;
        
            
        
     
            //if yes, move to game over panel
            //if not, check if points have been deducted// pass 2d array element into new check method and save it
    }
    

    
}
