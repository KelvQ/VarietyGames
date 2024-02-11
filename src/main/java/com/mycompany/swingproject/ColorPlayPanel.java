
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ColorPlayPanel extends JPanel {
    
    private ColorGame bg;
    private JLabel gameLabel;
    private ColorButton red;
    private ColorButton blue;
    private ColorButton green;
    private ColorButton yellow;
    private ColorButton pink;
    private Timer endTmr; 
    
    //method: ColorPlayPanel constructor
    //purpose: This method controls the specifications of the ColorPlayPanel
    public ColorPlayPanel() {
        
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.LIGHT_GRAY);
        
        JLabel time = new JLabel();
        time.setBounds(390,0,202,30);
        
        
        Timer tmr = new Timer(1000, new ClockListener(time));
        tmr.setInitialDelay(0);
        tmr.start();
        this.add(time);
        
        bg = new ColorGame(); 
        
        getColorRotation();
        setGameLabel();
        endTmr = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        Action displayInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                SwingProject.showInfoPanel(endTmr);
            }
        };
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),"displayInfo");
        this.getActionMap().put("displayInfo", displayInfo);
       
    }
    
    //method: getPreferredSize
    //purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end getPreferredSize
    
    //method: setGameLabel
    //purpose: This method sets the text specifications for text that is displayed
    public void setGameLabel() {
        
        gameLabel = new JLabel(bg.getText());
        gameLabel.setBounds(175,20,250,40);
        gameLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Font font = new Font("Serif", Font.BOLD, 40);
        gameLabel.setFont(font); 
        String textColor = bg.getTextColor();
        switch(textColor) {
            case "Red":
                gameLabel.setForeground(Color.RED);
                break;
            case "Yellow":
                gameLabel.setForeground(Color.YELLOW);
                break;
            case "Green":
                gameLabel.setForeground(Color.GREEN);
                break;
            case "Blue":
                gameLabel.setForeground(Color.BLUE);
                break;
            case "Pink":
                gameLabel.setForeground(Color.MAGENTA);
                break;
        }
        this.add(gameLabel);
        
    }
    
    // method: getColorRotation
    // purpose: This method chooses the position of each color button
    public void getColorRotation() {
        Random ran = new Random();
        int num = ran.nextInt(3);
        
        int[] positions = bg.getPositions();
        switch(num) {
            case 0:
                red = new ColorButton("Red", positions[0], positions[1]);
                yellow = new ColorButton("Yellow", positions[2], positions[3]);
                blue = new ColorButton("Blue", positions[4], positions[5]);
                pink = new ColorButton("Pink", positions[6], positions[7]);
                green = new ColorButton("Green", positions[8], positions[9]);
                break;
            case 1:
                green = new ColorButton("Green", positions[0], positions[1]);
                pink = new ColorButton("Pink", positions[2], positions[3]);
                red = new ColorButton("Red", positions[4], positions[5]);
                blue = new ColorButton("Blue", positions[6], positions[7]);
                yellow = new ColorButton("Yellow", positions[8], positions[9]);
                break;
            default:
                blue = new ColorButton("Blue", positions[0], positions[1]);
                red = new ColorButton("Red", positions[2], positions[3]);
                yellow = new ColorButton("Yellow", positions[4], positions[5]);
                green = new ColorButton("Green", positions[6], positions[7]);
                pink = new ColorButton("Pink", positions[8], positions[9]);
                break;
        }
        
        this.add(red);
        this.add(blue);
        this.add(green);
        this.add(yellow);
        this.add(pink);
      
    }
    
    // method: wrongButton
    // purpose: This method displays if a wrong button was selected
    public void wrongButton() {
        
        red.setEnabled(false);
        yellow.setEnabled(false);
        pink.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        
        gameLabel.setText("Incorrect!");
        gameLabel.setForeground(Color.RED);
        gameLabel.repaint();
        
        endTmr = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                if(ColorGame.getRound() > 4) {
                    SwingProject.startPanel("sp");
                    SudokuPanel.sudokuFieldCreated = false;
                }
                else
                    SwingProject.startPanel("cpp");
            }
        });
        
        endTmr.setRepeats(false);
        endTmr.setInitialDelay(1000);
        endTmr.start();
        
    }
    
    // method: correctButton
    // purpose: This method displays if the correct button was selected
    public void correctButton() {
        
        red.setEnabled(false);
        yellow.setEnabled(false);
        pink.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        
        gameLabel.setText("Correct!");
        gameLabel.setForeground(Color.GREEN);
        gameLabel.repaint();
        
        endTmr = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                if(ColorGame.getRound() > 4) {
                    SudokuPanel.sudokuFieldCreated = false;
                    SwingProject.startPanel("sp");
                }
                else
                    SwingProject.startPanel("cpp");
            }
        });
        
        endTmr.setRepeats(false);
        endTmr.setInitialDelay(1000);
        endTmr.start();
        
        
    }
    
}
