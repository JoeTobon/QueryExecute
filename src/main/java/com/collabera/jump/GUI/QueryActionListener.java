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
import java.util.Properties;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;

public class QueryActionListener implements ActionListener {
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
				System.out.println("DB");
				break;
			case "Execute":	
				try 
				{
					Properties properties = new Properties();
	
					properties.load(new FileInputStream("config.properties"));
	
					Connection connection = DriverManager.getConnection(properties.getProperty("url"),
							properties.getProperty("name"), properties.getProperty("password"));
					
					if(!connection.isValid(1))
					{
						System.out.println("Please re-enter credentials!");						
					}
					else
					{
						Statement statement = connection.createStatement();
						
						String query = textField.getText();
						System.out.println(query);
			
						try 
						{
							
							if(query.toLowerCase().startsWith("select"))
							{
								ResultSet resultSet = statement.executeQuery(query);
								ResultSetMetaData metadata = resultSet.getMetaData();
								updateTable(resultSet, metadata);
								/*
								while (resultSet.next()) 
								{
									ResultSetMetaData metadata = resultSet.getMetaData();
									
									String data[] = new String[metadata.getColumnCount()];
				
									for (int i = 1; i <= metadata.getColumnCount(); i++) 
									{
										data[i - 1] = resultSet.getString(i);
									}
				
									System.out.println(Arrays.toString(data));
				
								}*/
							}
							else
							{
								statement.execute(query);
							}
						}
						catch (SQLException e) {
						System.out.println("Invalid SQL Query!");
					}
				}
			} catch (SQLException e) {
				System.out.println("Invalid DB credentials. Re-enter!");
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
			} catch (IOException e) {
				System.out.println("IO exception");
			}

			break;
		case "Clear":
			textField.setText("");
			break;
		}
	}
						
	private void updateTable(ResultSet resultSet, ResultSetMetaData setData) throws SQLException {
		int columnCount = setData.getColumnCount();
		Vector<String> columnNames = new Vector<>();
		Vector<Vector<Object>> vector = new Vector<Vector<Object>>();
		for (int i = 1; i < columnCount + 1; i++) {
			columnNames.add(setData.getColumnName(i));
		}
		System.out.println(columnNames);
		int row;
		while (resultSet.next()) {
			row = resultSet.getRow() - 1;
			vector.add(new Vector<Object>());
			for (int i = 1; i < columnCount + 1; i++) {
				vector.get(row).add(resultSet.getObject(i));
			}
		}
		ResultsTableModel model = (ResultsTableModel) this.table.getModel();
		model.setDataVector(vector, columnNames);
	}
}
