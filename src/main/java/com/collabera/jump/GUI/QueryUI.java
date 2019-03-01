package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class QueryUI {
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
		textField.setPreferredSize(new Dimension(450, 50));

		// USE GETPARENT TO GRAB SIZE OF
		textField.setEditable(true);
		textField.setVisible(true);
		textField.setText("");
		textFieldPane.add(textField);
		queryFrame.add(textFieldPane);

		JTable table = buildTable();
		// Define action for button press
		QueryActionListener actionListener = new QueryActionListener(textField, table);

		JPanel input = buildPanel(actionListener);
		input.setSize(100, 100);
		queryFrame.add(input);

		JPanel display = new JPanel();
		display.setSize(400, 400);

		queryFrame.add(display);
		JLabel lab1 = new JLabel("NEW LABEL");
		display.add(lab1);

		queryFrame.add(new JScrollPane(table));

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

	private static JTable buildTable() {
		// TODO Auto-generated method stub
		TableModel dataModel = new ResultsTableModel(10, 10);
		JTable table = new JTable(dataModel);
		return table;
	}
	public static void dbConnectUI() {
		// TODO Auto-generated method stub
		JOptionPane jop = new JOptionPane();

		jop.setSize(500, 500);

		JPanel godPanel = new JPanel();
		godPanel.setLayout(new BoxLayout(godPanel, BoxLayout.Y_AXIS));

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(2, 2));

		JTextField fieldOne = new JTextField();
		fieldOne.setEditable(true);
		fieldOne.setSize(100, 20);
		fieldOne.setText("");
		JLabel labelOne = new JLabel("Host:");
		textPanel.add(labelOne);
		textPanel.add(fieldOne);

		JTextField fieldTwo = new JTextField();
		fieldTwo.setEditable(true);
		fieldTwo.setSize(100, 20);
		fieldTwo.setText("");
		JLabel labelTwo = new JLabel("Port:");
		textPanel.add(labelTwo);
		textPanel.add(fieldTwo);

		JTextField fieldThree = new JTextField();
		fieldThree.setEditable(true);
		fieldThree.setSize(100, 20);
		fieldThree.setText("");
		JLabel labelThree = new JLabel("User:");
		textPanel.add(labelThree);
		textPanel.add(fieldThree);

		JTextField fieldFour = new JTextField();
		fieldFour.setEditable(true);
		fieldFour.setSize(100, 20);
		fieldFour.setText("");
		JLabel labelFour = new JLabel("Password:");
		textPanel.add(labelFour);
		textPanel.add(fieldFour);
		// jop.add(textPanel);
		godPanel.add(textPanel);
		// Define action for button press
		DBConnectActionListener actionListener = new DBConnectActionListener(fieldOne, fieldTwo, fieldThree, fieldFour);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

		ButtonGroup dbTypes = new ButtonGroup();
		JRadioButton sqlButton = new JRadioButton("SQL");
		JRadioButton pgButton = new JRadioButton("PostGress");
		sqlButton.setActionCommand("mysql");
		sqlButton.addActionListener(actionListener);

		pgButton.setActionCommand("pg");
		pgButton.addActionListener(actionListener);

		dbTypes.add(sqlButton);
		dbTypes.add(pgButton);
		radioPanel.add(sqlButton);
		radioPanel.add(pgButton);
		godPanel.add(radioPanel);

		JPanel connectPanel = new JPanel();
		JButton connectButton = new JButton("CoNnEcT bRo!");
		connectButton.setActionCommand("connect");
		connectButton.addActionListener(actionListener);
		connectPanel.add(connectButton);
		godPanel.add(connectPanel);

		// jop.add(godPanel);
		jop.showMessageDialog(null, godPanel, "Configure Connection:", -1);
	}

}
