package com.iggroup.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.iggroup.base.TestBase;

import jdk.internal.org.jline.utils.*;

public class ExtentManager extends TestBase {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		System.out.println("Sajith is working on the fix");
		/*
		 * if(extent==null) { extent=new ExtentReports(System.getProperty("user.dir")+
		 * "\\target\\surefire-report\\html\\extent.html",true);
		 * 
		 * extent.loadConfig(new File(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\extentconfig\\ReportConfig.xml"));
		 * 
		 * return extent; }
		 */
		
	
	
/*
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       
        
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Rahul Arora");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");
        
        
        return extent;*/
    }




}
