package com.collabera.jump.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class QueryActionListener implements ActionListener
{
	private JTextField textField;
	
	public QueryActionListener(JTextField textField)
	{
		this.textField = textField;
	}

	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "DB":
				System.out.println("DB");
				break;
			case "Execute":
				System.out.println("Execute");
				break;
			case "Clear":
				System.out.println("Clear");
				break;
		}
		
	}

}
