package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

public class QueryUI 
{
	public static JFrame buildUI()
	{
		// Create Frame
		JFrame queryFrame = new JFrame();
		queryFrame.setTitle("Bear Bite DB");
		queryFrame.setSize(500, 400);
		queryFrame.setVisible(true);
		queryFrame.setLayout(new BoxLayout(queryFrame.getContentPane(), BoxLayout.Y_AXIS));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		queryFrame.setLocation(dim.width/2-queryFrame.getSize().width/2, dim.height/2-queryFrame.getSize().height/2);

		JPanel titleBar = new JPanel();
		titleBar.setPreferredSize(new Dimension(600, 35));
		//titleBar.add(new JLabel(new ImageIcon("C:\\Users\\Joe\\Pictures\\bearlogo.jpg")));
		JLabel titleLabel = new JLabel("Enter Query:");
		titleBar.add(titleLabel);
		queryFrame.add(titleBar);

		JPanel textFieldPane = new JPanel();
		textFieldPane.setPreferredSize(new Dimension(600, 75));

		// TextField Definition
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(450, 30));

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
		JLabel lab1 = new JLabel("Results:");
		display.add(lab1);

		queryFrame.add(new JScrollPane(table));

		queryFrame.validate();
		queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return queryFrame;
	}

	private static JTable buildTable() 
	{
		// TODO Auto-generated method stub
		TableModel dataModel = new ResultsTableModel(0, 0);
		JTable table = new JTable(dataModel);
		return table;
	}

	private static JPanel buildPanel(QueryActionListener qActionListener) 
	{
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

	public static JFrame dbConnectUI() {
	       // TODO Auto-generated method stub
	       JFrame dbFrame = new JFrame();
	       dbFrame.setTitle("Connect");
	       dbFrame.setSize(400, 300);
	       dbFrame.setVisible(true);
	       dbFrame.setLayout(new BoxLayout(dbFrame.getContentPane(), BoxLayout.Y_AXIS));

	       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	       dbFrame.setLocation(dim.width/2-dbFrame.getSize().width/2, dim.height/2-dbFrame.getSize().height/2);

	       JPanel godPanel = new JPanel();
	       godPanel.setLayout(new BoxLayout(godPanel, BoxLayout.Y_AXIS));

	       JPanel textPanel = new JPanel();
	       textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
	       //textPanel.setSize(10, 50);

	       JTextField fieldOne = new JTextField();
	       fieldOne.setEditable(true);
	       fieldOne.setText("");
	       JLabel labelOne = new JLabel("<html><div><span style = ‘font-family:menlo; padding:100px;’>Host:</span></div><html>");
	       //JLabel labelOne = new JLabel(“Host:“);
	       textPanel.add(labelOne);
	       textPanel.add(fieldOne);


	       JTextField fieldTwo = new JTextField();
	       fieldTwo.setEditable(true);
	       fieldTwo.setPreferredSize(new Dimension(50, 20));
	       fieldTwo.setText("");
	       JLabel labelTwo = new JLabel("Port:");
	       textPanel.add(labelTwo);
	       textPanel.add(fieldTwo);

	       JTextField fieldThree = new JTextField();
	       fieldThree.setEditable(true);
	       fieldThree.setPreferredSize(new Dimension(50, 20));
	       fieldThree.setText("");
	       JLabel labelThree = new JLabel("User:");
	       textPanel.add(labelThree);
	       textPanel.add(fieldThree);

	       JTextField fieldFour = new JTextField();
	       fieldFour.setEditable(true);
	       fieldFour.setPreferredSize(new Dimension(50, 20));
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
	       //JRadioButton pgButton = new JRadioButton("PostGress");
	       sqlButton.setActionCommand("mysql");
	       sqlButton.addActionListener(actionListener);

	       //pgButton.setActionCommand("pg");
	       //pgButton.addActionListener(actionListener);

	       dbTypes.add(sqlButton);
	      // dbTypes.add(pgButton);
	       radioPanel.add(sqlButton);
	       //radioPanel.add(pgButton);
	       godPanel.add(radioPanel);

	       JPanel connectPanel = new JPanel();
	       JButton connectButton = new JButton("Connect");
	       connectButton.setActionCommand("connect");
	       connectButton.addActionListener(actionListener);
	       connectPanel.add(connectButton);
	       godPanel.add(connectPanel);

	       dbFrame.add(godPanel);

	       dbFrame.validate();

	       return dbFrame;

	   }
}
