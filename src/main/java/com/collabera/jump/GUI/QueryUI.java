package com.collabera.jump.GUI;

import java.awt.Color;
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
		//Create Frame
		JFrame queryFrame = new JFrame();
        queryFrame.setTitle("Query Frame");
        queryFrame.setSize(500,500);
        queryFrame.setVisible(true);
        
        queryFrame.setLayout(new BoxLayout(queryFrame.getContentPane(), BoxLayout.Y_AXIS));
        
        //TextField Definition
        JTextField textField = new JTextField();
        textField.setEditable(true);
        textField.setSize(300, 300);
        textField.setText("");
        
        queryFrame.add(textField);
        
       //Define action for button press
       QueryActionListener actionListener = new QueryActionListener(textField); 
        
        JPanel input = buildPanel(actionListener);
        
        queryFrame.add(input);

        queryFrame.validate(); 
        queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return queryFrame;
	}
	
	private static JPanel buildPanel(QueryActionListener qActionListener)
	{
		//Panel with Buttons
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(1,3));
        input.setBackground(new Color(255,0,0));
        
        //Button Definition
        JButton dbConnectBut = new JButton("DB Connect");
        dbConnectBut.setActionCommand("DB");
		dbConnectBut.addActionListener(qActionListener);
        input.add(dbConnectBut);
        
        JButton exeBut = new JButton("Execute");
        exeBut.setActionCommand("Execute");
		exeBut.addActionListener(qActionListener);
        input.add(exeBut);
        
        JButton clearBut = new JButton("Clear");
        clearBut.setActionCommand("Clear");
		clearBut.addActionListener(qActionListener);
        input.add(clearBut);
        
		return input;
	}
	
}
