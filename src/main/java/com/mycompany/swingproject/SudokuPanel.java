/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuPanel extends JPanel implements ActionListener {
    private SudokuGame game3 = new SudokuGame();
    private JButton submit;
    private JButton skip;
    private SudokuGrid grid;
    private static JLabel notInt;
    public static boolean sudokuFieldCreated;
    
    // method: SudokuPanel constructor
    // purpose: This method controls the specifications for SudokuPanel
    public SudokuPanel() {
        //create SudokuGrid
        //create submit button
        //create quit button
        super(null);
        grid = new SudokuGrid();
        
        grid.makeGrid(sudokuFieldCreated);
        sudokuFieldCreated = true;
        
        submit = new JButton("Submit");
        submit.setBounds(490, 20, 100, 50);
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.setToolTipText("Click this button to submit your answers.");
        submit.addActionListener(this);
        
        skip = new JButton("Quit");
        skip.setBounds(10, 20, 100, 50);
        skip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        skip.setToolTipText("Click this button to skip the game.");
        skip.addActionListener(this);
        
        notInt = new JLabel("Insert only integer's please!");
        notInt.setForeground(Color.RED);
        notInt.setBounds(150,350,300,50);
        notInt.setHorizontalAlignment(JLabel.CENTER);
        notInt.setVerticalAlignment(JLabel.CENTER);
        notInt.setVisible(false);
        
        JLabel time = new JLabel();
        time.setBounds(198,0,202,30);
        
        
        Timer tmr = new Timer(1000, new ClockListener(time,true));
        tmr.setInitialDelay(0);
        tmr.start();
                
        this.add(grid);
        this.add(submit);
        this.add(skip);
        this.add(notInt);
        
        this.add(time);
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
    
    }
    
    //Method: actionPerformed
    //Purpose: Action Listener for submit button
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit) {
            if(!SudokuGame.isCorrect(grid.getAttempt())) {
                Object[] options = {"Try Again", "Quit"};
                int n = JOptionPane.showOptionDialog(this, "Try Again?", "Incorrect Submission", 
                        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                grid.makeGrid(sudokuFieldCreated);
                
                if(n == 0) {
                    int oldPoints = SudokuGame.getPoints();
                    SwingProject.startPanel("sp");
                    SudokuGame.setPoints(oldPoints);
                }
                else {
                    SudokuGame.setPoints(0);
                    SwingProject.startPanel("gep");
                }
           
            } 
            else {
                    SwingProject.startPanel("gep");
                }
         }
        
        if(e.getSource() == skip) {
            SudokuGame.setPoints(0);
            SwingProject.startPanel("gep");
        }
        
    }
     
    
    //method: getPreferredSize
    //purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end getPreferredSize
    
    // method: notInt
    // purpose: This method warns a user if a digit is not an int
    public static void notInt() {
        notInt.setVisible(true);
        Timer tmr = new Timer(2000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                notInt.setVisible(false);
            }
        });
        tmr.setInitialDelay(1500);
        tmr.start();
    }
}

