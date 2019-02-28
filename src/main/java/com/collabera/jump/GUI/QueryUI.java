package com.collabera.jump.GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.*;

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
        
        JScrollPane scrollPane = new JScrollPane(buildTable());
        
        queryFrame.add(input);
        queryFrame.add(scrollPane);

        queryFrame.validate(); 
        queryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return queryFrame;
	}
	
	private static JTable buildTable() {
		// TODO Auto-generated method stub
		TableModel dataModel = new AbstractTableModel() {
	          public int getColumnCount() { return 10; }
	          public int getRowCount() { return 10;}
	          public Object getValueAt(int row, int col) { return Integer.valueOf(row*col); }
	      };
	      JTable table = new JTable(dataModel);
		return table;
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
