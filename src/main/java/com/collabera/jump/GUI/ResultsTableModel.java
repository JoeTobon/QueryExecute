package com.collabera.jump.GUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ResultsTableModel extends DefaultTableModel {

	public ResultsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultsTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public ResultsTableModel(Vector<? extends Vector> data, Vector<?> columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public void updateTable(Vector<? extends Vector> dataVector, Vector<?> columnIdentifiers) {
		// TODO Auto-generated method stub
		super.setDataVector(dataVector, columnIdentifiers);
	}
	
}
