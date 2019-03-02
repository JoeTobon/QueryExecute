package com.collabera.jump.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.collabera.jump.Connection.DBConnection;

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
				
			case "pg":
				driver = "postgresql";
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
					
					try 
					{
						Properties properties = new Properties();
		
						properties.load(new FileInputStream("config.properties"));
		
						Connection connection = DriverManager.getConnection(properties.getProperty("url"),
								properties.getProperty("name"), properties.getProperty("password"));
						
						if(!connection.isValid(1))
						{
							JOptionPane.showMessageDialog(null, "Invalid DB Credentials!", "Alert", JOptionPane.INFORMATION_MESSAGE);					
						}
						else
						{
							DBConnection.setConnection(DriverManager.getConnection(properties.getProperty("url"),
								properties.getProperty("name"), properties.getProperty("password")));
							JOptionPane.showMessageDialog(null, "DB Credentials Entered!", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					} 
					catch (SQLException e1) 
					{
						JOptionPane.showMessageDialog(null, "Invalid DB Credentials!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					} 
					catch (FileNotFoundException e1) 
					{
						JOptionPane.showMessageDialog(null, "DB Credential File Not Found!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					} 
					catch (IOException e1) 
					{
						JOptionPane.showMessageDialog(null, "IO Exception!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} 
				catch (IOException e1) 
				{
					JOptionPane.showMessageDialog(null, "IO Exception!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
			
		}
		
	}

}
