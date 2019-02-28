package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueryUI 
{
	public static JFrame buildUI() {
		// Create Frame
		JFrame queryFrame = new JFrame();
		queryFrame.setTitle("Query Frame");
		queryFrame.setSize(500, 200);
		queryFrame.setVisible(true);

		queryFrame.setLayout(new BoxLayout(queryFrame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel titleBar = new JPanel();
		titleBar.setPreferredSize(new Dimension(600, 35));
		JLabel titleLabel = new JLabel("BEAR'S DATABASE MANAGEMENT GUI");
		titleBar.add(titleLabel);
		queryFrame.add(titleBar);

		JPanel textFieldPane = new JPanel();
		textFieldPane.setPreferredSize(new Dimension(600, 75));

		// TextField Definition
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(500, 50));

		// USE GETPARENT TO GRAB SIZE OF
		textField.setEditable(true);
		textField.setVisible(true);
		textField.setText("");
		textFieldPane.add(textField);
		queryFrame.add(textFieldPane);

		// Define action for button press
		QueryActionListener actionListener = new QueryActionListener(textField);

		JPanel input = buildPanel(actionListener);
		input.setSize(100, 100);
		queryFrame.add(input);

		JPanel display = new JPanel();
		display.setSize(400, 400);

		queryFrame.add(display);
		JLabel lab1 = new JLabel("NEW LABEL");
		display.add(lab1);

		queryFrame.validate();
		queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return queryFrame;
	}

	private static JPanel buildPanel(QueryActionListener qActionListener) {
		// Panel with Buttons
		JPanel input = new JPanel();
		input.setLayout(new GridLayout(1, 3));
		input.setBackground(new Color(255, 0, 0));

		// Button Definition
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
