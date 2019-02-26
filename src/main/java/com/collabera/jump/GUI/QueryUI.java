package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueryUI 
{
	public static JFrame buildUI()
	{
		JFrame queryFrame = new JFrame();
        queryFrame.setTitle("Query Frame");
        queryFrame.setSize(500,500);
        queryFrame.setVisible(true);
        
        
        queryFrame.setLayout(new BoxLayout(queryFrame.getContentPane(), BoxLayout.Y_AXIS));
        
        JTextField textField = new JTextField();
        textField.setEditable(true); //prevent un-programmed keys from being entered
        textField.setSize(300, 300);
        textField.setText("");
        
        queryFrame.add(textField);
        
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(3,4));
        input.setBackground(new Color(255,0,0));
        queryFrame.add(input);
        
        JPanel display = new JPanel();
        display.setBackground(new Color(0,0,0));
        queryFrame.add(display);

        
        JButton dbConnectBut = new JButton("DB Connect");
        input.add(dbConnectBut);
        
        JButton exeBut = new JButton("Execute");
        input.add(exeBut);
        
        JButton clearBut = new JButton("Clear");
        input.add(clearBut);
        
        queryFrame.validate(); 
        queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return queryFrame;
	}
}
