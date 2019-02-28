package com.collabera.mavenProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueryActionListener implements ActionListener
{
	private JTextField textField;
	private JPanel display;
	public JButton dbConnectBut;
	
	
	public QueryActionListener(JTextField textField){
		this.textField = textField;
	}
	
	
	public void actionPerformed(ActionEvent e) throws NullPointerException{
		switch(e.getActionCommand()){
			case "DB":
				try {
					QueryMethods.dbConnect();
	//				textField.setText("Successful DB Connection \n" +
	//				"Please Enter Your Query Below\n");
					JOptionPane.showMessageDialog(null, "Successfully Connected to DataBase");
					//dbConnectBut.setEnabled(false);
					
					//QueryMethods.clearTextF();
					
				} catch (NullPointerException exception){
					exception.printStackTrace();
				}
					break;
			case "Execute":
				System.out.println("Execute");
				break;
			case "Clear":
				textField.setText("");
				break;
		}
		
		
	}

}
