package com.iggroup.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties config= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		//System.out.println(System.getProperty("user.dir"));
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		System.out.println(config.getProperty("testurl"));
	
		
		Properties OR= new Properties();
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		//System.out.println(System.getProperty("user.dir"));
		OR.load(fis);
		System.out.println(OR.getProperty("bmlBtn"));

	}

}
