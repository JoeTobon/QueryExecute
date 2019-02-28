package com.collabera.mavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("configprops"));
		
		System.out.println(properties);
	}

}
