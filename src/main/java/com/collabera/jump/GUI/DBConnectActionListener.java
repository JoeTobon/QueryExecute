package com.collabera.jump.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
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
    
    String hostS, portS, userS, passS, driver = "";
    
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
		hostS = host.getText();
		portS = port.getText();
		userS = user.getText();
		passS = password.getText();
		
		switch(e.getActionCommand())
		{
			case "mysql":
				driver = "mysql";
				break;
				
			case "connect":
				try
				{
					File file = new File("config.properties");
					FileWriter fw = new FileWriter(file);
					
					if(hostS.isBlank() || portS.isBlank() || userS.isBlank() || passS.isBlank() || driver.isBlank())
					{
						JOptionPane.showMessageDialog(null, "Please fill every field!", "Alert", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					
					fw.write("url=jdbc:" + driver + "://" + hostS + ":" + portS);
					fw.append("\nname=" + userS);
					fw.append("\npassword=" + passS);
					
					fw.close();
					
					JOptionPane.showMessageDialog(null, "DB Credentials Entered!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				} 
				catch (IOException e1) 
				{
					JOptionPane.showMessageDialog(null, "DB Credentials Entered!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			
		}
		
	}

}
