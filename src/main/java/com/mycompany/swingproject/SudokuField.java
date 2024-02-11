/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SudokuField extends JFormattedTextField{
    private boolean correct;
    private int chars; 
    
    // method: SudokuField constructor
    // purpose: This method controls the specifications for the SodukoField 
    public SudokuField(int i, int j)
    {
        super();
        correct = true;
        chars = 0;
        this.setBounds(((j*34)), ((i*34)),25,25);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setToolTipText("Enter a digit from 1-9.");
        this.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                chars++;
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_BACK_SPACE) {
                    chars = 0;
                }
                else if ( ((c < '1') || (c > '9'))) {
                    e.consume();  // if it's not a number, ignore the event
                    chars--;
                    SudokuPanel.notInt();
                }
                else if (chars > 1) {
                    e.consume();
                    chars--;
                }
            }
        });
    }
    
    // method: getPreferredSize
    // purpose: This method sets the size of the text fields to 20x20
    public Dimension getPreferredSize() {
        return new Dimension(20,20);
    }
    
    // method: setCorrectField
    // prupose: sets the value of the boolean correct 
    public void setCorrectField(boolean correct) {
        this.correct = correct;
    }
    
    // method: setCorrect
    // purpose: This method identifies an correct entry
    public void setCorrect() {
        this.setEditable(false);
        this.setForeground(Color.BLUE);
    }
    
    // method: setIncorrect
    // purpose: This method identifies an incorrect entry
    public void setIncorrect() {
        this.setEditable(false);
        this.setForeground(Color.RED);
        correct = false;
    }
    
    // method: getIsCorrect
    // purpose: This method returns if the entry has ever been incorrect
    public boolean getIsCorrect() {
        return correct;
    }
}
