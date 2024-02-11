/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;


public class HighscoresPanel extends JPanel{
    private String[] topFive;
    private File scores = new File("Highscores.txt");
   
    // method: HighscorePanel constructor
    // purpose: This method controls the specifications for Highscores Panel
    public HighscoresPanel() {
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        HomeButton back = new HomeButton("Back",30,325);
        back.setToolTipText("Click this button to go back to the home screen.");
        this.add(back);
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
        
    } //end HighscoresPanel
        
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
    } //end getPreferredSize
        
    //method: paintComponent
    //purpose: This method draws the text of names to the screen 
    public void paintComponent(Graphics x) {
        
        super.paintComponent(x);
        Font font1 = new Font("Monospaced", Font.BOLD, 40);
        Font font2 = new Font("Monospaced", Font.BOLD,20);
        Graphics2D highscore = (Graphics2D) x;
        
        highscore.setFont(font1);
        highscore.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        highscore.setColor(Color.BLACK);
        highscore.drawString("High Scores",180,130);
        
        //creates 5 placeholder Strings
        Graphics2D placeholder = (Graphics2D) x;
        placeholder.setFont(font2);
        placeholder.setColor(Color.RED);
        try{
            topFive = getTopFive(scores);
        } catch(Exception e){System.out.println("fail");}
        placeholder.drawString(topFive[0], 230, 190);
        placeholder.drawString(topFive[1], 230, 210);
        placeholder.drawString(topFive[2], 230, 230);
        placeholder.drawString(topFive[3], 230, 250);
        placeholder.drawString(topFive[4], 230, 270);
        
        
    } //end paintComponent
    
    // method: getTopFive
    // purpose: This method gets the top five scores from the txt file
    // and places them into an array
    public String[] getTopFive(File scoresFile) throws Exception{
        Scanner scnr = new Scanner(scoresFile);
        int counter = 0;
        String[] topFive = new String[5];
        while(scnr.hasNext()) {
            scnr.nextLine();
            counter++;
        }
        if(counter >= 5) {
            Scanner top5 = new Scanner(scoresFile);
            for(int i = 0; i < 5; i++) {
                String name = top5.next();
                String score = top5.next();
                topFive[i] = name.toUpperCase() + "....." + score;
            }
        }
        else{
            Scanner top5 = new Scanner(scoresFile);
            int remaining = 5 - counter;
            for(int i = 0; i < counter; i++) {
                String name = top5.next();
                String score = top5.next();
                int scoreLength = score.length();
                String tempString = name.toUpperCase() + "......";
                while(scoreLength < 4) {
                    tempString += 0;
                    scoreLength++;
                }
                topFive[i] = tempString + score;
            }
            for(int i = counter; i < counter+remaining; i++) {
                topFive[i] = "ABC......0000"; 
            }
        }
        
       return topFive;
    }   
} //end HighscoresPanel
