package com.collabera.mavenProject;

import java.util.Scanner;


import javax.swing.JPanel;
import javax.swing.JTextField;

//import javax.print.DocFlavor.INPUT_STREAM;

public class QueryMethods {
	
	private static JTextField textField;
	
	
	
	@SuppressWarnings("rawtypes")
	public static void dbConnect() {
		try {
			Class className = Class.forName("com.mysql.cj.jdbc.Driver");
			
					System.out.println(className);
					System.out.println(className.getClassLoader());
					
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//dbConnect End
	
	
	public static void clearTextF() {
		textField.setText("");
	}

	
	public static Scanner scanner = new Scanner(System.in);
	
	
	
	
}
