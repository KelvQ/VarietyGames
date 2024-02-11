/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.swingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleListener implements ActionListener{
    
    PlayButton button;
    String buttonTitle;
    
    // method: ToggleListner constructor
    // purpose: This method sets the default values for the Toggle Listner
    public ToggleListener(PlayButton button) {
       this.button = button;
       buttonTitle = button.getTitle();
    } //end ToggleListener constructor
    
    // method: actionPerformed
    // purpose: This method disables a button when it is clicked
    public void actionPerformed(ActionEvent e) {
       button.setEnabled(false);
       HangmanGame.isValid(buttonTitle.toLowerCase().charAt(0));
    
    } //end actionPerformed
} //end ToggleListener
