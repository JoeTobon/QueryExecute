package com.collabera.jump.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DBConnectActionListener implements ActionListener
{
	private JTextField host;
	private JTextField port;
	private JTextField user;
	private JTextField password;
	
	private JRadioButton sqlButton;
    private JRadioButton pgButton;
    
    public DBConnectActionListener(JTextField host, JTextField port, JTextField user, JTextField password)
    {
    	this.host = host;
    	this.port = port;
    	this.user = user;
    	this.password = password;
    }
    
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("connect"))
		{
			String hostS, portS, userS, passS;
			
			hostS = host.getText();
			portS = port.getText();
			userS = user.getText();
			passS = password.getText();
			
			try
			{
				File file = new File("config.properties");
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				pw.append("Hi");
				
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
	}

}
