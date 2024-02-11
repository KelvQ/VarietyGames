/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayPanel extends JPanel{
    
    private HangmanGame game1 = new HangmanGame();
    private boolean gameStart;
    private int letterAmt;
    private ArrayList charIndex;
    private ArrayList charList;
    private int wrongCharCount;
    private boolean wrongChar;
    private JLabel wrongLabel;
    
    // method: PlayPanel constructor
    // purpose: This method sets the deafult values and creates a buttons for all letters
    // and also creates the working digital clock
    public PlayPanel() {
        
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        setBackground(Color.WHITE);
        
        wrongChar = false;
        wrongCharCount = 0;
        letterAmt = 0;
        gameStart = false;
        charIndex = new ArrayList<>();
        charList = new ArrayList<>();
        
        
        HomeButton skip = new HomeButton("Skip",390,10);
        skip.setToolTipText("Click this button to skip the game.");
        this.add(skip);
        
        
        PlayButton a = new PlayButton("A", 35, 260);
        PlayButton b = new PlayButton("B", 95, 260);
        PlayButton c = new PlayButton("C", 155, 260);
        PlayButton d = new PlayButton("D", 215, 260);
        PlayButton e = new PlayButton("E", 275, 260);
        PlayButton f = new PlayButton("F", 335, 260);
        PlayButton g = new PlayButton("G", 395, 260);
        PlayButton h = new PlayButton("H", 455, 260);
        PlayButton i = new PlayButton("I", 515, 260);
        
        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
        this.add(e);
        this.add(f);
        this.add(g);
        this.add(h);
        this.add(i);
        
        PlayButton j = new PlayButton("J", 35, 305);
        PlayButton k = new PlayButton("K", 95, 305);
        PlayButton l = new PlayButton("L", 155, 305);
        PlayButton m = new PlayButton("M", 215, 305);
        PlayButton n = new PlayButton("N", 275, 305);
        PlayButton o = new PlayButton("O", 335, 305);
        PlayButton p = new PlayButton("P", 395, 305);
        PlayButton q = new PlayButton("Q", 455, 305);
        PlayButton r = new PlayButton("R", 515, 305);
        
        this.add(j);
        this.add(k);
        this.add(l);
        this.add(m);
        this.add(n);
        this.add(o);
        this.add(p);
        this.add(q);
        this.add(r);
        
        PlayButton s = new PlayButton("S", 65, 350);
        PlayButton t = new PlayButton("T", 125, 350);
        PlayButton u = new PlayButton("U", 185, 350);
        PlayButton v = new PlayButton("V", 245, 350);
        PlayButton w = new PlayButton("W", 305, 350);
        PlayButton x = new PlayButton("X", 365, 350);
        PlayButton y = new PlayButton("Y", 425, 350);
        PlayButton z = new PlayButton("Z", 485, 350);
        
        this.add(s);
        this.add(t);
        this.add(u);
        this.add(v);
        this.add(w);
        this.add(x);
        this.add(y);
        this.add(z);
        
        JLabel time = new JLabel();
        time.setBounds(390,55,202,30);
        
        
        Timer tmr = new Timer(1000, new ClockListener(time));
        
        tmr.setInitialDelay(0);
        tmr.start();
        
        this.add(time);
        
        wrongLabel = new JLabel();
        wrongLabel.setBounds(420,100,150,30);
        wrongLabel.setText("Wrong Letter!");
        wrongLabel.setForeground(Color.RED);
        
        Font font = new Font("Serif", Font.PLAIN, 25);
        wrongLabel.setFont(font);
        
        wrongLabel.setVisible(false);
        this.add(wrongLabel);
        
        DisplayKeyListener displayInfo = new DisplayKeyListener(this);
        
    } //end PlayPanel constructor
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: 
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        for(int i = 0; i < game1.getLength(); i++) {
            g.fillRect((35 + i*60), 240, 50, 5);
        } //end for
       
        SwingProject.drawStickMan(g, wrongCharCount, true);
        
        if(gameStart) {
        
            for(int i = 0; i < charList.size(); i++ ) {
                
                Graphics2D x2 = (Graphics2D) g;
                Font font1 = new Font("Monospaced", Font.BOLD, 50);
                
                char currChar = (char)charList.get(i);
                int currIndex = (int)charIndex.get(i);
                
                x2.setFont(font1);
                x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                x2.setColor(Color.green);
                x2.drawString(currChar + "",45 + currIndex*60,235);
                
            } //end for
            
        } //end if
    } //end paintComponent
    
    // method: addChar
    // purpose: This method adds to char list and index
    public void addChar(char letter, int index) {
       
       gameStart = true;
       charList.add(letter);
       charIndex.add(index);
       letterAmt++;
       
    } //end addChar
    
    // method: wrongChar
    // purpose: This method counts number of wrong guesses
    // and displays a notification telling the user they guessed wrong
    public void wrongChar() {
        wrongCharCount++;
       
        wrongLabel.setVisible(true);
        wrongLabel.repaint();
        Timer wrongNotif = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wrongLabel.setVisible(false);
                wrongLabel.repaint();
            }
        });
                
        wrongNotif.setInitialDelay(3000);
        wrongNotif.setRepeats(false);
        wrongNotif.start();
    } //end wrongChar
} //end PlayPanel
