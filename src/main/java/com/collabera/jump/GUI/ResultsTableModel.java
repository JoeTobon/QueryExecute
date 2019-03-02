package com.collabera.jump.GUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ResultsTableModel extends DefaultTableModel
{
	public ResultsTableModel() 
	{
		super();
	}

	public ResultsTableModel(int rowCount, int columnCount) 
	{
		super(rowCount, columnCount);
	}

	public ResultsTableModel(Vector<? extends Vector> data, Vector<?> columnNames) 
	{
		super(data, columnNames);
	}

	public void updateTable(Vector<? extends Vector> dataVector, Vector<?> columnIdentifiers)
	{
		super.setDataVector(dataVector, columnIdentifiers);
	}
	
}