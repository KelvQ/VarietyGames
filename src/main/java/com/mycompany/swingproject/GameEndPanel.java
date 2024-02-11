/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameEndPanel extends JPanel{
    
    private int score;
    private int highscoreIndex;
    private File highscoresFile;
    private GameEndPanel currentPanel;
    
    //method: GameEnd constructor
    //purpose: This method controls the specifications of the GameEndPanel
    public GameEndPanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        currentPanel = this;
        
        score = HangmanGame.getPoints() + ColorGame.getPoints() + SudokuGame.getPoints();
        HomeButton end = new HomeButton("End",30,325);
        end.setToolTipText("Click this button to end the game and go back to the home screen.");
        HomeButton playAgain = new HomeButton("Play Again",370,325);
        playAgain.setToolTipText("Click this button to play the games again.");
        
        JLabel scoreLabel = new JLabel(score + "");
        scoreLabel.setBounds(150,110,300,50);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font1 = new Font("Serif", Font.BOLD, 35);
        scoreLabel.setFont(font1);
        scoreLabel.setForeground(Color.BLUE);
        
        this.add(end);
        this.add(playAgain);
        this.add(scoreLabel);
        
        JLabel highscoreAsk = new JLabel("Save Highscore?");
        highscoreAsk.setBounds(150,150,300,50);
        highscoreAsk.setHorizontalAlignment(JLabel.CENTER);
        Font font2 = new Font("Serif", Font.BOLD, 20);
        highscoreAsk.setFont(font2);
        highscoreAsk.setForeground(Color.RED);
        highscoreAsk.setVisible(false);
        
        JButton yes = new JButton("Yes");
        yes.setBounds(200,200,75,50);
        yes.setToolTipText("Click this button to save your highscore.");
        yes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yes.setVisible(false);
        
        JButton no = new JButton("No");
        no.setBounds(325,200,75,50);
        no.setToolTipText("Click this button to decline saving a highscore.");
        no.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        no.setVisible(false);
        
        JTextField userscore = new JTextField(5);
        userscore.setToolTipText("Enter a name up to 3 characters and press enter.");
        userscore.setBounds(200,200,200,30);
        
        
        userscore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) 
                { 
                    String name = userscore.getText();
                    if(name.length() > 3) {
                        name = name.substring(0,3);
                    }
                    setNewHighscore(name);
                    userscore.setVisible(false);
                    highscoreAsk.setVisible(false);
                    currentPanel.repaint();
                }
        } );
        
        userscore.setVisible(false);
        
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yes.setVisible(false);
                no.setVisible(false);
                highscoreAsk.setText("Set Your Name");
                userscore.setVisible(true);
                currentPanel.repaint();
            }
        });
        
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                no.setVisible(false);
                highscoreAsk.setVisible(false);
                yes.setVisible(false);
                currentPanel.repaint();
            }
        });
        
        this.add(highscoreAsk);
        this.add(yes);
        this.add(no);
        this.add(userscore);
        
        
        if(isHighscore()) {
            highscoreAsk.setVisible(true);
            yes.setVisible(true);
            no.setVisible(true);
            this.repaint();
        }
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
        
    }
    
    //method: getPreferredSize
    //purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
            return new Dimension(600, 400);
    }
    
    //method: paintComponent
    //purpose: This method paints the text of the GameEndPanel
     public void paintComponent(Graphics x) {
        
        super.paintComponent(x);
        Font font1 = new Font("Serif", Font.BOLD, 35);
        Graphics2D endscore = (Graphics2D) x;
        
        endscore.setFont(font1);
        endscore.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        endscore.setColor(Color.BLACK);
        endscore.drawString("Game end",220,50);
        endscore.drawString("Total Points:", 200, 100);

        
    }
     
    // method: isHighscore
    // purpose: This method checks if the score is a highscore
    private boolean isHighscore(){
        boolean result = false;
        Scanner scnr = null;
        try{
            highscoresFile = new File("Highscores.txt"); 
            highscoresFile.createNewFile();
            scnr = new Scanner(highscoresFile);
        } catch(Exception e) { System.out.println("Error"); }
        
        
        highscoreIndex = 0;
        
        while(scnr.hasNext() && highscoreIndex < 5 && !result) {
            highscoreIndex++;
            scnr.next();
            int oldScore = scnr.nextInt();
            if(oldScore < score ) {
                result = true;
            }
        }
        
        if(highscoreIndex < 5 && !result) {
            result = true;
            highscoreIndex++;
        }
        return result;
    }
    
    // method: setNewHighscore
    // purpose: This method sets the new high score with the given name
    // sorts the Highscore.txt file
    private void setNewHighscore(String name) {
        
        
        Scanner scnr = null;
        PrintWriter pw = null;
        
        try {
            scnr = new Scanner(highscoresFile); 
        } catch (Exception e) { System.out.println("Error"); }
        
        ArrayList<String> highscoresList = new ArrayList<String>();
        
        int highscoreCount = 0;
        while(scnr.hasNextLine()) {
            highscoreCount++;
            highscoresList.add(scnr.nextLine());
        }
        
        try {
            pw = new PrintWriter(highscoresFile);
        } catch (Exception e) { System.out.println("Error"); }
        
        if(highscoreIndex == 0 ) {
            pw.println(name + " " + score);
        }
        else {
            for(int i = 1; i < highscoreIndex; i++) {
                pw.println(highscoresList.get(i - 1));
            }
            pw.println(name + " " + score);
            for(int i = highscoreIndex; i <= highscoreCount && i < 5; i++) {
                pw.println(highscoresList.get(i - 1));
            }
        }
        
        pw.close();
        
    }   
}
