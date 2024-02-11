package com.mycompany.swingproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;

public class SudokuGrid extends JPanel{
    
    private static SudokuField[][] attempt;
    private int[][] tip;
    
    // method: SudokuGrid Constructor
    // purpose: This method controls the specification for the sudoku grid
    public SudokuGrid() {
        setLayout(null);
        setBounds(150, 50, 300, 300);
        
        tip = SudokuGame.getTip();
        
    }
    
    // method: getPreferredSize
    // purpose: This method sets the size to 300x300
    public Dimension getPreferredSize() {
        return new Dimension(300,300);
    }
    
    // method: paintComponent
    // purpose: This method draws the 4 grid lines
    public void paintComponent(Graphics g) {
        g.fillRect(93, 0, 9, 300);
        g.fillRect(195,0,9,300);
        g.fillRect(0, 93, 300, 9);
        g.fillRect(0, 195, 300, 9);
    }
    
    // method: makeGrid
    // purpose: Creates the sudoku grid on the panel 
    public void makeGrid(boolean sudokuFieldCreated) {
        //puts tips into grid
        if(!sudokuFieldCreated) {
            attempt = new SudokuField[9][9];
            for (int i = 0; i < attempt.length; i++) {
                for (int j = 0; j < attempt[i].length; j++) {
                    attempt[i][j] = new SudokuField(i,j);
                    if(tip[i][j] != 0) {
                        attempt[i][j].setText(Integer.toString(tip[i][j]));
                        attempt[i][j].setEditable(false);
                    }
                    this.add(attempt[i][j]);
                    
                }
            }
        }
        else {
            for (int i = 0; i < attempt.length; i++) {
                for (int j = 0; j < attempt[i].length; j++) {
                    boolean isCorrect = attempt[i][j].getIsCorrect();
                    this.remove(attempt[i][j]);
                    attempt[i][j] = new SudokuField(i,j);
                    attempt[i][j].setCorrectField(isCorrect);
                    
                    if(tip[i][j] != 0) {
                        attempt[i][j].setText(Integer.toString(tip[i][j]));
                        attempt[i][j].setEditable(false);
                    }
                    this.add(attempt[i][j]);
                }
            }
        }
    }
    
    // method: getAttempt
    // purpose: returns the current SudokuFields inside of the grid
    public SudokuField[][] getAttempt() {
        return attempt;
    }
    
}
