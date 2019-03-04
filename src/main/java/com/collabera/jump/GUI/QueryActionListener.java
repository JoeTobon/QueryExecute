package com.collabera.jump.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.collabera.jump.Connection.DBConnection;

public class QueryActionListener implements ActionListener
{
	private JTextField textField;
	private JTable table;

	public QueryActionListener(JTextField textField,  JTable table) 
	{
		this.textField = textField;
		this.table = table;
	}

	public void actionPerformed(ActionEvent a) 
	{
		switch(a.getActionCommand())
		{
			case "DB":
				QueryUI.dbConnectUI();
				break;
				
			case "Execute":		
				try 
				{
					if(!DBConnection.getConnection().isValid(1))
					{
						JOptionPane.showMessageDialog(null, "Invalid DB Credentials!", "Alert", JOptionPane.INFORMATION_MESSAGE);					
					}
					else
					{
						Statement statement = DBConnection.getConnection().createStatement();
						
						String query = textField.getText();
						
						query = cleanString(query);
						System.out.println(query);
									
						try 
						{
							
							if(query.toLowerCase().startsWith("select") || query.toLowerCase().startsWith("show"))
							{
								ResultSet resultSet = statement.executeQuery(query);
								ResultSetMetaData metadata = resultSet.getMetaData();
								updateTable(resultSet, metadata);
							}
							else
							{
								statement.execute(query);
								JOptionPane.showMessageDialog(null, "Query Executed!", "Alert", JOptionPane.INFORMATION_MESSAGE);
								
								String table[] = query.split(" ");
								
								if(query.toLowerCase().startsWith("update") )
								{
									String t = table[1];
									String newQuery = "select * from " + t;
									
									ResultSet resultSet = statement.executeQuery(newQuery);
									ResultSetMetaData metadata = resultSet.getMetaData();
									updateTable(resultSet, metadata);
								}
								else if(query.toLowerCase().startsWith("insert") || query.toLowerCase().startsWith("delete"))
								{
									String t = table[2];
									
									String newQuery = "select * from " + t;
									
									ResultSet resultSet = statement.executeQuery(newQuery);
									ResultSetMetaData metadata = resultSet.getMetaData();
									updateTable(resultSet, metadata);
								}
							}
								
						}
						catch (SQLException e) 
						{
							JOptionPane.showMessageDialog(null, "Invalid SQL Query!", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} 
				catch (SQLException e) 
				{
					JOptionPane.showMessageDialog(null, "Invalid DB Credentials!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(NullPointerException e)
				{
					JOptionPane.showMessageDialog(null, "Please Enter DB Credentials!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				}
				
				textField.setText("");
				break;
				
			case "Clear":
				textField.setText("");
				break;
		}
		
	}
	
	private void updateTable(ResultSet resultSet, ResultSetMetaData setData) throws SQLException 
	{
		int columnCount = setData.getColumnCount();
		Vector<String> columnNames = new Vector<>();
		Vector<Vector<Object>> vector = new Vector<Vector<Object>>();
		
		for (int i = 1; i < columnCount + 1; i++)
		{
			columnNames.add(setData.getColumnName(i));
		}
		
		int row;
		
		while (resultSet.next()) 
		{
			row = resultSet.getRow() - 1;
			vector.add(new Vector<Object>());
			
			for (int i = 1; i < columnCount + 1; i++) 
			{
				vector.get(row).add(resultSet.getObject(i));
			}
		}
		
		ResultsTableModel model = (ResultsTableModel) this.table.getModel();
		
		
		model.setDataVector(vector, columnNames);
		
	}
	
	private String cleanString(String dirtyString)
	{
		String result = "";
		
	    for(int i = 0; i < dirtyString.length(); i++)
	    {
	    	if(!(dirtyString.charAt(i) == '\\'))
	    	{
	    		result += dirtyString.charAt(i);
	    	}
	    }
	    
	    return result;
	}
}

