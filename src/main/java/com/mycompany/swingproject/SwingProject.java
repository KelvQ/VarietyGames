/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class SwingProject {

    private static JFrame f;
    private static PlayPanel pp;
    private static ColorPlayPanel cpp;
    private static Component current;
    private static Component temp;
    
    
    // method: main
    // purpose: This method starts the program
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } //end main
    
    // method: createAndShowGUI
    // purpose: This method gets the JFrame to become visible and the first Welcome Panel
    // is displayed
    private static void createAndShowGUI() {
        
        System.out.println("Created GUI on EDT? " + 
                SwingUtilities.isEventDispatchThread());
        f = new JFrame("Variety Games");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        current = new WelcomePanel();
        f.add(current);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        
        f.setVisible(true);
        Timer tmr = new Timer(3000,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startPanel("hp");
            }   
        });
        
        tmr.start();
        tmr.setRepeats(false);
        
        Action removeInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        
        f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"removeInfo");
        f.getRootPane().getActionMap().put("removeInfo", removeInfo);
                   
        
    } //end createAndShowGUI
    
    // method: startPanel
    // purpose: This method switches the panel that is displayed
    public static void startPanel(String panel) {
        f.remove(current);
        switch(panel) {
            case "hp":
                current = new HomePanel();
                break;
            case "fp":
                current = new HangmanFinishPanel();
                break;
            case "cp":
                current = new CreditsPanel();
                break;
            case "hsp":
                current = new HighscoresPanel();
                break;
            case "pp":
                pp = new PlayPanel();
                current = pp;
                ColorGame.setPoints(0);
                break;
            case "cpp":
                cpp = new ColorPlayPanel();
                current = cpp;
                break;
            case "gep":
                current = new GameEndPanel();
                break;
            case "sp":
                current = new SudokuPanel();
                break;
            case "ppp":
                current = new PongPlayPanel();
                break;
            case "pep":
                current = new PongEndPanel();
                break;
        } //end switch
        f.add(current);
        f.setLocationRelativeTo(null);
        redraw();
        
    } //end startPanel
    
    // method: showInfoPanel
    // purpose: this shows the info panel and stores the current panel
    public static void showInfoPanel() {
        temp = current;
        f.remove(current);
        current = new InfoPanel();
        f.add(current);
        redraw();
    }
    
    // method: showInfoPanel
    // purpose: this shows the info panel and stores the current panel
    public static void showInfoPanel(Timer tempTimer) {
        tempTimer.stop();
        temp = current;
        f.remove(current);
        current = new InfoPanel(tempTimer);
        f.add(current);
        redraw();
    }
    
    // method: leaveInfoPanel
    // purpose: this brings the user back to the previous panel and removes the info panel
    public static void leaveInfoPanel() {
        f.remove(current);
        current = temp;
        f.add(current);
        redraw();
        temp = null;
    }
    // method: redraw
    // purpose: This method calls the pack and repaint methods
    public static void redraw() {
        f.pack();
        f.repaint();
        
    } //end redraw
    
    // method: getPlayPanel
    // purpose: This method returns the pp(Play Panel)
    public static PlayPanel getPlayPanel() {
        return pp;
    } //end getPlayPanel
    
    public static ColorPlayPanel getColorPlayPanel() {
        return cpp;
    }
    // method: drawStickMan
    // purpose: This method draws the stickman up to certain points depending on int argument
    public static void drawStickMan(Graphics g, int lineNum, boolean drawStand) {
        switch (lineNum) {
            
            case 6:
                g.drawLine(195,80,215,115);
            case 5:
                g.drawLine(195,80,175,115);
            case 4:
                g.drawLine(195,130,215,165);
            case 3:
                g.drawLine(195,130,175,165);
            case 2:
                g.drawLine(195, 70, 195, 130);
            case 1:
                g.drawOval(180, 40, 30, 30);
                if(!drawStand)
                    break;
            default:
                g.fillRect(100, 15, 100, 10);
                g.fillRect(105, 15, 10, 150);
                g.fillRect(100, 165, 25, 10);
                g.fillRect(190,25,10,15);
                
        } //end switch
    } //end drawStickMan
} //end SwingProject
